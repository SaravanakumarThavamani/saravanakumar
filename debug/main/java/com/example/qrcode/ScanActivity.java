package com.example.qrcode;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.zxing.Result;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class ScanActivity extends AppCompatActivity {
     Button button1;
     TextView edittext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);

        button1= findViewById(R.id.button1);
        edittext =findViewById(R.id.edittext);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator intentIntegrator =new IntentIntegrator(ScanActivity.this);
                intentIntegrator.setOrientationLocked(true);
                intentIntegrator.setPrompt("Scan a Qr code");
                intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);
                intentIntegrator.initiateScan();
            }
        });
    }
@Override
 protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
    IntentResult intentResult =IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
    if (intentResult !=null){
        String contents =intentResult.getContents();
        if (contents !=null){
            edittext.setText(intentResult.getContents());
        }
    }else{
        super.onActivityResult(requestCode,resultCode,data);
    }
 }
 }