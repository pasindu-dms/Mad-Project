package com.example.mad_new;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Admin_home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        final Button shop = findViewById(R.id.shop_btn);
        final Button feedback = findViewById(R.id.feedback_btn);
        final Button style = findViewById(R.id.styles_btn);
        final Button view = findViewById(R.id.view_btn);

        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Admin_home.this,Admin_Shop.class));
            }
        });
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Admin_home.this,Admin_feedback.class));
            }
        });
        style.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Admin_home.this,Admin_hairstyle.class));
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Admin_home.this, Admin_appointment.class));
            }
        });

    }
}