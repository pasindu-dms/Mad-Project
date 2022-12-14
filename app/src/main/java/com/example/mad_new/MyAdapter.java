package com.example.mad_new;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<feedbackModel> list;
    String idd;

    public MyAdapter(Context context, ArrayList<feedbackModel> list) {
        this.context = context;
        this.list = list;
    }





    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        feedbackModel feedback = list.get(position);
        holder.name.setText(feedback.getName());
        holder.feedback.setText(feedback.getFeedback());
        feedbackModel model = new feedbackModel();

        holder.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               final DialogPlus dialogPlus = DialogPlus.newDialog(context)
                        .setContentHolder(new ViewHolder(R.layout.update_popup))
                        .setExpanded(true ,1200)
                        .create();
                View holderView =  dialogPlus.getHolderView();

                EditText feedback = holderView.findViewById(R.id.feedback);
                Button update = holderView.findViewById(R.id.update);

                feedback.setText(model.getFeedback());

                dialogPlus.show();

                update.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Map<String,Object > map = new HashMap<>();
                        map.put("feedback",feedback.getText().toString());


                        idd = list.get(position).getName();
                        final DatabaseReference reference = FirebaseDatabase.getInstance().getReference("feedback").child(idd);
                        reference.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                String feedback = (String) snapshot.child("feedback").getValue();
                                Toast.makeText(holder.name.getContext(), "Updated successfully", Toast.LENGTH_SHORT).show();

                             }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name, feedback;
        ImageButton update;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            feedback = itemView.findViewById(R.id.feedback);
            update = itemView.findViewById(R.id.update);

        }
    }
}
