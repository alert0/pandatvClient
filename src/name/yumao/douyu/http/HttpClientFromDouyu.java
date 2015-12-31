package name.yumao.douyu.http;

import java.util.ArrayList;
import java.util.List;

import name.yumao.douyu.utils.ServerUtils;
import name.yumao.douyu.vo.DouyuApiServersVo;
import name.yumao.douyu.vo.PandaInfo;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

public class HttpClientFromDouyu {
	
	private static Logger logger = Logger.getLogger(HttpClientFromDouyu.class);	

	public static String QueryDouyuRoomNum(String roomName){
		String roomNum = "";
		HttpEntity entity = null;
		final HttpGet get = new HttpGet("http://www.douyutv.com/api/client/room/" + roomName + "?cdn=ws");
		try{
			  
		      get.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/44.0.2403.157 Safari/537.36");
			  HttpResponse response = HttpClientFactory.getHttpClient().execute(get);
			 if (response.getStatusLine().getStatusCode() == 200) {
			    entity = response.getEntity(); 
			    String htmlEntity = EntityUtils.toString(entity);
			    
			    roomNum = ServerUtils.QueryRoomId(htmlEntity);
			}
			
		}catch (Exception e) {
			return roomNum;
		} finally {
			get.abort();
			if (entity != null) { 
				EntityUtils.consumeQuietly(entity); 
			} 

		}
		return roomNum;
	}
	public static List<DouyuApiServersVo> QueryLoginServer(String roomNum){
		
		List<DouyuApiServersVo> roomApiServersVo = new ArrayList<DouyuApiServersVo>(); 
		HttpEntity entity = null;
		 final HttpGet get = new HttpGet("http://www.douyutv.com/api/client/room/" + roomNum + "?cdn=ws");
		try{
			 
		      get.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/44.0.2403.157 Safari/537.36");

			  HttpResponse response = HttpClientFactory.getHttpClient().execute(get);
			if (response.getStatusLine().getStatusCode() == 200) {
			    entity = response.getEntity(); 
			    String htmlEntity = EntityUtils.toString(entity);
			    //logger.info("QueryLoginServer: " + htmlEntity );
			    roomApiServersVo = ServerUtils.QueryLoginServerList(htmlEntity);
			}
			
		}catch (Exception e) {
			return roomApiServersVo;
		} finally {
			get.abort();
			if (entity != null) { 
				EntityUtils.consumeQuietly(entity); 
			} 
		}
		return roomApiServersVo;
	}
	
	
	
	 public static PandaInfo QueryDouyuDownloadUrl(String roomNum)
	  {
		 PandaInfo vo = new PandaInfo();
	    HttpEntity entity = null;
	    HttpGet get =null;
	    try
	    {
	      String apiurl = "http://api.m.panda.tv/ajax_room?roomid=%s&type=json&__version=1.0.0.1041&__plat=mobile";
	      apiurl = String.format(apiurl, roomNum);
	      get =  new HttpGet(apiurl);
	      get.setHeader("xiaozhangdepandatv", "1");
	      String htmlEntity = "";
	    
		  HttpResponse response = HttpClientFactory.getHttpClient().execute(get);
	      if (response.getStatusLine().getStatusCode() == 200)
	      {
	        entity = response.getEntity();
	        htmlEntity = EntityUtils.toString(entity);
	        
	        vo = ServerUtils.QueryDouyuDownloadUrl(htmlEntity);
	      }
	      
	      
	      //logger.info(vo);
	     
	    }
	    catch (Exception e)
	    {
	      return vo;
	      
	    } finally {
	    	get.abort();
	    	if (entity != null) { 
				EntityUtils.consumeQuietly(entity); 
			} 
	    }
	    return vo;
	  }
//	public static boolean isOnline(String roomNum){
//		String status = "";
//		try{
//			HttpGet get = new HttpGet("http://www.douyu.tv/"+roomNum);
//			HttpResponse response = ThreadHttpClient.getInstance().getHttpclient().execute(get);
//			if (response.getStatusLine().getStatusCode() == 200) {
//			    HttpEntity entity = response.getEntity(); 
//			    String htmlEntity = EntityUtils.toString(entity);
//			    status = ServerUtils.QueryRoomApi(htmlEntity).getData().getShow_status();
//			}
//			get.abort();
//		}catch (Exception e) {
//			return false;
//		}
//		return Boolean.parseBoolean(status);
//	}
//	public static String showAnnounce(){
//		String announce = "";
//		try{
//			HttpGet get = new HttpGet("http://share.teemo.name/DouyuAssistant/Announce");
//			HttpResponse response = ThreadHttpClient.getInstance().getHttpclient().execute(get);
//			if (response.getStatusLine().getStatusCode() == 200) {
//			    HttpEntity entity = response.getEntity(); 
//			    String[] ans = EntityUtils.toString(entity).split("[|]");
//			    announce = ans[(int)(Math.random()*ans.length)];
//			}
//			get.abort();
//		}catch (Exception e) {
//			announce = "公告获取失败";
//		}
//		return announce.trim();
//	}
}
