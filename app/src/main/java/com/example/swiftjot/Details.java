package com.example.swiftjot;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Locale;

public class Details extends AppCompatActivity {
    long id;
    private TextToSpeech textToSpeech;

    public OnBackPressedCallback callback = new OnBackPressedCallback(false) {
        @Override
        public void handleOnBackPressed() {
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent i = getIntent();
        id = i.getLongExtra("ID", 0);
        Database db = new Database(this);
        Note note = db.getNote(id);
        getSupportActionBar().setTitle(note.getTitle());
        TextView details = findViewById(R.id.noteDesc);
        details.setText(note.getContent());
        details.setMovementMethod(new ScrollingMovementMethod());

        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    // Set default language to English
                    int languageResult = textToSpeech.setLanguage(Locale.ENGLISH);
                    if (languageResult == TextToSpeech.LANG_MISSING_DATA || languageResult == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Toast.makeText(Details.this, "Language not supported", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Details.this, "Initialization failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        FloatingActionButton fab_delete = findViewById(R.id.fab_delete);
        fab_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Database db = new Database(getApplicationContext());
                db.deleteNote(id);
                Toast.makeText(getApplicationContext(), "Note Deleted", Toast.LENGTH_SHORT).show();
                goToMain();
            }
        });

        FloatingActionButton fab_pdf = findViewById(R.id.fab_pdf);
        fab_pdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToPDF();
            }
        });

        FloatingActionButton fab_sketch = findViewById(R.id.fab_sketch);
        fab_sketch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSketchPad();
            }
        });

        FloatingActionButton fab_tts = findViewById(R.id.fab_tts);
        fab_tts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = details.getText().toString();
                int result = textToSpeech.setLanguage(Locale.ENGLISH);
                if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    Toast.makeText(Details.this, "Language not supported", Toast.LENGTH_SHORT).show();
                } else {
                    textToSpeech.speak(string, TextToSpeech.QUEUE_FLUSH, null, String.valueOf(System.currentTimeMillis()));
                }
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        getOnBackPressedDispatcher().addCallback(this, callback);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.edit_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.edit){
            Intent i = new Intent(this,Edit.class);
            i.putExtra("ID",id);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onDestroy() {
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onDestroy();
    }

    private void goToMain() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    private void goToPDF(){
        Intent i = new Intent(this, PDF_view.class);
        startActivity(i);
    }

    private void goToSketchPad(){
        Intent i = new Intent(this, SketchPad.class);
        startActivity(i);
    }
}
