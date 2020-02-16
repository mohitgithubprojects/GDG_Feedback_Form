package com.mohit.androidtrack3feedback;


import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FeedbackAdapter extends RecyclerView.Adapter<FeedbackAdapter.FeedBackViewHolder> {

ArrayList<GDGFeedback> gdgFeedbackList;
Context context;

public FeedbackAdapter(Context context,ArrayList<GDGFeedback>feedbackList){

    gdgFeedbackList = feedbackList;
    this.context=context;
    GDGFeedback g = new GDGFeedback("mohit","student","graduate","Excellent",35,4,true);
    gdgFeedbackList.add(g);
}

 class FeedBackViewHolder extends RecyclerView.ViewHolder {

    TextView name,occupation,qualification,rating;
    public FeedBackViewHolder(@NonNull View itemView) {
        super(itemView);
        name = (TextView)itemView.findViewById(R.id.nameTV);
        occupation = (TextView)itemView.findViewById(R.id.occupationTV);
        qualification = (TextView)itemView.findViewById(R.id.qualificationTV);
        rating = (TextView)itemView.findViewById(R.id.ratingTV);


    }
 }
    @NonNull
    @Override
    public
    FeedBackViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

    View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent, false);
    return new FeedBackViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FeedBackViewHolder holder, int position) {

    GDGFeedback gf = gdgFeedbackList.get(position);
    holder.rating.setText(gf.rating+"");
    holder.qualification.setText(gf.qualification);
    holder.occupation.setText(gf.occupation);
    holder.qualification.setText(gf.qualification);
    holder.name.setText(gf.name+","+gf.age);
    }

    @Override
    public int getItemCount() {
        return gdgFeedbackList.size();
    }
}