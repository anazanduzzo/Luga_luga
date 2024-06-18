package com.example.lugaluga.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.lugaluga.model.Produto;
import com.example.lugaluga.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioController {

    private SQLiteDatabase db;
    private CriarBanco banco;

    public UsuarioController(Context context){
        banco = new CriarBanco(context);
    }

    public boolean insereDados(String nome, String cpf, String dataNasc, String cep, String cidade,
                              String logradouro, int numero, String complemento, String bairro,
                              int telefone, String email, String senha, String uf){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriarBanco.NOME, nome);
        valores.put(CriarBanco.CPF, cpf);
        valores.put(CriarBanco.DATA_NASC, dataNasc);
        valores.put(CriarBanco.CEP, cep);
        valores.put(CriarBanco.MUNICIPIO, cidade);
        valores.put(CriarBanco.LOGRADOURO, logradouro);
        valores.put(CriarBanco.NUMERO, numero);
        valores.put(CriarBanco.COMPLEMENTO, complemento);
        valores.put(CriarBanco.BAIRRO, bairro);
        valores.put(CriarBanco.TELEFONE, telefone);
        valores.put(CriarBanco.EMAIL, email);
        valores.put(CriarBanco.SENHA, senha);
        valores.put(CriarBanco.UF, uf);

        resultado = db.insert(CriarBanco.NOME_TABELA, null, valores);
        db.close();

        if (resultado == -1){
            return false;
        }
        return true;
    }

    public boolean verificaUsuario(String email,String senha){
        long resuntado;
        String selection = "email = ? and senha = ?";
        String[] selectionArgs = {email,senha};
        Cursor cursor;
        db = banco.getReadableDatabase();
        cursor = db.query(CriarBanco.NOME_TABELA,null,selection,selectionArgs,
                null,null,null,null);
        if (cursor.getCount() > 0){
            return true;
        }

        return false;
    }

    public List<Usuario> carregaUsuario(){
        Cursor cursor;
        List<Usuario>usuarioList = new ArrayList<>();
        db = banco.getReadableDatabase();
        cursor = db.query("usuarios",null,null,null,null,null,null);

        if (db != null){
            while (cursor.moveToNext()){
                Usuario usuario = new Usuario();
                usuario.setNome(cursor.getString(1));
                usuario.setCpf(cursor.getString(2));
                usuario.setEmail(cursor.getString(3));
                usuarioList.add(usuario);
            }
        }
        return usuarioList;
    }

}
