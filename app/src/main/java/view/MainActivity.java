package view;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lugaluga.R;

import java.util.List;

import model.Produto;
import view.adapter.AdapterProduto;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdapterProduto adapterProduto;

    private List<Produto> produtoList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        recyclerView.findViewById(R.id.listaProdutos);


    }

    public void CriarListaProdutos(){
        Produto produto = new Produto(NomePoduto:"Iphone 13"
        Descricao:"Iphone 13 64gb"
        Preco:
        Quantidade:
        Status:
        )


    }
}
