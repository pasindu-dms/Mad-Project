package com.example.mad_new;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class Feedback extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    MyAdapter myAdapter;
    ArrayList<feedbackModel> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        final Button add= findViewById(R.id.feedback_btn);
        final ImageButton back =findViewById(R.id.back);
        recyclerView = findViewById(R.id.list_item);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        arrayList = new ArrayList<>();
        myAdapter = new MyAdapter(this,arrayList);
        databaseReference = FirebaseDatabase.getInstance().getReference("feedback");
        recyclerView.setAdapter(myAdapter);
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                    feedbackModel feedback=dataSnapshot.getValue(feedbackModel.class);
                    arrayList.add(feedback);



                }myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Feedback.this,My_feedback.class));
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Feedback.this,home.class));
            }
        });
    }
}