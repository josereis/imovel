package com.imovel.ufpi.imovel.utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.imovel.ufpi.imovel.R;
import com.imovel.ufpi.imovel.models.Anuncio;

import java.util.List;

/**
 * Created by josereis on 08/07/17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewList> {
    protected Context mctx;
    private List<Anuncio> anuncios;
    public static ClickRecyclerView_Interface clickRecyclerView_interface;

    // Classe interna
    protected class RecyclerViewList extends RecyclerView.ViewHolder {
        protected TextView viewDescricao;
        protected TextView viewAnunciante;
        protected TextView viewLocalizacao;

        public RecyclerViewList(final View itemList) {
            super(itemList);

            viewDescricao = (TextView) itemList.findViewById(R.id.textview_descricao);
            viewAnunciante = (TextView) itemList.findViewById(R.id.textview_anunciante);
            viewLocalizacao = (TextView) itemList.findViewById(R.id.textview_localizacao);


            // configurando o ouvinte de click
            itemList.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickRecyclerView_interface.onCustomClick(anuncios.get(getLayoutPosition()));
                }
            });
        }
    }

    public RecyclerAdapter(Context ctx, List<Anuncio> anuncios, ClickRecyclerView_Interface clickRecyclerView_interface) {
        this.mctx = ctx;
        this.anuncios = anuncios;
        this.clickRecyclerView_interface = clickRecyclerView_interface;
    }

    @Override
    public int getItemCount() {
        return anuncios.size();
    }

    @Override
    public void onBindViewHolder(RecyclerViewList viewHolder, int i) {
        Anuncio anuncio = anuncios.get(i);

        viewHolder.viewDescricao.setText(anuncio.getImovel().getDescricao());
        viewHolder.viewAnunciante.setText(anuncio.getAnunciante().getName());
        viewHolder.viewLocalizacao.setText(anuncio.getImovel().getEndereco().toString());
    }

    @Override
    public RecyclerViewList onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_lista_anuncio, viewGroup, false);

        return new RecyclerViewList(itemView);
    }

}
