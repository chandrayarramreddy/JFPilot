package com.miracle.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

public abstract class TurnipAbstractAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
	   
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*	
public String execute() {
	 return SUCCESS;
			
		//httpServletResponse= this.setResponseHeader(httpServletResponse);
}*/
    public HttpServletResponse setResponseHeader(HttpServletResponse servletResponse) {
    	System.out.println("setResponseHeader--->");
		servletResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		servletResponse.setHeader("Pragma", "no-cache");
		servletResponse.setDateHeader("Expires", 0);
		servletResponse.setContentType("text");
		servletResponse.setCharacterEncoding("UTF-8");
		return servletResponse;
		
	}
     public boolean isValideUser(HttpServletRequest httpServletRequest){
    	 System.out.println("isValideUser--->");
        if(httpServletRequest.getSession(false).getAttribute("USER_ID").toString() != null){
        return true;
        }
        else return false; 
        
    }
}
