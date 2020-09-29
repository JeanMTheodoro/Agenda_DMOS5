package com.example.agenda_dmos5.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.agenda_dmos5.model.Contato;
import com.example.agenda_dmos5.exeption.InsercaoDatabaseSqlite;

import java.util.ArrayList;
import java.util.List;

public class ContatoDao {

    private SQLiteDatabase mSqLiteDatabase;
    private SqLiteHelper mHelper;

    public ContatoDao(Context context) {
        mHelper = new SqLiteHelper(context);
    }

    public void adicionar(Contato contato) throws NullPointerException, InsercaoDatabaseSqlite {
        if (contato == null) {
            throw new NullPointerException();
        }

        ContentValues valores = new ContentValues();
        valores.put(SqLiteHelper.COLUNM_NOME_COMPLETO, contato.getNomeCompleto());
        valores.put(SqLiteHelper.COLUMN_TELEFONE_FIXO, contato.getTelefoneFixo());
        valores.put(SqLiteHelper.COLUMN_TELEFONE_CELULAR, contato.getGetTelefoneCelular());
        mSqLiteDatabase = mHelper.getWritableDatabase();

        if(mSqLiteDatabase.insert(SqLiteHelper.TABLE_NAME_CONTATOS, null, valores) == -1){
            throw new InsercaoDatabaseSqlite("Erro ao adicionar Contato");
        }

        mSqLiteDatabase.close();
    }

    public List<Contato> recuperaTodos(){
        List<Contato> mContatoList;
        Contato mContato;
        Cursor mCursor;

        mContatoList = new ArrayList<>();

        String colunas[] = new String[]{
                SqLiteHelper.COLUMN_TELEFONE_CELULAR,
                SqLiteHelper.COLUNM_NOME_COMPLETO,
                SqLiteHelper.COLUMN_TELEFONE_FIXO
        };

        mSqLiteDatabase = mHelper.getReadableDatabase();

        mCursor = mSqLiteDatabase.query(
                SqLiteHelper.TABLE_NAME_CONTATOS,
                colunas,
                null,
                null,
                null,
                null,
                SqLiteHelper.COLUNM_NOME_COMPLETO
        );

        while (mCursor.moveToNext()){
            mContato = new Contato(
                    mCursor.getString(0),
                    mCursor.getString(1),
                    mCursor.getString(2)
            );
            mContatoList.add(mContato);
        }

        mCursor.close();
        mSqLiteDatabase.close();
        return mContatoList;
    }
}
