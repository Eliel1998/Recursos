package com.example.recursos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Telephony;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button buttonWhats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonWhats = findViewById(R.id.buttonWhatsapp);
    }//end onCreate

    public void clicar(View view) {
        Intent intent = null;
        if (view.getId() == R.id.buttonWhatsapp) {
            String msg = "Olá, tudo bem?";
            intent = new Intent();
            intent.setAction(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_TEXT, msg);
            intent.setType("text/plain");
            intent.setPackage("com.whatsapp");
            startActivity(intent);
        }
    }
}