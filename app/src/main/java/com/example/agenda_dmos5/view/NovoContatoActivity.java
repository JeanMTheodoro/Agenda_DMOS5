package com.example.agenda_dmos5.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.agenda_dmos5.model.Contato;
import com.example.agenda_dmos5.dao.ContatoDao;
import com.example.agenda_dmos5.exeption.InsercaoDatabaseSqlite;
import com.example.agenda_dmos5.R;
import com.google.android.material.snackbar.Snackbar;

public class NovoContatoActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editTextNome;
    private EditText editTextTelefoneFixo;
    private EditText editTextTelefoneCelular;
    private Button bntSalvar;
    private ContatoDao mContatoDao;
    private Contato mContato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_usuario);


        editTextNome = findViewById(R.id.edittex_nome);
        editTextTelefoneFixo = findViewById(R.id.edittext_fone_fixo);
        editTextTelefoneCelular = findViewById(R.id.edittext_fone_celular);
        bntSalvar = findViewById(R.id.bnt_salvar);
        bntSalvar.setOnClickListener(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onClick(View view) {
        if (view == bntSalvar) {

            salvarContato(view);
        }
    }

    private void salvarContato(View view) {

        String nomeCompleto, telefoneFixo, telefoneCelular;

        nomeCompleto = editTextNome.getText().toString();
        telefoneFixo = editTextTelefoneFixo.getText().toString();
        telefoneCelular = editTextTelefoneCelular.getText().toString();

        if (nomeCompleto.isEmpty() || telefoneFixo.isEmpty() || telefoneCelular.isEmpty()) {
            showSnackbar(getString(R.string.erro_empty_fields), view);
        } else {

            mContatoDao = new ContatoDao(getApplicationContext());
            try{
                mContatoDao.adicionar(new Contato(telefoneCelular, nomeCompleto, telefoneFixo));
                finalizar(true);
            }catch (InsercaoDatabaseSqlite e){
                showSnackbar(getString(R.string.erro_duplicate_telefone_celualar), view);
            }catch (NullPointerException e){
                showSnackbar(getString(R.string.erro_duplicate_telefone_celualar), view);
            }

        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finalizar(false);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void finalizar(boolean sucesso) {
        if (sucesso) {
            setResult(Activity.RESULT_OK);
        } else {
            setResult(Activity.RESULT_CANCELED);
        }
        finish();
    }

    private void showSnackbar(String mensagem, View view) {
        Snackbar snackbar;
        snackbar = Snackbar.make(view, mensagem, Snackbar.LENGTH_SHORT);
        snackbar.show();
    }
}