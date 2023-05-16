package com.example.recursos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button buttonGmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonGmail = findViewById(R.id.buttonGmail);
    }//end onCreate

    public void clicar(View view){
        Intent intent = null;
        if(view.getId() == R.id.buttonGmail){
            String email = "apag.guimaraes@gmail.com";
            String subject = "Meu titulo";
            String text = "Meu texto";
            intent = new Intent(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
            intent.putExtra(Intent.EXTRA_SUBJECT, subject);
            intent.putExtra(Intent.EXTRA_TEXT, text);
            intent.setType("message/rfc822");
            intent.setPackage("com.google.android.gm");
            startActivity(intent);
        }
    }
}