package com.example.agenda_dmos5.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.agenda_dmos5.adapter.ContadorAdapter;
import com.example.agenda_dmos5.model.Contato;
import com.example.agenda_dmos5.dao.ContatoDao;
import com.example.agenda_dmos5.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FloatingActionButton bntAdicionar;
    private ListView mListView;
    private List<Contato> mContatosList;
    private ContatoDao mContatoDao;
    private ContadorAdapter mContatoAdapter;
    public static final int REQUESTCODE_NOVO_CONTATO = 99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = findViewById(R.id.litsview_contato);
        bntAdicionar = findViewById(R.id.floating_adicionar);
        bntAdicionar.setOnClickListener(this);

        //Recuoerar Layout
        mListView = findViewById(R.id.litsview_contato);

        //recuperar Dados
        mContatoDao = new ContatoDao(this);
        mContatosList = mContatoDao.recuperaTodos();
        mContatoAdapter = new ContadorAdapter(this, mContatosList);
        mListView.setAdapter(mContatoAdapter);
    }

    @Override
    public void onClick(View view) {

        if (view == bntAdicionar) {

            startActivityForResult(new Intent(MainActivity.this,
                            NovoContatoActivity.class),
                    REQUESTCODE_NOVO_CONTATO);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        switch (requestCode){
            case REQUESTCODE_NOVO_CONTATO:
                if(resultCode ==RESULT_OK){

                    Toast.makeText(this, "contato salvo", Toast.LENGTH_LONG).show();
                    updateList();
                    mContatoAdapter.notifyDataSetChanged();

                }
                break;
        }


        super.onActivityResult(requestCode, resultCode, data);
    }

    private void updateList() {

        mContatosList.clear();
        mContatosList.addAll(mContatoDao.recuperaTodos());
    }
}