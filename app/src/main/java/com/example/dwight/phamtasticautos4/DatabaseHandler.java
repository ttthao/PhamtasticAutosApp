package com.example.dwight.phamtasticautos4;
/*
 * Filename: DatabaseHandler.java
 * Author: Tommy Truong
 * Description: This file records every new table entry in the database.
 * Date: 09/24/15
 * Sources of Help: TheNewBoston
 */

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;
import java.io.FileWriter;
import java.io.File;

public class DatabaseHandler extends SQLiteOpenHelper {

    /* Database version */
    private static final int DB_VER = 1;

    /* Table title will be determined by the user */
    public static String TABLE_NAME;

    /* Database title */
    private static final String DB_NAME = "record.db";
                                //GATHER = "SELECT * FROM " + TABLE_NAME + " WHERE 1";

    /* Services column */
    public static final String  COLUMN_LOCAL = "local",
            COLUMN_DATE = "date",
            COLUMN_UNIT_NUM = "UnitNum",
            COLUMN_VIN_NUM = "VinNum",
            COLUMN_LICENSE_NUM = "LicenseNum",
            COLUMN_MILEAGE = "Mileage",
            COLUMN_CODE = "ClaimNum",
            COLUMN_YEAR = "Year",
            COLUMN_MAKE = "Make",
            COLUMN_MODEL = "Model",
            COLUMN_COLOR = "Color",
            COLUMN_WORK_DONE = "Work",
            COLUMN_PRICE = "Price";

    /* Ctor - will also establish table name */
    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, String tableName) {
        super(context, DB_NAME, factory, DB_VER);

        TABLE_NAME = tableName;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        /* Query to be create table Inventory w/specified columns */
        String query = "CREATE TABLE " + TABLE_NAME + "" +
                "(" +
                COLUMN_LOCAL + " TEXT, " +
                COLUMN_DATE + " TEXT, " +
                COLUMN_UNIT_NUM + " TEXT PRIMARY KEY," +
                COLUMN_VIN_NUM + " TEXT, " +
                COLUMN_LICENSE_NUM + " TEXT, " +
                COLUMN_MILEAGE + " INTEGER, " +
                COLUMN_CODE + " TEXT, " +
                COLUMN_YEAR + " INTEGER, " +
                COLUMN_MAKE + " TEXT, " +
                COLUMN_MODEL + " TEXT, " +
                COLUMN_COLOR + " TEXT, " +
                COLUMN_WORK_DONE + " TEXT, " +
                COLUMN_PRICE + " INTEGER " +
                ");";

        /* Create the database & table */
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        /* Delete table if existing */
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        /* Recreate table */
        onCreate(db);
    }

    /* Insert row into database */
    public void addService(Service service) {

        /* Allows changing data for columns & insert all easily */
        ContentValues values = new ContentValues();

        /* Insert data for each column */
        values.put(COLUMN_LOCAL, service.getLocalCode());
        values.put(COLUMN_DATE, service.getDate());
        values.put(COLUMN_UNIT_NUM, service.getUnitNum());
        values.put(COLUMN_VIN_NUM, service.getVinNum());
        values.put(COLUMN_LICENSE_NUM, service.getLicenseNum());
        values.put(COLUMN_MILEAGE, service.getMileage());
        values.put(COLUMN_CODE, service.getCode());
        values.put(COLUMN_YEAR, service.getYear());
        values.put(COLUMN_MAKE, service.getMake());
        values.put(COLUMN_MODEL, service.getModel());
        values.put(COLUMN_COLOR, service.getColor());
        values.put(COLUMN_WORK_DONE, service.getWorkDone());
        values.put(COLUMN_PRICE, service.getPrice());

        /* Get current database */
        SQLiteDatabase db = getWritableDatabase();

        /* Insert row */
        db.insert(TABLE_NAME, null, values);

        /* Close database */
        db.close();
    }

    public void export(String table) {
        String query = "SELECT * FROM " + table + " WHERE 1";
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(query);
    }

    /* Print out the database */
    public String dbToString() {

        /* String to hold database results */
        String dbString = "",
                query = "SELECT * FROM " + TABLE_NAME + " WHERE 1";

        /* Current database */
        SQLiteDatabase db = getWritableDatabase();

        /* Cursor/ptr points to location in table */
        Cursor c = db.rawQuery(query, null);

        /* Move to 1st row in table */
        c.moveToFirst();

        /* Appending data */
        while( !c.isAfterLast() )
        {
            /*** GATHER ALL DATA FROM EVERY COLUMN OF 1 ROW */
            if (c.getString(c.getColumnIndex(COLUMN_LOCAL)) != null) {
                dbString += c.getString(c.getColumnIndex(COLUMN_LOCAL));
                dbString += " ";
            }

            if (c.getString(c.getColumnIndex(COLUMN_DATE)) != null) {
                dbString += c.getString(c.getColumnIndex(COLUMN_DATE));
                dbString += " ";
            }

            if (c.getString(c.getColumnIndex(COLUMN_UNIT_NUM)) != null) {
                dbString += c.getString(c.getColumnIndex(COLUMN_UNIT_NUM));
                dbString += " ";
            }


            if (c.getString(c.getColumnIndex(COLUMN_VIN_NUM)) != null) {
                dbString += c.getString(c.getColumnIndex(COLUMN_VIN_NUM));
                dbString += " ";
            }

            if (c.getString(c.getColumnIndex(COLUMN_LICENSE_NUM)) != null) {
                dbString += c.getString(c.getColumnIndex(COLUMN_LICENSE_NUM));
                dbString += " ";
            }

            if (c.getString(c.getColumnIndex(COLUMN_MILEAGE)) != null) {
                dbString += c.getString(c.getColumnIndex(COLUMN_MILEAGE));
                dbString += " ";
            }

            if (c.getString(c.getColumnIndex(COLUMN_CODE)) != null) {
                dbString += c.getString(c.getColumnIndex(COLUMN_CODE));
                dbString += " ";
            }

            if (c.getString(c.getColumnIndex(COLUMN_YEAR)) != null) {
                dbString += c.getString(c.getColumnIndex(COLUMN_YEAR));
                dbString += " ";
            }

            if (c.getString(c.getColumnIndex(COLUMN_MAKE)) != null) {
                dbString += c.getString(c.getColumnIndex(COLUMN_MAKE));
                dbString += " ";
            }

            if (c.getString(c.getColumnIndex(COLUMN_MODEL)) != null) {
                dbString += c.getString(c.getColumnIndex(COLUMN_MODEL));
                dbString += " ";
            }

            if (c.getString(c.getColumnIndex(COLUMN_COLOR)) != null) {
                dbString += c.getString(c.getColumnIndex(COLUMN_COLOR));
                dbString += " ";
            }

            if (c.getString(c.getColumnIndex(COLUMN_WORK_DONE)) != null) {
                dbString += c.getString(c.getColumnIndex(COLUMN_WORK_DONE));
                dbString += " ";
            }

            if (c.getString(c.getColumnIndex(COLUMN_PRICE)) != null)
            {
                dbString += c.getString(c.getColumnIndex(COLUMN_PRICE));
                dbString += "\n";
            }

            c.moveToNext();
        }

        /* Closure */
        db.close();

        return dbString;
    }
}