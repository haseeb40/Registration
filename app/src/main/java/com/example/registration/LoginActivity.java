package com.example.registration;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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

    public void onClick(View view) {
        if (view.getId() == R.id.BLogin) {
                EditText uname = (EditText) findViewById(R.id.unamel);
                assert uname != null;
                String unamestr = uname.getText().toString();
                EditText pass = (EditText) findViewById(R.id.passl);
                assert pass != null;
                String strp = pass.getText().toString();
                String password = helper.searchpass(unamestr);
                if (strp.equals(password)) {
                    Intent i = new Intent(this, WelcomeActivity.class);
                    i.putExtra("name", unamestr);
                    startActivity(i);
                }
                else {
                    Toast.makeText(LoginActivity.this,"Incorrect User Name or Password!",Toast.LENGTH_LONG).show();
                }
            }
        if (view.getId() == R.id.BSignup) {
            Intent intent = new Intent(this, SignupActivity.class);
            startActivity(intent);
        }
    }
}
