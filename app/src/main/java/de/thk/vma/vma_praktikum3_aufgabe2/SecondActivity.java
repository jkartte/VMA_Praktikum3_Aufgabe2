package de.thk.vma.vma_praktikum3_aufgabe2;

//LogCat beim Drücken des Back-Buttons in Activity2:
//04-25 11:07:52.077 13219-13219/de.thkoeln.cvogt.android.activities V/DEMO:       ---> Activity2: onPause() <---
//04-25 11:07:52.081 13219-13219/de.thkoeln.cvogt.android.activities V/DEMO: ---> Activity1: onStart() <---
//04-25 11:07:52.081 13219-13219/de.thkoeln.cvogt.android.activities V/DEMO: ---> Activity1: onResume() <---
//04-25 11:07:52.423 13219-13219/de.thkoeln.cvogt.android.activities V/DEMO:       ---> Activity2: onStop() <---
//04-25 11:07:52.423 13219-13219/de.thkoeln.cvogt.android.activities V/DEMO:       ---> Activity2: onDestroy() <---
//Der LogCat zeigt keinen Eintrag für die Methode onSaveInstanceState(). Die Methode müsste eigentlich nach dem
//Pausieren von Activity 2 ausgeführt werden und an dieser Stelle im LogCat vermerkt werden, anscheinend ist
//das hier aber nicht passiert.


// Programmierung verteilter und mobiler Anwendungen
// Prof. Dr. Carsten Vogt
// Technische Hochschule Köln
// Fakultät für Informations-, Medien- und Elektrotechnik
// Stand: 4.12.2015

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import de.thkoeln.cvogt.android.activities.R;

public class SecondActivity extends Activity {

    private String text;
    private EditText editText;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        SharedPreferences sp = getSharedPreferences("MySharedPreferences",0);
        String eingelesenerText = sp.getString("Text","Bitte Text eingeben.");
        EditText editText = (EditText) findViewById(R.id.plain_text_input);
        editText.setText(eingelesenerText);
    }

    public void onStart() {
        super.onStart();
        Log.v("DEMO","      ---> Activity2: onStart() <--- ");
    }

    public void onResume() {
        super.onResume();
        Log.v("DEMO","      ---> Activity2: onResume() <--- ");
    }

    public void onPause() {
        super.onPause();
        Log.v("DEMO","      ---> Activity2: onPause() <--- ");
    }

    public void onStop() {
        super.onStop();
        SharedPreferences sp = getSharedPreferences("MySharedPreferences",0);
        EditText anzeigefeld = (EditText) findViewById(R.id.plain_text_input);
        SharedPreferences.Editor editor = sp.edit();
        String zuSpeichernderText = anzeigefeld.getText().toString();
        editor.putString("Text",zuSpeichernderText);
        editor.commit();
    }

    public void onDestroy() {
        super.onDestroy();
        Log.v("DEMO","      ---> Activity2: onDestroy() <--- ");
    }


    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("StringKey",text);
        Log.v("DEMO","      ---> Activity2: onSaveInstanceState() <--");
    }

}


