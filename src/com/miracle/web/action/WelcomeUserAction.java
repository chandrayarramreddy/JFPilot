package com.miracle.web.action;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.miracle.service.restclient.ConnectRestService;
import com.opensymphony.xwork2.ActionSupport;

public class WelcomeUserAction extends ActionSupport implements ServletRequestAware, ServletResponseAware { //TurnipAbstractAction{

	private String username;
	private String password;
	private String message;

	private HttpServletRequest httpServletRequest = ServletActionContext.getRequest();
	private HttpServletResponse httpServletResponse = ServletActionContext.getResponse();
	private List<String> orgNames = new ArrayList<String>();

	public List<String> getOrgNames() {
		return orgNames;
	}

	public void setOrgNames(List<String> orgNames) {
		this.orgNames = orgNames;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	ConnectRestService info = null;
	public String execute() {	
		try{
	if (!username.isEmpty()) {
			info = new ConnectRestService();
			String outputresult = info.getCustomerVendorList(username);
			String[] name = outputresult.split("");
			StringTokenizer sb = new StringTokenizer(outputresult, "|");
			while (sb.hasMoreElements()) {
				String s = (String) sb.nextElement();			
				String alphaOnly = s.replaceAll("[^\\p{Alpha}]+", "").replaceAll("CompName", "");
				orgNames.add(alphaOnly);
			}
			/*if(!orgNames.isEmpty()){
				System.out.println("orgNames :::"+orgNames);
				orgNames.add("No Result");
			}*/
			
				message = "SUCCESS";
			
				 
				
		} else  {
			message = "No Result";
		}
		}
		catch (Exception e) {
			message = "FAIL";
		}
		
	
	
		return message;
	}

	
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    public void setServletResponse(HttpServletResponse httpServletResponse) {
        this.httpServletResponse = httpServletResponse;
    }

}