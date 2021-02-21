package com.example.cancercall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText)findViewById(R.id.etName);
        Password = (EditText)findViewById(R.id.etPassword);
        Info = (TextView)findViewById(R.id.tvInfo);
        Login = (Button)findViewById(R.id.loginButton);

        Info.setText("No. of Attempts Remaining : 5");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Name.getText().toString().isEmpty() || Password.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Please Enter Correct Details!", Toast.LENGTH_SHORT).show();
                }

                validate(Name.getText().toString(), Password.getText().toString());
            }
        });


    }


    private void validate(String userName, String userPassword) {
        if((userName.equals("Admin")) && (userPassword.equals("12345"))){
            Intent intent = new Intent(this, CreatePage.class);
            startActivity(intent);
        }
        else {
            counter--;
            Toast.makeText(this, "Incorrect Credentials Entered!", Toast.LENGTH_SHORT).show();
            Info.setText("No. of Attempts Remaining : " + String.valueOf(counter));

            if(counter == 0){
                Login.setEnabled(false);
            }
        }

        }


}