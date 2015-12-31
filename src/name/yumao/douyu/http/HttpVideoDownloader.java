package name.yumao.douyu.http;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTextField;

import name.yumao.douyu.mina.LoginMinaThread;
import name.yumao.douyu.vo.DouyuApiServersVo;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpVideoDownloader {
	
	public static void download(JTextField inNum, JButton butnSure, String url,
			String filePath,List<DouyuApiServersVo> loginServerList ) throws ClientProtocolException, IOException {


		HttpResponse response = null;
		HttpGet httpget = new HttpGet(url);
		httpget.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/44.0.2403.157 Safari/537.36");

		try {
			
			//httpget.setConfig(requestConfig);

			System.out.println("Executing request " + httpget.getRequestLine());
		    response = HttpClientFactory.getHttpClient().execute(httpget);

			if (response.getStatusLine().getStatusCode() == 200) {
				
				DownloaderThead.setTime();
				File file = new File(filePath+".flv");
//				File dir = new File(file.getParent());
//				if (!dir.exists()) {
//					dir.mkdirs();// 目录不存在的情况下，创建目录。
//				}
//				
				//loginMina(inNum,  butnSure,filePath ,loginServerList);
			
		
				// Get hold of the response entity
				HttpEntity entity = response.getEntity();

				// If the response does not enclose an entity, there is no
				// need
				// to bother about connection release
				if (entity != null) {
					down(inNum, response, file, entity,httpget);
				}
			}
			
		} finally {
			httpget.abort();
			if (response != null) { 

	                 EntityUtils.consumeQuietly(response.getEntity()); 

	        } 
		}
			

	}

	private static void down(JTextField inNum,
			HttpResponse response, File file, HttpEntity entity,HttpGet httpget )
			throws IOException {

		
		long downloadedSize = 0;

		InputStream is = entity.getContent();

		FileOutputStream fileout = new FileOutputStream(file);
		// 缓存200KB
		byte[] buffer = new byte[204800*10];
		int ch = 0;
		
		try {
			Date last = new Date();
			while ((ch = is.read(buffer)) != -1) {
				fileout.write(buffer, 0, ch);
				downloadedSize += ch;
				Date now = new Date();
				if (((now.getTime() - last.getTime()) / 1000) >= 10) {
					System.out.println(now + " 正在下载房间：" + inNum.getText()
							+ "，已下载大小: " + downloadedSize
							/ (1024 * 1024) + "m");
					last = now;
				} 
				
				if(Config.TIMEOUT!=-1 &&  ((now.getTime() - last.getTime()) / 1000) >= 60 * Config.TIMEOUT ) {
					httpget.abort();
					if (response != null) { 

			                 EntityUtils.consumeQuietly(response.getEntity()); 

			        } 
				}

			}
			// do something useful with the response
		} catch (IOException ex) {
			// In case of an IOException the connection will be
			// released
			// back to the connection manager automatically
			throw ex;
		} finally {
			// Closing the input stream will trigger connection
			// release
			fileout.flush();
			fileout.close();
			is.close();
			
		}
	}

	private static void loginMina(JTextField inNum, JButton butnSure,
			String filePath,List<DouyuApiServersVo> loginServerList) {
		// 启动弹幕获取进程 将弹幕写成ass文件
		try {
//		try {
//			Integer.parseInt(inNum.getText());
//		} catch (Exception numEx) {
//			// 进行房间参数的号码转换
//			inNum.setText(HttpClientFromDouyu.QueryDouyuRoomNum(inNum.getText()));
//		}
		// 获取登入服务器列表
	//	List<DouyuApiServersVo> loginServerList = HttpClientFromDouyu.QueryLoginServer(inNum.getText());
		// 拉起弹幕获取进程
		LoginMinaThread loginMina = new LoginMinaThread(filePath + ".ass",loginServerList, inNum, butnSure);
		
		Thread loginMinaThread = new Thread(loginMina);
		loginMinaThread.start();
		
	} catch(Exception e ) {
		e.printStackTrace();
	}

		
	}
}
