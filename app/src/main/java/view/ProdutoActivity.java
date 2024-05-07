package view

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.lugaluga.R;

import model.Produto;

class ProdutoActivity extends AppCompatActivity {

    private Produto produto;

    private TextView nomeProduto, qtdProduto, PrecoProduto, descProduto;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);

        nomeProduto = findViewById(R.id.nomeProduto);
        qtdProduto = findViewById(R.id.quantidade);
        PrecoProduto =  findViewById(R.id.preco);
        descProduto =  findViewById(R.id.descricao);

        produto = getIntent().getExtras().getParcelable("produto");

        nomeProduto.setText(produto.getNomePoduto());
        qtdProduto.setText(produto.getQuantidade());
        PrecoProduto.setText(produto.getPreco());
        descProduto.setText(produto.getDescricao());

    }
}