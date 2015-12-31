package name.yumao.douyu;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import javax.swing.JTextField;

import name.yumao.douyu.http.DownloaderThead;
import name.yumao.douyu.http.HttpClientFromDouyu;




public class Test {
	public static void main(String[] args) {
		StringBuffer sb= new StringBuffer();
	 System.out.println(
			 HttpClientFromDouyu.QueryDouyuDownloadUrl("66666")
			 .getData().getInfo().getVideoinfo().getStreamAddress("", sb) );
	 
	 System.out.println(sb.toString()  );
	}
	
	static class BeeperControl{
		private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(5);
		
		public void beepForAnHour(){
			JTextField inNum=new JTextField(10);
			inNum.setText("4809");
			
			final Runnable beeper=new DownloaderThead(inNum);
			
			
			final ScheduledFuture<?>beeperHandle=scheduler.scheduleAtFixedRate(beeper,0,30,TimeUnit.SECONDS);
			
			
			scheduler.schedule(new Runnable(){
			public void run(){beeperHandle.cancel(true);}
			},31,TimeUnit.SECONDS);
		}
	}

}

