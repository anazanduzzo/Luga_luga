package com.example.lugaluga.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.lugaluga.R;
import com.example.lugaluga.controller.UsuarioController;
import com.example.lugaluga.model.Usuario;
import com.example.lugaluga.view.adapter.AdapterUsuario;

import java.util.ArrayList;
import java.util.List;


public class UsuariosCadastradosFragment extends Fragment {

    private RecyclerView recyclerView;
    private AdapterUsuario adapterUsuario;
    private List<Usuario> listaUsuario = new ArrayList<>();

    public UsuariosCadastradosFragment() {

    }

    public static UsuariosCadastradosFragment newInstance() {
        UsuariosCadastradosFragment fragment = new UsuariosCadastradosFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_usuarios_cadastrados, container, false);

        recyclerView = view.findViewById(R.id.rv_listaUsuarios);

        CriarListaUsuarios();

        adapterUsuario = new AdapterUsuario(listaUsuario);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterUsuario);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), recyclerView,
                new RecyclerItemClickListener.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    }

                    @Override
                    public void onItemClick(View view, int position) {
                        Intent intent = new Intent(getContext(), CadastrarUsuarioActivity.class);
                        intent.putExtra("usuario", listaUsuario.get(position));
                        startActivity(intent);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        Toast.makeText(getContext(), listaUsuario.get(position).getNome(),Toast.LENGTH_SHORT).show();
                    }
                }));
        return view;
    }

    public void CriarListaUsuarios() {
        UsuarioController usuarioController = new UsuarioController(getContext());
        listaUsuario.addAll(usuarioController.carregaUsuario());
    }
}