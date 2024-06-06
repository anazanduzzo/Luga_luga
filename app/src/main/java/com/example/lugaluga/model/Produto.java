package com.example.lugaluga.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Produto implements Parcelable {
    private String nomePoduto;
    private String descricao;
    private int preco;
    private String quantidade;
    private boolean status;
//teste
    public Produto(){

    }

    public Produto(String nomePoduto, String descricao, int preco, String quantidade, boolean status) {
        this.nomePoduto = nomePoduto;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
        this.status = status;
    }

    protected Produto(Parcel in) {
        nomePoduto = in.readString();
        descricao = in.readString();
        preco = in.readInt();
        quantidade = in.readString();
        status = in.readByte() != 0;
    }

    public static final Creator<Produto> CREATOR = new Creator<Produto>() {
        @Override
        public Produto createFromParcel(Parcel in) {
            return new Produto(in);
        }

        @Override
        public Produto[] newArray(int size) {
            return new Produto[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(nomePoduto);
        dest.writeString(descricao);
        dest.writeInt(preco);
        dest.writeString(quantidade);
        dest.writeByte((byte) (status ? 1 : 0));
    }


}
