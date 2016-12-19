package com.miracle.service.restclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;


public class ConnectRestService {
	String outputresult;

//	public String getCustomerVendorList(String vendorId) {
	public String getCustomerVendorList(String vendor_id) {
		try {
			URL url = new URL(TurnipWebConstants.VENDOR_CUSTOMER_LIST_URL+"?vendor_id="+vendor_id);
			String method = TurnipWebConstants.METHOD_NAME;
			outputresult = commonMethoForService(url, method);
			System.out.println("CustomerInfo :: " + outputresult);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return outputresult;

	}
		
	
	public String commonMethoForService(URL url, String method) throws MalformedURLException, IOException, ProtocolException {
		try {
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod(method);
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			System.out.println("Output from Server .... \n");
			String result;
			String result1;
			String result2;
			while ((result = br.readLine()) != null) {
				result1 = result.replace(",", "|");				
				result2 = result1.replace("[", "|");
				outputresult =result2.replace("]", "|");
				System.out.println("hello" + result2);
			}
			System.out.println("CallService :: " + outputresult);
			conn.disconnect();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return outputresult;
	}

}
