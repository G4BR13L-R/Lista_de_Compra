package com.software.listadecompra;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextProduto = findViewById(R.id.produto);
        EditText editTextMarca = findViewById(R.id.marca);
        EditText editTextQuantidade = findViewById(R.id.quantidade);
        Button btnSalvar = findViewById(R.id.salvar);

        ListView listViewProdutos = findViewById(R.id.lista);
        List<Produto> listaProdutos = new ArrayList<>();

        ArrayAdapter adapter;
        adapter = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, listaProdutos);

        listViewProdutos.setAdapter(adapter);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Produto produto = new Produto();

                produto.setNome(editTextProduto.getText().toString());
                produto.setMarca(editTextMarca.getText().toString());
                produto.setQuantidade(Integer.parseInt(editTextQuantidade.getText().toString()));

                listaProdutos.add(produto);
                adapter.notifyDataSetChanged();

                Toast.makeText(MainActivity.this, "Produto Salvo!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}