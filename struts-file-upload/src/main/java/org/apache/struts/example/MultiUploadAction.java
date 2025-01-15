package org.apache.struts.example;

import com.opensymphony.xwork2.ActionSupport;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class MultiUploadAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

    private File[] upload;
    private String[] uploadFileName;
    private String[] uploadContentType;

    public String execute() throws Exception {
        return INPUT;
    }

    public File[] getUpload() {
        return upload;
    }

    public void setUpload(File[] upload) {
        this.upload = upload;
    }

    public String[] getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String[] uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public String[] getUploadContentType() {
        return uploadContentType;
    }

    public void setUploadContentType(String[] uploadContentType) {
        this.uploadContentType = uploadContentType;
    }
    

	 

	public String view() throws Exception {
		System.out.println(" view Method called ---");
		return SUCCESS;
	}

	public String upload() {
		System.out.println(" MultiUploadAction upload Method called ---");
		
		String uploadDir = "c:\\tmp\\uploads";
		File uploadDirectory = new File(uploadDir);

		if (!uploadDirectory.exists()) {
			uploadDirectory.mkdir();
		}
		
		
		for (int i=0;i<upload.length;i++) {
			File u=upload[i];
			String fileName=uploadFileName[i];
			String contentType=uploadContentType[i];
			
			if(u!=null) {
				File dst = new File(uploadDirectory, fileName);
				try {
					FileUtils.copyFile(u,dst);
					System.out.print(" File Destinationn : " +dst);
					System.out.print(" File Destinationn : " +dst.getCanonicalPath());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return ERROR;
				}
		
				
			}
			
					
		}
		
		if(upload == null||uploadFileName == null||uploadContentType == null) {
			
			return ERROR;
		}
		return SUCCESS;
	
	}
	/*
	 * public String getFileName() { return fileName; }
	 * 
	 * public void setFileName(String fileName) { this.fileName = fileName; }
	 */

}