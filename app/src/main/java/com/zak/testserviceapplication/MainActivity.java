package com.zak.testserviceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button speakButton;
    TestService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setXmlReference();
        setListeners();

    }

    private void setListeners() {
        speakButton.setOnClickListener(this);
    }

    private void setXmlReference() {
        speakButton = findViewById(R.id.spkBtn);
    }

    private void speechProcess() {
        service = new TestService(getApplicationContext(), "ar");
        service.startListen();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.spkBtn:
                speechProcess();
                break;
        }
    }
}
