package lal.edu;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class SQLiteDatabaseActivity extends ListActivity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		String[] fields = new String[] { 
				"movie", "actor", "language"};
		int[] textViews = new int[] {
				R.id.movie, R.id.actor, R.id.language};
		
		
		Helper helper = new Helper(this);

		ListAdapter adapter = new SimpleCursorAdapter(
			this, 
			R.layout.list_item,
			helper.getCursor(),
			fields,
			textViews
		);

		setListAdapter(adapter);
		ListView listView = getListView();
		listView.setTextFilterEnabled(true);	//Type characters to select them.
		
		/*

		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				TextView city = (TextView)((LinearLayout)view).getChildAt(1);
				String s = position + " " + id ;
				Toast.makeText(SQLiteDatabaseActivity.this, s, Toast.LENGTH_SHORT).show();  
			}
		}); */
	}

}