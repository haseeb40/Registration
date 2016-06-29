package com.example.registration;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void onClick1(View view) {
        if (view.getId() == R.id.bL) {
            Intent in = new Intent(this, LoginActivity.class);
            startActivity(in);
        }

        if (view.getId() == R.id.bS) {
            EditText name = (EditText) findViewById(R.id.nametxt);
            EditText email = (EditText) findViewById(R.id.emailtxt);
            EditText uname = (EditText) findViewById(R.id.unametxt);
            EditText pass1 = (EditText) findViewById(R.id.pass1txt);
            EditText pass2 = (EditText) findViewById(R.id.pass2txt);


            String pass1str = pass1.getText().toString();

            String pass2str = pass2.getText().toString();
            assert name != null;
            String namestr = name.getText().toString();
            assert email != null;
            String emailstr = email.getText().toString();
            assert uname != null;
            String unamestr = uname.getText().toString();

            if (pass1str.equals("") || pass2str.equals("") || namestr.equals("") || emailstr.equals("") || unamestr.equals("")) {
                Toast.makeText(this, "Please fill all fields!", Toast.LENGTH_LONG).show();
            } else if (!pass1str.equals(pass2str)) {
                Toast.makeText(this, "Passwords don't match!", Toast.LENGTH_LONG).show();
            } else {
                //Inserting into Database
                Contact c = new Contact();
                c.setName(namestr);
                c.setEmail(emailstr);
                c.setPass(pass1str);
                c.setUname(unamestr);
                helper.onInsert(c);
                Toast.makeText(this, "Signedup!! To Login, Press Login Here Button!", Toast.LENGTH_LONG).show();

            }
        }
    }
}
