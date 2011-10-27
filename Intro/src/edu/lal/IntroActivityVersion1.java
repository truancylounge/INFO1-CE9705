package edu.lal;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class IntroActivityVersion1 extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		TextView textView = new TextView(this);
		textView.setText("Hi Lalith how are ya");
		setContentView(textView);
		
		//Button button1 = new Button(this);
		//button1.setText("Button1");
		//button1.setMaxHeight(40);
		//button1.setMaxWidth(20);
		
		//setContentView(button1);
		
		Toast.makeText(this, "Button height:Width " , Toast.LENGTH_LONG).show();
		
		//Button button1 = (Button) findViewById(R.id.button1);
		
		//setContentView(button1);
		Log.d("lal", "Hi How are ya");
		System.out.println("YO YO YO YO");
		
		
	}
	

}
