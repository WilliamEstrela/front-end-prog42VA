package com.example.myapplication;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;


import com.example.myapplication.webservice.cadastrar.SACIncluirReprovacaoServiceSoapBinding;
import com.example.myapplication.webservice.cadastrar.SACreprovacao;
import com.example.myapplication.webservice.cadastrar.SACretorno;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    TextView txtCPF;
    TextView txtMatricula;
    TextView txtMateria;
    TextView txtProfessor;
    TextView txtNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtCPF = findViewById(R.id.txtCPF);
        txtMatricula = findViewById(R.id.txtMatricula);
        txtMateria = findViewById(R.id.txtMateria);
        txtProfessor = findViewById(R.id.txtProfessor);
        txtNome = findViewById(R.id.txtNome);

        Button btnListar = findViewById(R.id.btnListar);
        btnListar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ListarTop.class);
                startActivity(intent);
            }
        });

        Button btnSalvar = findViewById(R.id.btnSalvar);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                SACreprovacao reprovacao = new SACreprovacao();

                reprovacao.cpf = txtCPF.getText().toString();
                reprovacao.matricula = txtMatricula.getText().toString();
//                reprovacao.materia = txtMateria.getText().toString();
                reprovacao.professor = txtProfessor.getText().toString();
                reprovacao.nome = txtNome.getText().toString();


                new ReprovacaoTask().execute(reprovacao);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    class ReprovacaoTask extends AsyncTask<SACreprovacao, Void, SACretorno>{

        @Override
        protected SACretorno doInBackground(SACreprovacao... reprovacao) {

            SACIncluirReprovacaoServiceSoapBinding service = new SACIncluirReprovacaoServiceSoapBinding();
            try{
                service.inserirReprovacao(reprovacao[0]);
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(SACretorno aReprovacao) {
            super.onPostExecute(aReprovacao);
        }
    }
}
