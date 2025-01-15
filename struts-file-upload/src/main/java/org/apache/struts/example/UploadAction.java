package org.apache.struts.example;

import com.opensymphony.xwork2.ActionSupport;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UploadAction extends ActionSupport {

    private static final long serialVersionUID = 1L;

    //private String Local
    private File upload;
    private String uploadContentType;
    private String uploadFileName;


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

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public String view() throws Exception{
    	System.out.println(" view Method called ---");
    	return SUCCESS;
    }
    public String upload() {
    	System.out.println(" upload Method called ---");
        if (upload != null && upload.length() > 0) {
            try {
            	System.out.println(" upload Method called ## upload!=null ---"+upload+" uploadFileName : "+uploadFileName);
                String uploadDir = "c:\\tmp\\uploads"; 
                File uploadDirectory = new File(uploadDir);
                
                if (!uploadDirectory.exists()) {
                    uploadDirectory.mkdir();
                }
    
                File destFile = new File(uploadDirectory, uploadFileName);
    
                FileInputStream inputStream = new FileInputStream(upload);
                FileOutputStream outputStream = new FileOutputStream(destFile);
    
                byte[] buffer = new byte[1024];
                int length;
                while ((length = inputStream.read(buffer)) > 0) {
                    outputStream.write(buffer, 0, length);
                }
                inputStream.close();
                outputStream.close();
                System.out.println("FIle upload successful --> uploadDirectory : "+uploadDirectory.getAbsolutePath());
                System.out.println("FIle upload successful --> destFile  "+destFile.getAbsolutePath());
                return SUCCESS;
            } catch (IOException e) {
            	System.err.println("FIle upload successful --> IOException "+e.getMessage());
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