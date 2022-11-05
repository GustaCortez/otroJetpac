package com.androidavanzado.prueeba.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.androidavanzado.prueeba.R;
import com.androidavanzado.prueeba.placeholder.ui.DashboardActivity;

public class MainActivity extends AppCompatActivity {
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin.findViewById(R.id.buttonLogin);
        //definir el evento click sobre el boton de login
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(MainActivity.this, DashboardActivity.class);
                startActivity(i);
            }
        });
    }
}