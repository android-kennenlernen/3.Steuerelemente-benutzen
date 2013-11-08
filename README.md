# 3.Steuerelemente-benutzen

[Entwuf]

Einleitung hier...

----

Klassische Variante in Methode 'onCreate':

**MainActivity.java**

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

----

In einem deklaritiven Kontext:

**MainActivity.java**

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

**activity_main.xml**


    <Button
        android:id="@+id/button1"
		.
		.
        android:onClick="btnOnClick"
        android:text="Drück doch mal" />

__Vorschau auf die App__

![Image](./readme-img/steuerelemente-start.png)

Okay, nun den Schalter 'Drück doch mal' betätigen.

![Image](./readme-img/steuerelemente-next.png)

Es wird der Text aus der Eingabe-Zeile in die TextView übernommen.  
Nun denn Schalter 'Räume auf betätigen'.

![Image](./readme-img/steuerelemente-third.png)

Jetzt kann ein eigener Test eingegeben werden.  
Nun wiederum den Schalter 'Drück doch mal' betätigen.  
Es erscheint der selbst eingegebene Text. 
