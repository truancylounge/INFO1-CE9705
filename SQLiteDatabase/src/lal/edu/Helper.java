package lal.edu;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Helper extends SQLiteOpenHelper {
	public Helper(Context context) {
		super(context, "MoviesThisWeek.db", null, 1);		
	}
	
	public void onCreate(SQLiteDatabase db) {
		String statements[] = {
				"create table movies (_id integer primary key autoincrement, movie text, actor text, language text);",
				"Insert into movies (_id, movie, actor, language) values (null, 'Mission Impossible', 'Tom', 'ENG' );",
				"Insert into movies (_id, movie, actor, language) values (null, 'Mission Impossible1', 'Tom', 'ENG' );",
				"Insert into movies (_id, movie, actor, language) values (null, 'Mission Impossible2', 'Tom', 'ENG' );",
				"Insert into movies (_id, movie, actor, language) values (null, 'Mission Impossible3', 'Tom', 'ENG' );",
				};
		
		for(String statement: statements) { 
			db.execSQL(statement);
						
		}
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	}
	
	public Cursor getCursor() {
		SQLiteDatabase db = getReadableDatabase(); //the db passed to onCreate
		//can say _id, name instead of *, but _id must be included.
		Cursor cursor = db.rawQuery("SELECT movie, actor, langugae FROM movies;", null);
		cursor.moveToFirst();
		return cursor;
	}

	

}
