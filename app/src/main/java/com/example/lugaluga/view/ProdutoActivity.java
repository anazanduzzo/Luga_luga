package com.example.lugaluga.view;


import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.lugaluga.R;
import com.example.lugaluga.model.Produto;


public class ProdutoActivity extends AppCompatActivity {

    private Produto produto;

    private TextView nomeProduto, qtdProduto, PrecoProduto, descProduto;

    private Button btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        nomeProduto = findViewById(R.id.nomeProduto);
        qtdProduto = findViewById(R.id.quantidade);
        PrecoProduto =  findViewById(R.id.preco);
        descProduto =  findViewById(R.id.descricao);
        btn = findViewById(R.id.btn);

        produto = getIntent().getExtras().getParcelable("produto");
        if (produto.getQuantidade().equals("0")){
            btn.setEnabled(false);
            btn.setText("Indisponível");
            btn.setTextColor(getColor(R.color.red));
        }

        nomeProduto.setText(produto.getNomePoduto());
        qtdProduto.setText(String.valueOf(produto.getQuantidade()));
        PrecoProduto.setText(String.valueOf(produto.getPreco()));
        descProduto.setText(produto.getDescricao());

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ProdutoActivity.this);
                builder.setMessage("Deseja realmente alugar esse produto?");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ProdutoActivity.this, "Produto solicitado com sucesso!",
                                Toast.LENGTH_SHORT).show();
                        btn.setText("Solicitado");
                        btn.setBackgroundColor(getColor(R.color.yellow));
                        btn.setEnabled(false);
                    }
                });
                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ProdutoActivity.this, "Produto cancelado com sucesso!",
                                Toast.LENGTH_SHORT).show();
                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

    }
}