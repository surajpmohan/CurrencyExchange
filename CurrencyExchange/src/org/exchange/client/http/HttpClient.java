package org.exchange.client.http;

import org.exchange.client.bean.RequestBean;
import org.exchange.client.bean.ResponseBean;

public interface HttpClient {
	public ResponseBean get(RequestBean requestBean);
}
