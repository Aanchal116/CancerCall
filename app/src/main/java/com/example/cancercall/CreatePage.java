package com.example.cancercall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CreatePage extends AppCompatActivity {

    private EditText userName;
    private  EditText userAge;
    private  EditText userGender;
    private  EditText userType;
    private TextView regCancel;
    private Button regButton;

    private String name, gender, age, type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_page);
        setupUIViews();

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name = userName.getText().toString();
                if(name.isEmpty()){
                    Toast.makeText(CreatePage.this, "Name is empty", Toast.LENGTH_SHORT).show();
                }
                gender = userGender.getText().toString();
                if(gender.isEmpty()){
                    Toast.makeText(CreatePage.this, "Gender is empty", Toast.LENGTH_SHORT).show();
                }
                age = userAge.getText().toString();
                type = userType.getText().toString();
                if(validate()) {
                    Intent intent = new Intent(CreatePage.this, Entries.class);
                    intent.putExtra("name", name);
                    intent.putExtra("age", age);
                    intent.putExtra("gender", gender);
                    intent.putExtra("type", type);
                    startActivity(intent);
                }
            }
        });

        regCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreatePage.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setupUIViews() {
        userName = (EditText)findViewById(R.id.patientName);
        userAge = (EditText)findViewById(R.id.patientAge);
        userGender = (EditText)findViewById(R.id.patientGender);
        userType = (EditText)findViewById(R.id.cancerType);
        regButton = (Button)findViewById(R.id.patientRegister);
        regCancel = (TextView)findViewById(R.id.cancelRegister);

    }

    private Boolean validate() {
        boolean result = false;
        if(name.isEmpty() || gender.isEmpty() || age.isEmpty() || type.isEmpty()){
            Toast.makeText(this, "Please Enter All The Details!", Toast.LENGTH_SHORT).show();
        }
        else {
            result = true;
        }

        return result;
    }

}