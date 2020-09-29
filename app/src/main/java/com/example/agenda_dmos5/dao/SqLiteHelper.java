package com.example.agenda_dmos5.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SqLiteHelper  extends SQLiteOpenHelper {

    public static final int DATBASE_VERSION = 1;
    public static final String DATABASE_NAME = "contacts.db";

    public static final String TABLE_NAME_CONTATOS = "contatos";
    public static final String COLUNM_NOME_COMPLETO = "nome_completo";
    public static final String COLUMN_TELEFONE_FIXO = "telefone_fixo";
    public static final String COLUMN_TELEFONE_CELULAR = "telefone_celular";


    public SqLiteHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATBASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql;

        sql = "CREATE TABLE " + TABLE_NAME_CONTATOS + " (";
        sql += COLUMN_TELEFONE_CELULAR + " TEXT NOT NULL, ";
        sql += COLUNM_NOME_COMPLETO + " TEXT NOT NULL, ";
        sql += COLUMN_TELEFONE_FIXO + " TEXT NOT NULL );";
        sql += "PRIMARY KEY (" + COLUMN_TELEFONE_CELULAR + ") );";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
