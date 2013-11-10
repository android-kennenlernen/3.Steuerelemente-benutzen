# 3.Steuerelemente-benutzen

Aufgabe eines Computer-Programmes ist es

- Eingaben entgegen zunehmen
- Diese Eingaben intern zu verarbeiten
- Das Ergebnis der Verarbeitung auszugeben
 
Bei einer App sieht es natürlich nicht anders aus.

Dazu benötigt man sogenannte Steuer-Elemente.  
Diese müssen ausgelesen und deren Inhalt in den Programm-Fluß eingebracht werden.  
Bei Schaltern muß man auf das Betätigen reagieren usw. .

In einer Beispiel-App wollen wir uns dies ansehen.  

__Aufgabenstellung__

Im Oberflächen-Designer wird die Activity mit

- 1 Text-Eingabezeile (EditText)
- 1 Text-Anzeigezeile (TextView)
- 2 Schalter (Button)

ausgestattet.

Dann wird in der Activity Programm-Code eingebracht, welcher

- bei Betätigen des Schalters 'Drück doch mal'
- die Text-Eingabezeile ausliest
- die Text-Anzeigezeile mit dem ausgelesenen Text beschreibt
- und bei Betätigen des Schalters 'Räume auf'
- die Text-Eingabe löscht und auf die Text-Anzeigezeile einen Hinweistext ausgibt. 

__Hilfestellung__

Zunächst ist ein neues Android-Projekt erstellen.

Dann werden mittels des Oberflächen-Designer
- 1 EditText
- 1 TextView
- 1 Schalter namens 'btnDrueckDochMal'
- 1 Schalter namens 'btnRaeumeAuf'
in die Oberfläche der Activity eingebracht.

Bemerke gerade, das dies noch nicht vorgestellt wurde.  
Statt dessen zunächst ein [Youtube-Video](http://www.youtube.com/watch?v=Yj9YZg7Mp6o).Sorry

Sind die Steuerelemente auf der Oberfläche der Activity plaziert, können wir uns dem Quell-Code der Activity zuwenden.

Dazu wechseln wir in das jeweilige Editorfenster.   

Beginnen wir mit den Programm-Strukturen, welche für die Betätigung der Schalter zuständig sein werden.

Hierzu gibt es zwei Möglichkeiten, welche in diesem Text als _'klassischer Kontext'_ und _'deklarativer Kontext'_ bezeichnet werden.

Der _klassische Kontext_ knüpft an die klassische Java-GUI-Methodik an, Handler in den Programm-Code einzuhängen.

Der _deklarative Kontext_ erledigt die Anknüpfung in der activity_xxx.xml.

Fangen wir an... 

----

Im klassischen Kontext:

**MainActivity.java**

```java
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		.
		.
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
```

----

Im deklaritiven Kontext:

Zunächst ist eine Methode zu implementieren, welche bei 'onClick' aufgerufen werden soll.  
Der Name der Methode ist _nicht_ maßgebend, das links und rechts um den Namen herum dagegen schon.  

Die Methoden-Deklaration dazu lautet:

```java
	public void Methoden-Name(View v)
```

Diese Methoden-Deklaration sollte selbst nach dem Wecker-Klingeln frühmorgens sofort abrufbar sein!  
(Oder wenn der Dozent danach fragt.) 

**MainActivity.java**
```java
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
```

Nun zur jeweiligen *activity_xxx.xml*.  
Der oben genannte Methoden-Name ist nun innerhalb der betreffenden _Button_-Deklaration bekannt zu geben.  
Erfolgt dies __nicht__ / wird dies vergessen, wird die onClick-Methode in der Activity auch __nicht__  aufgerufen.

**activity_main.xml**

```xml
    <Button
        android:id="@+id/btnDrueckDochMal"
		.
		.
        android:onClick="onClick_DrueckDochMal"
        android:text="Drück doch mal" />
```

Im Quelltext der 'Activity' wurden diesbezüglich an den betreffenden Stellen nochmals Kommentare angebracht


__Vorschau auf die App__

![Image](./readme-img/steuerelemente-start.png)

Okay, nun den Schalter 'Drück doch mal' betätigen.

![Image](./readme-img/steuerelemente-next.png)

Es wird der Text aus der Eingabe-Zeile in die TextView übernommen.  
Nun denn Schalter 'Räume auf betätigen'.

![Image](./readme-img/steuerelemente-third.png)

Jetzt kann ein eigener Text eingegeben werden.  
Nun wiederum den Schalter 'Drück doch mal' betätigen.  
Es erscheint der selbst eingegebene Text. 

__Was sollten wir jetzt beherrschen?__

- Eigenständiger Aufbau einer Benutzer-Oberfläche
- Auslesen von Eingabe-Zeilen
- Beschreiben von TextViews
- Erstellen eines Button-Handlers
- Einbinden des Button-Handlers im klassischen und deklarativen Kontext  