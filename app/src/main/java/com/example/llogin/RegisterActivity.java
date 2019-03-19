package com.example.llogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText e1,e2,e3;
    Button b1;
    TextView t1;

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DatabaseHelper(this);
        e1 = findViewById(R.id.unm1);
        e2 = findViewById(R.id.pwd1);
        e3 = findViewById(R.id.pwd2);
        b1 = findViewById(R.id.btn4);
        t1 = findViewById(R.id.rg1);

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LoginIntent = new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(LoginIntent);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = e1.getText().toString().trim();
                String pwd = e2.getText().toString().trim();
                String pwd1 = e3.getText().toString().trim();

                if(pwd.equals(pwd1))
                {
                    long val = db.addUser(user,pwd);
                    if(val > 0)
                    {
                        Toast.makeText(RegisterActivity.this,"You have registered successfully",Toast.LENGTH_SHORT).show();
                        Intent moveToLogin = new Intent(RegisterActivity.this,MainActivity.class);
                        startActivity(moveToLogin);
                    }
                    else
                    {
                        Toast.makeText(RegisterActivity.this,"Registration Error",Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(RegisterActivity.this,"Password does not match",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
