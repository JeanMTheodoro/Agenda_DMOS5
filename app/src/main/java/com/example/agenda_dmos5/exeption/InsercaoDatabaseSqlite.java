package com.example.agenda_dmos5.exeption;

import android.database.sqlite.SQLiteException;

public class InsercaoDatabaseSqlite extends SQLiteException {
    public InsercaoDatabaseSqlite(String error){
        super(error);
    }
}
