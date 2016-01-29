package org.exchange.client.impl;

import org.exchange.client.ExchangeClient;
import org.exchange.client.bean.RequestBean;
import org.exchange.client.bean.ResponseBean;
import org.exchange.client.http.HttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ExchangeClientImpl implements ExchangeClient{
	
	@Autowired
	private HttpClient httpClient;
	@Override
	//We may need to convert the return type from string to an object type if need further modification on the response.
	public String getAllCurrencyExcRates() {
		RequestBean requestBean = new RequestBean();
		//Get from property file.
		requestBean.setUrl("http://openexchangerates.org/api/latest.json?app_id=ba8b4907fd044c47a01407599c374406");
		ResponseBean responseBean = httpClient.get(requestBean);
		//Need to add response code to response bean to verify the status.
		String response = responseBean.getResponseBody();
		return response;
	}
	
	@Override
	public String getAllCurrencies() {
		RequestBean requestBean = new RequestBean();
		//Get from property file.
		requestBean.setUrl("http://openexchangerates.org/api/currencies.json?app_id=ba8b4907fd044c47a01407599c374406");
		ResponseBean responseBean = httpClient.get(requestBean);
		//Need to add response code to response bean to verify the status.
		String response = responseBean.getResponseBody();
		return response;
	}
	public HttpClient getHttpClient() {
		return httpClient;
	}
	public void setHttpClient(HttpClient httpClient) {
		this.httpClient = httpClient;
	}
}
