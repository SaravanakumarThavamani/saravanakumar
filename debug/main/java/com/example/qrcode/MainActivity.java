package com.example.qrcode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edittext =findViewById(R.id.edittext);
        Button button = findViewById(R.id.button);
        ImageView imageView=findViewById(R.id.imageView);
        Button button1 =findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MultiFormatWriter multiFormatWriter= new MultiFormatWriter();
               try{
                   BitMatrix bitMatrix = multiFormatWriter.encode(edittext.getText().toString(),BarcodeFormat.QR_CODE,300,200);

                   BarcodeEncoder barcodeEncoder =new BarcodeEncoder();
                   Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);

                   imageView.setImageBitmap(bitmap);
               }catch (WriterException e){
                   throw new RuntimeException(e);
               }
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, ScanActivity.class);
                startActivity(intent);
            }
        });
    }
}