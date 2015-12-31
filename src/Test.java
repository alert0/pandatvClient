

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

public class Test {
	public static void main(String[] args) throws ClientProtocolException, IOException {
		
		
	// HttpClient c=	HttpClientFactory.getHttpClient();
	 
	 
	 HttpHost proxy = new HttpHost("120.195.198.129", 80);  
	 DefaultProxyRoutePlanner routePlanner = new DefaultProxyRoutePlanner(proxy);  
	 CloseableHttpClient httpclient = HttpClients.custom()  
			        .setRoutePlanner(routePlanner)  
			        .build();  

   
		
		HttpPost  httpRequst =  new HttpPost("http://vg.duobaogame.com/index/vote");
		List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();  
		params.add(new BasicNameValuePair("phone", "15978945645"));  
		params.add(new BasicNameValuePair("broadId", "1"));  
		
		
		
		String result = "";
		
		 try {  
			            httpRequst.setEntity(new UrlEncodedFormEntity(params,HTTP.UTF_8));  
			           HttpResponse httpResponse = httpclient.execute(httpRequst);  
			          if(httpResponse.getStatusLine().getStatusCode() == 200)  
			            {  
			               HttpEntity httpEntity = httpResponse.getEntity();  
			               result = EntityUtils.toString(httpEntity);//取出应答字符串  
			           }  
			       } catch (UnsupportedEncodingException e) {  
			           // TODO Auto-generated catch block  
			           e.printStackTrace();  
			           result = e.getMessage().toString();  
		       }  

		 		System.out.println(result);
		
		
	}
}
