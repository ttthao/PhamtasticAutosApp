package com.example.dwight.phamtasticautos4;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;

import java.sql.PreparedStatement;

public class exportToCSV extends ActionBarActivity {

    private static EditText inputField2;
    private static DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_export_to_csv);

        inputField2 = (EditText) findViewById(R.id.inputField2);

    }

    public void exportButtonClicked(View view) {

        String dbName = inputField2.getText().toString();
        db = new DatabaseHandler(this, null, null, 1, dbName);


    }


}
