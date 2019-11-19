package br.com.etechoracio.projetos.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.etechoracio.projetos.R;
import br.com.etechoracio.projetos.model.Projeto;
import br.com.etechoracio.projetos.service.ProjetoAPIService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class NovoProjetoFragment extends Fragment {

    private EditText editNome;
    private EditText editOrientadores;
    private EditText editSala;
    private EditText editTurma;
    private Button btnSalvar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_novo_projeto, container, false);

        editNome = view.findViewById(R.id.editNome);
        editOrientadores = view.findViewById(R.id.editOrientadores);
        editSala = view.findViewById(R.id.editSala);
        editTurma = view.findViewById(R.id.editTurma);
        btnSalvar = view.findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Projeto projeto = new Projeto();
                projeto.setNome(editNome.getText().toString());
                projeto.setOrientadores(editOrientadores.getText().toString());
                projeto.setSala(editSala.getText().toString());
                projeto.setTurma(editTurma.getText().toString());


                ProjetoAPIService service = new Retrofit.Builder().baseUrl("http://quiteriaetec.somee.com/api/Projetos/")
                        .addConverterFactory(JacksonConverterFactory.create())
                        .build()
                        .create(ProjetoAPIService.class);
                Call<Void> call = service.save(projeto);
                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        Toast.makeText(getContext(), "Cadastrado com sucesso", Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Log.e("ProjetoAPIService ", "Erro:" + t.getMessage());
                    }
                });
            }
        });

        return view;
    }
}
