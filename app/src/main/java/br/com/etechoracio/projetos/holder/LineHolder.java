package br.com.etechoracio.projetos.holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import br.com.etechoracio.projetos.R;

public class LineHolder extends RecyclerView.ViewHolder {

    private TextView viewNome;

    public LineHolder(@NonNull View itemView) {
        super(itemView);

        viewNome = itemView.findViewById(R.id.itemNome);

    }

    public TextView getViewNome() {
        return viewNome;
    }

}
