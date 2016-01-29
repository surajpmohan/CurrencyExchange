package org.exchange.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

@Path("/currency")
public class Currency {
	@GET
	@Produces("application/json")
	@Path("/rates")
	public String getCurrency(){
		Client client = Client.create();
		WebResource webResource = client.resource("http://openexchangerates.org/api/latest.json?app_id=ba8b4907fd044c47a01407599c374406");
		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
		if(response.getStatus()!=200){
			throw new RuntimeException("HTTP Error: "+ response.getStatus());
		}
		
		String result = response.getEntity(String.class);
		return result;
	}
}
