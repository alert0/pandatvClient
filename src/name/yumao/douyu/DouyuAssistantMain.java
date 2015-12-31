package name.yumao.douyu;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import name.yumao.douyu.http.DownloaderThead;
import name.yumao.douyu.http.InfoThead;
import name.yumao.douyu.swing.Danmu;
import name.yumao.douyu.swing.Download;

public class DouyuAssistantMain extends JFrame{
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception{
		JTextField inNum2=new JTextField(10);
		InfoThead infoThead = new InfoThead(inNum2,false);
		Thread infoWrite = new Thread(infoThead);
		infoWrite.start();
		
		if(args[0].equals("-content")){
			Danmu danmu = new Danmu();
		}else if(args[0].equals("-download")){
			Download download = new Download();
		}else  if(args[0].equals("-start") ) {
			
			
			int lenght = args.length;
			
			for(int i = 1; i < args.length ;i++) {
				JTextField inNum=new JTextField(10);
				inNum.setText(args[i]);
			    JButton butnSure=new JButton("录像");
			    DownloaderThead downloader = new DownloaderThead(inNum);
				Thread downloaderThead = new Thread(downloader);
				downloaderThead.start();
			}

		}
		else {
			System.out.print("错误的传入参数！");
		}
	}	
}
