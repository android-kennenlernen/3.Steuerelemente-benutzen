package com.example.steuerelemente;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/**
	 * Wird beim Klicken des Schalters 'btnDrueckDochMal' aufgerufen.
	 * </br>
	 * Diese sogenannten Handler sind stets manuell zu erstellen!
	 * </br>
	 * Die Verbindung zum Steuerelement wird in der jeweiligen 'activity_xxx.xml'
	 * hergestellt per 'android:onClick="onClick_DrueckDochMal"'
	 *   
	 * @param v - Referenz auf das Steuerelement, hier 'btnDrueckDochMal'
	 */
	public void onClick_DrueckDochMal(View v) {
		
		// Referenz auf Eingabezeile ermitteln  
		EditText et = (EditText) findViewById(R.id.editText1);
		// Eingabezeile auslesen
		String text = et.getText().toString();

		TextView tv = (TextView) findViewById(R.id.textView1);
		tv.setText(text);
		
	}
	
}
