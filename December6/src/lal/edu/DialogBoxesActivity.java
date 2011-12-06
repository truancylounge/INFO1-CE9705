package lal.edu;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class DialogBoxesActivity extends Activity implements OnClickListener  {
   
	ProgressDialog progressBar;
	ProgressThread progressThread;
	public Handler progressBarHandler = new Handler();
	
	
	/** Called when the activity is first created. */
   	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button alert = (Button) findViewById(R.id.alertbutton);
        alert.setOnClickListener(this);
        
        Button yesno = (Button) findViewById(R.id.yesnobutton);
        yesno.setOnClickListener(this);
        
        Button selectListWithCheckbox = (Button) findViewById(R.id.selectlistwithcheckbox);
        selectListWithCheckbox.setOnClickListener(this);  
        
        Button fileTransferButton = (Button) findViewById(R.id.filetransferbutton);
        fileTransferButton.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		initializeProgressBar(v);
        		progressThread = new ProgressThread(progressBarHandler, progressBar);
        		progressThread.start();        		
        	}
        });
        
    }
   	
   	private void initializeProgressBar(View v) {
  		progressBar = new ProgressDialog(v.getContext());
		progressBar.setCancelable(true);
		progressBar.setMessage("Downloading File ....");
		progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		progressBar.setMax(100);
		progressBar.show();		
   	}
    
    public void onClick(View view) {
    	if(view == findViewById(R.id.alertbutton)) {
    		AlertDialog.Builder alertBox = new AlertDialog.Builder(this);
    		alertBox.setMessage("Dialog box with one Button");
    		alertBox.setNeutralButton("OK", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					Toast.makeText(getApplicationContext(), "OK Button Clicked", Toast.LENGTH_SHORT).show();
					
				}
			});
    		
    		alertBox.show();
    		
    	}
    	
    	if(view == findViewById(R.id.yesnobutton)) {
    		AlertDialog.Builder alertBox = new AlertDialog.Builder(this);
    		alertBox.setMessage("Dialog box with 2 Buttons");
    		alertBox.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					Toast.makeText(getApplicationContext(), "Yes Button Clicked", Toast.LENGTH_SHORT).show();
					
				}
			});
    		
    		alertBox.setNegativeButton("No", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					Toast.makeText(getApplicationContext(), "No Button clicked", Toast.LENGTH_SHORT).show();
					
				}
			});
    		
    		alertBox.show();
    		
    	}
    	
    	
    	if(view == findViewById(R.id.selectlistwithcheckbox)) {
    		final CharSequence[] items = {"Cowboys", "Giants", "Eagles", "Exit"};
    		AlertDialog.Builder builder = new AlertDialog.Builder(this);
    		builder.setTitle("Select your fav team");
    		
    		builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					if(items[which] == "Exit") 
						dialog.dismiss();
					else if(items[which] == "Cowboys") 
						Toast.makeText(getApplicationContext(), "Lets go to Indys! Go COWBOYS.", Toast.LENGTH_SHORT).show();
					else if(items[which] == "Giants")
						Toast.makeText(getApplicationContext(), "Better luck next season, its cowboys all the way.", Toast.LENGTH_SHORT).show();
					else if(items[which] == "Eagles")
						Toast.makeText(getApplicationContext(), "Do Eagles have any fight left? Andy Reid left picking up the pieces.", Toast.LENGTH_SHORT).show();
				}
    		});
    		
    		AlertDialog alert = builder.create();
    		alert.show();    		
    	}    	
   	
    }
}