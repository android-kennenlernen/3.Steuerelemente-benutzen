/*
 * Copyright (c) 2013 Uli Fuchs
 * MIT licensed 
 */

package com.example.steuerelemente;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		/*
		 * Dies ist die klassische Variante, einen onClick-Handler zu 
		 * installieren.
		 * Hierbei wird über 'new OnClickListener()' eine anonyme Klasse
		 * instanziert.
		 * PRO:
		 * Der 'OnClickListener' ließe sich als Klasse auslagern.
		 * CON:
		 * 1.Innerhalb der anonymen Klasse kann nicht auf den Kontext der 
		 *   umgebenen Activity zugegriffen werden, heißt Klassen-Variablen.
		 * 2.Beim Lesen, Verstehen eines Quelltextes ist jede zusätzliche
		 *   Zeile eine zuviel. 
		 *   Jede Zeile zuviel birgt zusätzliches Fehler-Risiko.
		 *   Dies ist sollte aber jeder mit sich selbst ausmachen.  
		 */
		Button b = (Button) findViewById(R.id.btnRaeumeAuf);
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {

				// Referenz auf Eingabezeile ermitteln  
				EditText et = (EditText) findViewById(R.id.editText1);
				// EingabeZeile leeren
				et.setText("");

				// Referenz auf TextView ermitteln
				TextView tv = (TextView) findViewById(R.id.textView1);
				// 
				tv.setText("Nun bitte selbst texten.");
				
			}
		});
		
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
	 * per 'android:onClick="onClick_DrueckDochMal"' hergestellt. 
	 *   
	 * @param v - Referenz auf das Steuerelement, hier 'btnDrueckDochMal'
	 */
	public void onClick_DrueckDochMal(View v) {
		
		// Referenz auf Eingabezeile ermitteln  
		EditText et = (EditText) findViewById(R.id.editText1);
		// Eingabezeile auslesen
		String text = et.getText().toString();

		// Referenz auf TextView ermitteln
		TextView tv = (TextView) findViewById(R.id.textView1);
		// Text der EingabeZeile in die TextView schreiben
		tv.setText(text);
		
	}
	
}
