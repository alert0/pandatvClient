package name.yumao.douyu.http;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

public class HttpClientFactory {

	private static HttpClient client;
	private static PoolingHttpClientConnectionManager manager;

	public static synchronized HttpClient getHttpClient() {

		if (client == null) {
			RequestConfig config = RequestConfig.custom()
					.setConnectTimeout(Config.CONNECTION_TIMEOUT)
					.setSocketTimeout(Config.SO_TIMEOUT)
					.setConnectionRequestTimeout(Config.CONNECTIONREQUESTTIMEOUT)
					
					.build();
			manager = new PoolingHttpClientConnectionManager();
			client = HttpClients.custom().setConnectionManager(manager).setDefaultRequestConfig(config).build();
		}

		return client;
	}

}