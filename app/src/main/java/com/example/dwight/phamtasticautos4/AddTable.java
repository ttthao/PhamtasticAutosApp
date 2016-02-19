package com.example.dwight.phamtasticautos4;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddTable extends ActionBarActivity {

    private static int ctr = 0;

    DatabaseHandler db;

    private static EditText inputField;

    private static final String TABLE_NAME_PROMPT = "Please enter the table name.",
            DATE_PROMPT = "Please enter today's date.",
            UNIT_NUM_PROMPT = "Please enter the vehicle's unit number.",
            VIN_NUM_PROMPT = "Please enter the vehicle's VIN number.",
            LICENSE_NUM_PROMPT = "Please enter the vehicle's license plate number",
            MILEAGE_PROMPT = "Please enter the vehicle's mileage.",
            CODE_PROMPT = "Please enter the code or claim number.",
            YEAR_PROMPT = "Please enter the vehicle's year of manufacturing.",
            MAKE_PROMPT = "Please enter the vehicles make.",
            MODEL_PROMPT = "Please enter the vehicle's model.",
            COLOR_PROMPT = "Please enter the vehicle's color.",
            WORK_DONE_PROMPT = "Please enter the work done for the vehicle.",
            PRICE_PROMPT = "Please enter the price of the work done.",
            REVIEW_PROMPT = "Please review that the information is correct.";

    private String local = "8v",
            date,
            unitNum,
            vinNum,
            licenseNum,
            code = "",
            make,
            model,
            color,
            workDone;

    private int mileage,
            year,
            price;

    private static TextView promptText,
            dbDisplay,
            localData,
            dateData,
            unitNumData,
            vinNumData,
            licenseNumData,
            mileageData,
            codeData,
            yearData,
            makeData,
            modelData,
            colorData,
            workData,
            priceData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_table);


        /* Input field & prompt text of top section */
        inputField = (EditText) findViewById(R.id.inputField);
        promptText = (TextView) findViewById(R.id.promptText);

        /*** Instantiate all the TextViews of the bottom section */
        dbDisplay = (TextView) findViewById(R.id.dbDisplay);
        localData = (TextView) findViewById(R.id.localData);
        dateData = (TextView) findViewById(R.id.dateData);
        unitNumData = (TextView) findViewById(R.id.unitNumData);
        vinNumData = (TextView) findViewById(R.id.vinNumData);
        licenseNumData = (TextView) findViewById(R.id.licenseNumData);
        mileageData = (TextView) findViewById(R.id.mileageData);
        codeData = (TextView) findViewById(R.id.codeData);
        yearData = (TextView) findViewById(R.id.yearData);
        makeData = (TextView) findViewById(R.id.makeData);
        modelData = (TextView) findViewById(R.id.modelData);
        colorData = (TextView) findViewById(R.id.colorData);
        workData = (TextView) findViewById(R.id.workData);
        priceData = (TextView) findViewById(R.id.priceData);

        localData.setText("8v");

        /* Prompt the user for the date, which will the be the table name as well */
        promptText.setText(TABLE_NAME_PROMPT);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_table, menu);
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

    public void enterData(String data) {

        switch(this.ctr++)
        {
            case 0:
                /* Start database w/user selected table name */
                db = new DatabaseHandler(this, null, null, 1, data);

                /* Prompt the user for the date */
                promptText.setText(DATE_PROMPT);
                break;

            case 1:
                date = data;
                dateData.setText(data);

                promptText.setText(UNIT_NUM_PROMPT);
                break;

            case 2:
                unitNum = data;
                unitNumData.setText(data);

                promptText.setText(VIN_NUM_PROMPT);
                break;

            case 3:
                vinNum = data;
                vinNumData.setText(data);

                promptText.setText(LICENSE_NUM_PROMPT);
                break;

            case 4:
                licenseNum = data;
                licenseNumData.setText(data);

                promptText.setText(MILEAGE_PROMPT);
                break;

            case 5:
                int mileageTemp = Integer.parseInt(data);

                mileage = mileageTemp;
                mileageData.setText(data);

                promptText.setText(YEAR_PROMPT);
                break;

            case 6:
                int yearTemp = Integer.parseInt(data);

                year = yearTemp;
                yearData.setText(data);

                promptText.setText(MAKE_PROMPT);
                break;

            case 7:
                make = data;
                makeData.setText(data);

                promptText.setText(MODEL_PROMPT);
                break;

            case 8:
                model = data;
                modelData.setText(data);

                promptText.setText(COLOR_PROMPT);
                break;

            case 9:
                color = data;
                colorData.setText(data);

                promptText.setText(WORK_DONE_PROMPT);
                break;

            case 10:
                workDone = data;
                workData.setText(data);

                promptText.setText(PRICE_PROMPT);
                break;

            case 11:
                int priceTemp = Integer.parseInt(data);

                price = priceTemp;
                priceData.setText(data);

                promptText.setText(REVIEW_PROMPT);
                break;

            case 12:

                /* After user guarantees inputted data is correct, instantiate service object */
                Service service = new Service(local, date, unitNum, vinNum, licenseNum, code, make,
                        model, color, workDone, mileage, year, price);

                /* Add entry onto the table */
                db.addService(service);

                /* Print all entries from the db */
                dbDisplay.setText(db.dbToString());

                resetDisplay();

                break;
        }

        /* Reset inputfield */
        inputField.setText("");
    }

    public void submitButtonClicked(View view) {

        /* Cycle to next prompt */
        if(this.ctr<13)
            enterData(inputField.getText().toString());
        else
            finish();
    }

    public void resetDisplay() {

        localData.setText("Local:");
        dateData.setText("Date:");
        unitNumData.setText("Unit #");
        vinNumData.setText("Vin #");
        licenseNumData.setText("License #");
        mileageData.setText("Mileage:");
        codeData.setText("Code/claim #");
        yearData.setText("Year:");
        makeData.setText("Make:");
        modelData.setText("Model:");
        colorData.setText("Color:");
        workData.setText("Work Done:");
        priceData.setText("Price:");
    }
}



