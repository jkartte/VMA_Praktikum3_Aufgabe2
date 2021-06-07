package de.thk.vma.vma_praktikum3_aufgabe2;

// Programmierung verteilter und mobiler Anwendungen
// Prof. Dr. Carsten Vogt
// Technische Hochschule Köln
// Fakultät für Informations-, Medien- und Elektrotechnik
// Stand: 4.12.2015

// Eine App mit zwei Activities, zwischen denen man hin- und herschalten kann.
// LogCat-Ausgaben zeigen dabei an, wann welche Zustandsübergangsmethoden (Callbacks) ausgeführt werden.
// Video dazu: https://youtu.be/Zwswz3UmvOc

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import de.thkoeln.cvogt.android.activities.R;

public class MainActivity extends Activity {

    /* onCreate() wird bei der Erzeugung der Activity ausgeführt. */

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);  // Android Doku: "Derived classes must call through to the super class's implementation of this method. If they do not, an exception will be thrown."
        setContentView(R.layout.activity_main);  // zeigt Layout auf dem Display an
        //setTitle(R.string.activity1_title);  // setzt den Titel der Activity (kann alternativ durch ein Attribut in der Manifest-Datei geschehen)
        // setTitle("@string/activity1_title");  // alternativ Form des Parameters

        final Button switchButton = (Button) findViewById(R.id.switchActivity);

        switchButton.setOnClickListener(new SwitchButtonListener());

        Toast.makeText(this,"Activity 1: onCreate()", Toast.LENGTH_LONG).show(); // Kontrollausgabe durch 'Toast', Parameter 'this' bezieht sich auf die Activity]

        Log.v("DEMO","---> Activity1: onCreate() <--- "); // Kontrollausgabe im LogCat
    }

    public void onStart() {
        super.onStart();
        Log.v("DEMO","---> Activity1: onStart() <--- ");
    }

    public void onResume() {
        super.onResume();
        Log.v("DEMO","---> Activity1: onResume() <--- ");
    }

    public void onPause() {
        super.onPause();
        Log.v("DEMO","---> Activity1: onPause() <--- ");
    }

    public void onStop() {
        super.onStop();
        Log.v("DEMO","---> Activity1: onStop() <--- ");
    }

    public void onDestroy() {
        super.onDestroy();
        Log.v("DEMO","---> Activity1: onDestroy() <--- ");
    }

}

class SwitchButtonListener implements OnClickListener  {   // Listener des Buttons

    public void onClick(View v) {
        Log.v("DEMO","---> Activity1: Click on Button <--- ");
        Intent myIntent = new Intent(v.getContext(), SecondActivity.class); // Durch Übergabe dieses Intent-Objekts an startActivity():
        // Log.v("DEMO","Activity1: Intent.getComponent() = "+myIntent.getComponent());
        v.getContext().startActivity(myIntent);                             // Erzeugung und Aktivierung einer neuen Instanz der Klasse SecondActivity
    }

}
