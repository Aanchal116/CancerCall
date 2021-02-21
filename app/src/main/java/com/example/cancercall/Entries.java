package com.example.cancercall;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Entries extends AppCompatActivity {

    private Button edit;
    private Button done;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entries);

        Intent intent = getIntent();

        String name_entry = intent.getStringExtra("name");
        String gender_entry = intent.getStringExtra("gender");
        String age_entry = intent.getStringExtra("age");
        String type_entry = intent.getStringExtra("type");

        TextView pName_entry = (TextView)findViewById(R.id.pName);
        pName_entry.setText(name_entry);

        TextView pAge_entry = (TextView)findViewById(R.id.pAge);
        pAge_entry.setText(age_entry);

        TextView pGender_entry = (TextView)findViewById(R.id.pGender);
        pGender_entry.setText(gender_entry);

        TextView pType_entry = (TextView)findViewById(R.id.pType);
        pType_entry.setText(type_entry);

        edit = (Button)findViewById(R.id.editButton);
        done = (Button)findViewById(R.id.doneButton);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Entries.this, CreatePage.class);
                startActivity(intent);
            }
        });

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Entries.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}