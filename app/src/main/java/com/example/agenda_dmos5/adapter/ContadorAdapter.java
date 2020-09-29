package com.example.agenda_dmos5.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.agenda_dmos5.R;
import com.example.agenda_dmos5.model.Contato;

import java.util.List;

public class ContadorAdapter extends BaseAdapter {

    private Context context;
    private List<Contato> elementos;

    public ContadorAdapter(Context context, List<Contato> contatos) {
        this.context = context;
        this.elementos = contatos;
    }

    @Override
    public int getCount() {
        return elementos.size();
    }

    @Override
    public Object getItem(int position) {
        return elementos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.item_contatos, parent, false);

        TextView nomeCompleto = (TextView) rowView.findViewById(R.id.textview_nome_completo);
        TextView telefoneFixo = (TextView) rowView.findViewById(R.id.textview_fone_fixo);
        TextView telefoneCelular = (TextView) rowView.findViewById(R.id.textview_fone_celular);

        nomeCompleto.setText(elementos.get(position).getNomeCompleto());
        telefoneFixo.setText(elementos.get(position).getTelefoneFixo());
        telefoneCelular.setText(elementos.get(position).getGetTelefoneCelular());

        return rowView;
    }
}
