package com.example.dwight.phamtasticautos4;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainMenu extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    /* Switch to input activity */
    public void createNewTableButtonClicked(View view) {

        /* Instantiate Intent to switch to adding screen (activity) */
        Intent i = new Intent(this, AddTable.class);

        /* Launch activity, Intent i contains which activity we want to switch to */
        startActivity(i);

        //finish();
    }

    /* Alter existing tables (add) *
    public void modifyExistingTablesButtonClicked(View view) {

        /* Instantiate Intent to switch to adding screen (activity) *
        Intent i = new Intent(this, .class);

        /* Launch activity, Intent i contains which activity we want to switch to *
        startActivity(i);

    }*/


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_menu, menu);
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
