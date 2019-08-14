package com.example.root.appspeak;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener{

    private TextToSpeech toSpeech;
    private Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt = (Button) findViewById(R.id.button);
        toSpeech = new TextToSpeech(this, this);
    }

    @Override
    public void onInit(int status) {
        if(status == TextToSpeech.SUCCESS)
            bt.setEnabled(true);
    }

    public void ouvir(View v){
        EditText editText = (EditText) findViewById(R.id.editText);
        toSpeech.speak(editText.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
    }
}
