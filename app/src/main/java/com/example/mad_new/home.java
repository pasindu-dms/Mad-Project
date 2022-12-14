package com.example.mad_new;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final Button profile = findViewById(R.id.profile_btn);
        final Button shop = findViewById(R.id.shop_btn);
        final Button feedback = findViewById(R.id.feedback_btn);
        final Button service = findViewById(R.id.appointment_btn);
        final Button view = findViewById(R.id.view_btn);
        final Button style = findViewById(R.id.styles_btn);

        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(home.this,Feedback.class));
            }
        });

        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(home.this,Product.class));
            }
        });

        service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(home.this,service.class));
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(home.this, View_Appointment.class));
            }
        });

        style.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(home.this,Hair_Styles.class));
            }
        });
    }
}