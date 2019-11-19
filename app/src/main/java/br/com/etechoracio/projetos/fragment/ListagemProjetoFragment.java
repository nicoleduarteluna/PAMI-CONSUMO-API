package br.com.etechoracio.projetos.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.etechoracio.projetos.R;
import br.com.etechoracio.projetos.adapter.ProjetoAdapter;
import br.com.etechoracio.projetos.model.Projeto;
import br.com.etechoracio.projetos.service.ProjetoAPIService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class ListagemProjetoFragment extends Fragment {

    private RecyclerView recyclerView;

    private ProjetoAPIService service;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        this.service = new Retrofit.Builder().baseUrl("http://quiteriaetec.somee.com/api/Projetos/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build()
                .create(ProjetoAPIService.class);

        Call<List<Projeto>> call = this.service.getProjetos();
        call.enqueue(new Callback<List<Projeto>>() {
            @Override
            public void onResponse(Call<List<Projeto>> call, Response<List<Projeto>> response) {
                List<Projeto> lista = response.body();
                ProjetoAdapter adapter = new ProjetoAdapter(lista);
                recyclerView.setAdapter(adapter);
            }
            @Override
            public void onFailure(Call<List<Projeto>> call, Throwable t) {
                Log.e("ProjetoAPIService ", "Erro:" + t.getMessage());
            }
        });

        View view = inflater.inflate(R.layout.fragment_listagem_projeto, container, false);

        recyclerView = view.findViewById(R.id.lstProjetos);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));

        return view;
    }
}
