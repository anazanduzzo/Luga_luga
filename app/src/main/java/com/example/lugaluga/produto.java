package com.example.lugaluga;

public class produto {
    private String nomePoduto;
    private String descricao;
    private int preco;
    private String quantidade;
    private boolean status;

    public produto(){

    }

    public produto(String nomePoduto, String descricao, int preco, String quantidade, boolean status) {
        this.nomePoduto = nomePoduto;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
        this.status = status;
    }

    public String getNomePoduto() {
        return nomePoduto;
    }

    public void setNomePoduto(String nomePoduto) {
        this.nomePoduto = nomePoduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
