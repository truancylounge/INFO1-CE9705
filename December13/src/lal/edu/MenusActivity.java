package lal.edu;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MenusActivity extends Activity {
	TextView textView;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Using menu.add(int GroupID,int ItemID,int Order,String Title)
		menu.add(1, 1, 0, "Music").setIcon(R.drawable.music);
		menu.add(1, 2, 1, "Icon L").setIcon(R.drawable.ic_launcher);
		menu.add(1, 3, 2, "Frog").setIcon(R.drawable.frog);
		menu.add(1, 4, 3, "Balloons").setIcon(R.drawable.balloons);
		menu.add(1, 5, 4, "Gallery").setIcon(R.drawable.beach);
		menu.add(1, 6, 5, "Animation").setIcon(R.drawable.animated_gif);
		menu.add(1, 7, 6, "Item7");
		menu.add(1, 8, 7, "Item8");
		
		return true;
		
		
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case 1:
			Toast.makeText(this, "Music App will be launching soon!", Toast.LENGTH_LONG).show();
			return true;
			
		case 2:
			Toast.makeText(this, "Icon Launcher", Toast.LENGTH_SHORT).show();
			return true;			

		case 3:
			Toast.makeText(this, "Frog Game Launching soon", Toast.LENGTH_LONG).show();
			return true;			

		case 4:
			Toast.makeText(this, "Pop as Many balloons as you can. Launching Soon!", Toast.LENGTH_LONG).show();
			return true;			

		case 5:
			Toast.makeText(this, "Photo Gallery Coming Soon!", Toast.LENGTH_LONG).show();
			return true;			

		case 6:
			Toast.makeText(this, "Animation App coming soon", Toast.LENGTH_LONG).show();
			return true;			

		case 7:
			Toast.makeText(this, item.getTitle(), Toast.LENGTH_LONG).show();
			return true;			

		case 8:
			Toast.makeText(this, item.getTitle(), Toast.LENGTH_LONG).show();
			return true;			


		default:
			return super.onOptionsItemSelected(item);
		}
		} 
}