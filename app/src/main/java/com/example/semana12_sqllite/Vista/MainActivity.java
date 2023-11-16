package com.example.semana12_sqllite.Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.semana12_sqllite.R;

public class MainActivity extends AppCompatActivity {
    Button btnregistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnregistro = findViewById(R.id.btnRegistrar);

        btnregistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

}