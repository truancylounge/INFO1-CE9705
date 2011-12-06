package lal.edu;

import android.app.ProgressDialog;
import android.os.Handler;

public class ProgressThread extends Thread {
	Handler handler;
	ProgressDialog progressBar;
	
	private int progressStatusBar = 0;
	private Long fileSize = 0L;


	
	public ProgressThread(Handler handler, ProgressDialog progressBar) {
		this.handler = handler;
		this.progressBar = progressBar;
	}
	
	public void run() {
		while(progressStatusBar < 100) {
			progressStatusBar = performTask();
			try {
				Thread.sleep(1000); // sleep for 1 sec
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			handler.post(new Runnable() {
				public void run() {
					progressBar.setProgress(progressStatusBar);
				}
			});
		}
		
		if(progressStatusBar >= 100) {
			try{
				Thread.sleep(2000);
			} catch ( Exception e) {
				e.printStackTrace();
			}
			
			progressBar.dismiss();
		}
		
	}
	
	private int performTask() {
		while (fileSize <= 1000000L) {
			fileSize++;
			if(fileSize == 100000)
				return 10;
			else if (fileSize == 250000)
				return 25;
			else if (fileSize == 500000)
				return 50;
			else if (fileSize == 750000)
				return 75;
			else if (fileSize >= 1000000)
				return 100;		
		}
		return 100;
	}
	

}
