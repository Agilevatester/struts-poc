package org.apache.struts.example; 
  
import com.opensymphony.xwork2.ActionSupport; 
  
public class WelcomeAction extends ActionSupport { 
   
    // Java bean to hold the form parameters 
    private String userName; 
   
    public String getUserName() { 
        return userName; 
    } 
   
    public void setUserName(String userName) { 
        this.userName = userName; 
    } 
      
    // All struts logic goes here 
    public String execute() { 
        return SUCCESS; 
    } 
  
}