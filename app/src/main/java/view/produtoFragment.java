package view;

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

import java.util.ArrayList;
import java.util.List;

import model.Produto;
import view.adapter.AdapterProduto;

public class produtoFragment extends Fragment {

    private RecyclerView recyclerView;
    private AdapterProduto adapterProduto;
    private List<Produto> produtoList = new ArrayList<>();

    public produtoFragment() {
        // Required empty public constructor
    }

    public static produtoFragment newInstance() {
        produtoFragment fragment = new produtoFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_produto,container,false);

        recyclerView = view.findViewById(R.id.listaProdutos);

        CriarListaProdutos();

        adapterProduto = new AdapterProduto(produtoList);


        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterProduto);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), recyclerView,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent intent = new Intent(getContext(),ProdutoActivity.class);
                        intent.putExtra("produto",produtoList.get(position));
                        startActivity(intent);

                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        Toast.makeText(getContext(),produtoList.get(position).getDescricao(),Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    }
                }));

        return view;
    }

    public void CriarListaProdutos(){

        Produto produto = new Produto("Iphone 13",
                "Iphone 13 64gb,branco",
                2500,
                "10",
                true
        );
        produtoList.add(produto);

        produto = new Produto("Fone",
                "fone bluetooth,cor roxa",
                200,
                "0",
                false
        );
        produtoList.add(produto);

        produto = new Produto(
                "Notebook",
                "Dell, SSD 256gb, cor preta",
                3500,
                "0",
                false
        );
        produtoList.add(produto);

        produto = new Produto(
                "samsung s23",
                "256gb,8GRAM,cor dourada",
                2500,
                "8",
                true
        );
        produtoList.add(produto);

        produto = new Produto(
                "Apple Watch",
                "cor rosa",
                2300,
                "4",
                true
        );
        produtoList.add(produto);

        produto = new Produto(
                "Air tag",
                "localizador da apple",
                369,
                "0",
                false
        );
        produtoList.add(produto);

        produto = new Produto(
                "carregador por indução",
                "cor branca",
                100,
                "50",
                true
        );
        produtoList.add(produto);

        produto = new Produto(
                "Ipad pro",
                "SSD 256gb, cor roxa",
                7100,
                "3",
                true
        );
        produtoList.add(produto);

        produto = new Produto(
                "Ring light",
                "12 polegadas,suporte cor preta",
                370,
                "25",
                true
        );
        produtoList.add(produto);

        produto = new Produto(
                "Carregador portatil",
                "carregamento rápido por indução",
                265,
                "18",
                true
        );
        produtoList.add(produto);
    }
}
