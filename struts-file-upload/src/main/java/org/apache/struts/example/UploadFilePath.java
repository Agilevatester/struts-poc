/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.struts.example;

//import org.apache.struts2.ActionSupport;
import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * <code>Allows upload a file</code>
 */
public class UploadFilePath extends ActionSupport {

	private static final long serialVersionUID = 1L;

	// private String Local
	private File upload;
	private String uploadContentType;
	private String fileName;

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}


	 

	public String view() throws Exception {
		System.out.println(" view Method called ---");
		return SUCCESS;
	}

	public String upload() {
		System.out.println(" upload Method called ---");
		if (upload != null && upload.length() > 0) {
			try {

				System.out.println(	" upload Method called ## upload!=null ---" + upload + " uploadFileName : " + fileName);
				String uploadDir = "c:\\tmp\\uploads";
				File uploadDirectory = new File(uploadDir);

				if (!uploadDirectory.exists()) {
					uploadDirectory.mkdir();
				}

				File destFile = new File(uploadDirectory, fileName);

				FileInputStream inputStream = new FileInputStream(upload);
				FileOutputStream outputStream = new FileOutputStream(destFile);

				byte[] buffer = new byte[1024];
				int length;
				while ((length = inputStream.read(buffer)) > 0) {
					outputStream.write(buffer, 0, length);
				}
				inputStream.close();
				outputStream.close();
				System.out.println("FIle upload successful --> uploadDirectory : " + uploadDirectory.getAbsolutePath());
				System.out.println("FIle upload successful --> destFile  " + destFile.getAbsolutePath());
				return SUCCESS;
			} catch (IOException e) {
				System.err.println("FIle upload successful --> IOException " + e.getMessage());
				addActionError("File upload failed: " + e.getMessage());
				return ERROR;
			}
		} else {
			addActionError("No file uploaded.");
			System.err.println("FIle upload VIEW --> No file uploaded ");
			return "VIEW";
		}
	}
}
