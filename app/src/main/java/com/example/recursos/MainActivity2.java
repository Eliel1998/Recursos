package com.example.recursos;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.Locale;

public class MainActivity2 extends AppCompatActivity implements TextToSpeech.OnInitListener {
    private VideoView videoView;
    private Button buttonPlay, buttonPause, buttonStop;
    private Uri uri;
    private TextToSpeech textToSpeech;
    private String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String nome = getIntent().getStringExtra("nome");
        msg = "Olá " + nome + ", seja bem vindo !!!";

        textToSpeech = new TextToSpeech(this, this);
        videoView = findViewById(R.id.videoView);
        buttonPlay = findViewById(R.id.buttonPlay);
        buttonPause = findViewById(R.id.buttonPause);
        buttonStop = findViewById(R.id.buttonStop);

        uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video);
        videoView.setVideoURI(uri);

        buttonPlay.setOnClickListener(v -> {
            videoView.start();
            int duration = videoView.getDuration();
            Toast.makeText(this, "Duração: " + duration, Toast.LENGTH_SHORT).show();

        });

        buttonPause.setOnClickListener(v -> {
            videoView.pause();
            int current = videoView.getCurrentPosition();
            Toast.makeText(this, "Posição atual: " + current, Toast.LENGTH_SHORT).show();
        });

        buttonStop.setOnClickListener(v -> {
            videoView.stopPlayback();
            Toast.makeText(this, "Vídeo parado", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            Locale locale = new Locale("pt", "BR");
            int result = textToSpeech.setLanguage(locale);
            textToSpeech.setSpeechRate(1.0f);
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("problemas", "Linguagem não suportada");
            } else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    textToSpeech.speak(msg, TextToSpeech.QUEUE_FLUSH, null, null);
                } else {
                    textToSpeech.speak(msg, TextToSpeech.QUEUE_FLUSH, null);
                }
            }
        } else {
            Log.e("problemas", "Inicialização falhou");
        }

    }
}