package com.example.program4b;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private final int MY_REQUEST_CODE=1;
    ImageView imgGallery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgGallery=findViewById(R.id.imgGallery);
        Button btnGallery=findViewById(R.id.btnGallery);

        btnGallery.setOnClickListener(v -> {
            Intent iGallery=new Intent(Intent.ACTION_PICK);
            iGallery.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(iGallery,MY_REQUEST_CODE);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            if(requestCode==MY_REQUEST_CODE){
                assert data != null;
                imgGallery.setImageURI(data.getData());
            }
        }
    }
}
