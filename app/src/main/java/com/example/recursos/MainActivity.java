package com.example.recursos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Telephony;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button buttonSMS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonSMS = findViewById(R.id.buttonSms);
    }//end onCreate

    public void clicar(View view) {
        Intent intent = null;
        if (view.getId() == R.id.buttonSms) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                String defaultSmsPackageName = Telephony.Sms.getDefaultSmsPackage(this);
                intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, "Hello World!");
                if (defaultSmsPackageName != null) {
                    intent.setPackage(defaultSmsPackageName);
                    startActivity(intent);
                }
            } else {
                intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.putExtra(Intent.EXTRA_TEXT, "Hello World! 2");
                intent.setType("vnd.android-dir/mms-sms");
                startActivity(intent);
            }
        }
    }
}