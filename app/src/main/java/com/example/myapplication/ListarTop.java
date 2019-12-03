package com.example.myapplication;

import android.os.AsyncTask;
import android.os.Bundle;


import com.example.myapplication.model.Reprovacao;
import com.example.myapplication.webservice.listar.UWCListarReprovacaoServiceSoapBinding;
import com.example.myapplication.webservice.listar.UWClistarReprovacaoResponse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class ListarTop extends AppCompatActivity {
    ListView recyclerView;
    CustomAdapter customAdapter;
    ArrayList<String> cursos2 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_top);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        cursos2 = new ArrayList<String>();

        List<Reprovacao> reprovados = this.listarReprovacoes();


        cursos2.add("1");
        cursos2.add("2");

        recyclerView = (ListView) this.findViewById(R.id.rv);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cursos2);


        recyclerView.setAdapter(adapter);

    }

    public List<Reprovacao> listarReprovacoes() {
        List<Reprovacao> temp = null;
        try {
            UWClistarReprovacaoResponse response = new UWCListarReprovacaoServiceSoapBinding().listarReprovacao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }

}
