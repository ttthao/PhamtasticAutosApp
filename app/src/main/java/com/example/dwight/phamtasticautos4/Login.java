/*
 * Filename: Login.java
 * Author: Tommy Truong
 * Description: This file handles user login.
 * Date: 09/24/15
 * Sources of Help: TheNewBoston
 */

package com.example.dwight.phamtasticautos4;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;

public class Login extends ActionBarActivity {

    /* Email & password input fields */
    EditText emailInput,
            passwordInput;

    /* Temporary login credentials */
    private static final String LOGIN_EMAIL = "",
            LOGIN_PASSWORD = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /* Locate the input fields */
        emailInput = (EditText) findViewById(R.id.emailInput);
        passwordInput = (EditText) findViewById(R.id.passwordInput);

    }

    public void loginButtonClicked(View view) {

        /* Get input */
        String email = emailInput.getText().toString();
        String password = passwordInput.getText().toString();

        boolean emailCheck = email.equals(LOGIN_EMAIL),
                passwordCheck = password.equals(LOGIN_PASSWORD);

        if( emailCheck && passwordCheck )
        {
            /* Instantiate Intent to switch to menu (activity) */
            Intent i = new Intent(this, MainMenu.class);

            /* Launch activity, Intent i contains which activity we want to switch to */
            startActivity(i);
        }
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
}