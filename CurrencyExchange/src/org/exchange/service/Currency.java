package org.exchange.service;

import org.exchange.client.ExchangeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/currency")
public class Currency {
	@Autowired
	private ExchangeClient exchangeClient;
	
	@RequestMapping(value="/rates", method=RequestMethod.GET)
	public @ResponseBody String getAllCurrencyExcRates() {
		String result = exchangeClient.getAllCurrencyExcRates();
		//Move the json conversion to utility class.
		return result;
	}
	
	@RequestMapping(value="/currencies", method=RequestMethod.GET)
	public String getAllCurrencies() {
		String result = exchangeClient.getAllCurrencies();
		//Move the json conversion to utility class.
		return result;
	}
	
	/*
	@GET
	@Produces("application/json")
	@Path("/currencyExcRate")
	public String getCurrencyExcRate(@QueryParam("amount")double amount, @QueryParam("currency")String currency) throws JSONException{
		Client client = Client.create();
		WebResource webResource = client.resource("http://openexchangerates.org/api/latest.json?app_id=ba8b4907fd044c47a01407599c374406");
		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
		if(response.getStatus()!=200){
			throw new RuntimeException("HTTP Error: "+ response.getStatus());
		}
		String result = response.getEntity(String.class);
		JSONObject root = new JSONObject(result);
		JSONObject rates = root.getJSONObject("rates");
		String rate = rates.get(currency).toString();
		double toCurrVal = (amount * Double.valueOf(rate));
		System.out.println(toCurrVal);
		return String.valueOf(toCurrVal);
	}
	
	@GET
	@Produces("application/json")
	@Path("/currencyConversion")
	public String convertCurrency(@QueryParam("amount") Double amount, @QueryParam("fromCurr") String fromCurr,@QueryParam("toCurr") String toCurr) throws JSONException{
		Client client = Client.create();
		WebResource webResource = client.resource("http://openexchangerates.org/api/latest.json?app_id=ba8b4907fd044c47a01407599c374406");
		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
		if(response.getStatus()!=200){
			throw new RuntimeException("HTTP Error: "+ response.getStatus());
		}
		String result = response.getEntity(String.class);
		JSONObject root = new JSONObject(result);
		JSONObject roots = root.getJSONObject("rates");
		double fromCurrRate = (double) roots.get(fromCurr);
		double toCurrRate = (double) roots.get(toCurr);
		System.out.println(fromCurrRate + " " + toCurrRate);
		double toCurrVal = (amount * toCurrRate)/fromCurrRate;
		System.out.println("---------" + toCurrVal);
		return String.valueOf(toCurrVal);
	}
*/
	public ExchangeClient getExchangeClient() {
		return exchangeClient;
	}

	public void setExchangeClient(ExchangeClient exchangeClient) {
		this.exchangeClient = exchangeClient;
	}
}
