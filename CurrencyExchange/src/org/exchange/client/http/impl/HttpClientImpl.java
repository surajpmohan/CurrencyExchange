package org.exchange.client.http.impl;

import javax.annotation.ManagedBean;

import org.exchange.client.bean.RequestBean;
import org.exchange.client.bean.ResponseBean;
import org.exchange.client.http.HttpClient;
import org.springframework.stereotype.Component;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

@Component
public class HttpClientImpl implements HttpClient {

	@Override
	public ResponseBean get(RequestBean requestBean) {
		Client client = Client.create();
		WebResource webResource = client.resource(requestBean.getUrl());
		System.out.println("URL: " + requestBean.getUrl());
		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
		if(response.getStatus()!=200){
			throw new RuntimeException("HTTP Error: "+ response.getStatus());
		}
		String result = response.getEntity(String.class);
		ResponseBean responseBean = new ResponseBean();
		responseBean.setResponseBody(result);
		return responseBean;
	}

}
