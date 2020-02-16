package com.mohit.androidtrack3feedback;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.provider.MediaStore;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    Button sumbit;
    EditText nameEdt;
    RatingBar rb;
    Spinner qualificationspn;
    RadioButton prof,stu;
    EditText suggestionET;
    SeekBar ageSB;
    CheckBox agreeSB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        nameEdt = (EditText)findViewById(R.id.nameEdt);
        rb = (RatingBar)findViewById(R.id.rt);
        qualificationspn = (Spinner)findViewById(R.id.qualificationSpn);
        agreeSB = (CheckBox)findViewById(R.id.consentCB);
        ageSB = (SeekBar)findViewById(R.id.age);
        suggestionET = (EditText)findViewById(R.id.sug);
        prof = (RadioButton)findViewById(R.id.profRB);
        stu = (RadioButton)findViewById(R.id.studentRB);
        sumbit = (Button)findViewById(R.id.sumbitBtn);

        sumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = nameEdt.getText().toString();
                String suggestion = suggestionET.getText().toString();
                String qualification = qualificationspn.getSelectedItem().toString();
                String occupation = null;
                if(stu.isChecked()){
                    occupation = "Student";
                }
                if(prof.isChecked()){
                    occupation = "Proffesional";
                }
                int age = ageSB.getProgress();
                boolean isAgree = agreeSB.isChecked();
                int rating = rb.getProgress();

                GDGFeedback gf = new GDGFeedback(name,occupation,qualification,suggestion,age,rating,isAgree);

                Intent i =new Intent(MainActivity.this,Thanksactivity.class);
                i.putExtra("name",nameEdt.getText().toString());
                i.putExtra("feedback",gf);
                startActivity(i);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
