package com.mohit.androidtrack3feedback;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Thanksactivity extends AppCompatActivity {

    TextView thank;
    FeedbackAdapter fadapter;
    RecyclerView feedbackRCV;
    ArrayList<GDGFeedback> gfList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanksactivity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        thank = (TextView) findViewById(R.id.tkTV);
        gfList = new ArrayList<GDGFeedback>();

        String nameEdt = getIntent().getStringExtra("name");

        GDGFeedback gf = (GDGFeedback) getIntent().getSerializableExtra("feedback");
        gfList.add(gf);
        fadapter = new FeedbackAdapter(this, gfList);
        feedbackRCV = (RecyclerView) findViewById(R.id.recycler);
        feedbackRCV.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        feedbackRCV.setAdapter(fadapter);
        fadapter.notifyDataSetChanged();

        thank.setText(thank.getText() + " " + nameEdt);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
