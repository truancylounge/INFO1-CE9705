package lal.edu;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;
import android.widget.Toast;

public class OrientationActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		String[] orientation = {
			"Configuration.ORIENTATION_UNDEFINED",
			"Configuration.ORIENTATION_PORTRAIT",
			"Configuration.ORIENTATION_LANDSCAPE",
			"Configuration.ORIENTATION_SQUARE"
		};

		Resources resources = getResources();
		Configuration configuration = resources.getConfiguration();
		int o = configuration.orientation;
		Toast.makeText(this, "Lalith", Toast.LENGTH_LONG).show();
		Toast.makeText(this, orientation[o], Toast.LENGTH_LONG).show();

		String[] rotation = {
			"Surface.ROTATION_0",	//degrees counterclockwise from portrait
			"Surface.ROTATION_90",
			"Surface.ROTATION_180",
			"Surface.ROTATION_270"
		};

		WindowManager manager = (WindowManager)getSystemService(Context.WINDOW_SERVICE);
		Display display = manager.getDefaultDisplay();
		int r = display.getRotation();		//was getOrientation in SDK 7
		Toast.makeText(this, rotation[r], Toast.LENGTH_LONG).show();
	}
}