package com.example.intentsandintentfiltersv01;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this,HomeActivity.class);
                startActivity(i);

//                Intent i = new Intent(Intent.ACTION_WEB_SEARCH);
//                i.putExtra(SearchManager.QUERY, "Java Institute");
//                startActivity(i);

                // i.setClassName("com.example.intentsandintentfiltersv02","com.example.intentsandintentfiltersv02.MainActivity");
                //Intent i = new Intent("android.media.action.STILL_IMAGE_CAMERA");

            }
        });

    }
}