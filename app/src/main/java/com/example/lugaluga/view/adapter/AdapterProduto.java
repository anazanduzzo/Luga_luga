package com.example.lugaluga.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lugaluga.R;
import com.example.lugaluga.model.Produto;

import java.util.List;


public class AdapterProduto extends RecyclerView.Adapter<AdapterProduto.ViewHolder> {

    private List <Produto> produtoList;

    public AdapterProduto(List<Produto> produtoList) {
        this.produtoList = produtoList;
    }


    @NonNull
    @Override
    public AdapterProduto.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View listaProduto = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_produto,parent,false);

        return new ViewHolder(listaProduto);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterProduto.ViewHolder holder, int position) {
        holder.nomeProduto.setText(produtoList.get(position).getNomePoduto());
        holder.precoProduto.setText(String.valueOf(produtoList.get(position).getPreco()));
        holder.descProduto.setText(produtoList.get(position).getDescricao());
    }

    @Override
    public int getItemCount() {
        return produtoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nomeProduto,precoProduto,descProduto;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nomeProduto = itemView.findViewById(R.id.nomeProduto);
            precoProduto = itemView.findViewById(R.id.precoProduto);
            descProduto = itemView.findViewById(R.id.descProduto);
        }
    }
}
