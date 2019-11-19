package br.com.etechoracio.projetos.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.etechoracio.projetos.R;
import br.com.etechoracio.projetos.holder.LineHolder;
import br.com.etechoracio.projetos.model.Projeto;

public class ProjetoAdapter extends RecyclerView.Adapter<LineHolder> {

    private List<Projeto> mProjetos;

    public ProjetoAdapter(List<Projeto> mProjetos) {
        this.mProjetos = mProjetos;
    }

    @NonNull
    @Override
    public LineHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        return new LineHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LineHolder viewHolder, int i) {
        viewHolder.getViewNome().setText(mProjetos.get(i).getNome());
    }

    @Override
    public int getItemCount() {
        return this.mProjetos.size();
    }

}
