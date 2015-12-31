package name.yumao.douyu.http;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import javax.swing.JButton;
import javax.swing.JTextField;

import name.yumao.douyu.vo.PandaInfo;
import name.yumao.douyu.vo.PandaInfo.DataEntity.InfoEntity.VideoinfoEntity;

import org.apache.http.client.ClientProtocolException;
import org.apache.log4j.Logger;

public class DownloaderThead implements Runnable{
	private static Logger logger = Logger.getLogger(DownloaderThead.class);	
	private JTextField inNum;
	private JButton butnSure;
	private Calendar calendar;
	private static int time = 1;
	private static boolean closed = false;
	
	public DownloaderThead(JTextField inNum){
		logger.info("Sub:初始化录像进程");
		this.inNum = inNum;
		//this.butnSure = butnSure;
	}
	
	public static  synchronized int getTime() {
		if(time  > 10 ) 
			return time;
		else 
			return time++;
	}
	
	public static synchronized void setclosed(boolean b) {
		closed = b;
	}
	
	
	public static  synchronized boolean getclosed(boolean b) {
		return closed;
	}
	
	public static synchronized void setTime() {
		time = 1;
	}
	
	@Override
	public void run() {
		//int i = 1;
		while(true){
			this.calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd^HH-mm-ss");
			
			
		
			
			try {
				
				PandaInfo vo = HttpClientFromDouyu.QueryDouyuDownloadUrl(inNum.getText());
				VideoinfoEntity Videoinfo = vo.getData().getInfo().getVideoinfo();
			if(vo!= null &&  Videoinfo.getStatus().equals("2") ) {
				StringBuffer sb= new StringBuffer();
				Videoinfo.getStreamAddress("",sb);
				//logger.info( vo.getRtmp_url() + "/" + vo.getRtmp_live()  );
			
				
			   String path = "record"+ 
						File.separator 
						+inNum.getText()
						+File.separator 
						+ simpleDateFormat.format(calendar.getTime() );
			   		//	+"^" + inNum.getText();
				
				String pathfile = path +  File.separator + simpleDateFormat2.format(calendar.getTime());
				
				roomName(vo.getData().getInfo().getRoominfo().getName() , path);

				try {
					HttpVideoDownloader.download(inNum,
							butnSure,
							sb.toString(),
							pathfile+"^" + inNum.getText(),
							null
							);
				} catch (ClientProtocolException e) {
					
					e.printStackTrace();
					logger.info(e.getMessage()  );
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					logger.info(e.getMessage()  );
				}
	
				
			}
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			

			try{

				Thread.sleep(500 * getTime() );
				logger.debug(time );
				
			}catch (Exception e) {
				
			}
		}
	}

	private void roomName(String roomname, String path) {
		
		
		 roomname = roomname.replaceAll("[\\\\/:*?\"<>|]", "");
		
		
		File f = new File(path+ File.separator + roomname );
									
		try {
			File dir = new File(f.getParent());
		    if (!dir.exists()) {    
			   dir.mkdirs();// 目录不存在的情况下，创建目录。    
		    }   
			f.createNewFile();
			logger.info(f.getAbsolutePath() );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
