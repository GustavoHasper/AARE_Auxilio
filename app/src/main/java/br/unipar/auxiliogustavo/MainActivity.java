package br.unipar.auxiliogustavo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.time.LocalDate;
import java.util.*;
import java.text.*;


public class MainActivity extends AppCompatActivity {

    //declarando objetos da tela
    EditText tvCPF;
    EditText dtDiaNasc;
    EditText dtMesNasc;
    EditText dtAnoNasc;
    EditText tvRendaMensal;
    Button btVerificar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //associa os objetos
        tvCPF = (EditText) findViewById(R.id.tvCPF);
        dtDiaNasc = (EditText) findViewById(R.id.dtDiaNasc);
        dtMesNasc = (EditText) findViewById(R.id.dtMesNasc);
        dtAnoNasc = (EditText) findViewById(R.id.dtAnoNasc);
        tvRendaMensal = (EditText) findViewById(R.id.tvRendaMensal);
        Button btVerificar = (Button) findViewById(R.id.btVerificar);
    }





    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Verificar(View v) throws ParseException {

        int diaNasc = Integer.parseInt(dtDiaNasc.getText().toString());
        int mesNasc = Integer.parseInt(dtMesNasc.getText().toString());
        int anoNasc = Integer.parseInt(dtAnoNasc.getText().toString());
        double rendaMensal = Float.parseFloat(tvRendaMensal.getText().toString());

        String testeIdade = "";
        String testeRenda = "";

        //calcula valor a receber
        double recebimento = (rendaMensal *0.70);
        if (recebimento > 475 ) recebimento = 475;
        //verifica a renda mensal
        if (rendaMensal > 5000)
            testeRenda = "Negado";
        else testeRenda = "Autorizado";

        //verifica se tem 18 anos
        Calendar dataNasc=Calendar.getInstance();
        dataNasc.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(diaNasc+"/"+mesNasc+"/"+anoNasc));
        dataNasc.add(Calendar.YEAR, 18);
        Calendar dataAtual=Calendar.getInstance();
        if(dataNasc.before(dataAtual)){ testeIdade = "Autorizado"; }
        else{ testeIdade = "Negado"; }

        //data pagamento

        LocalDate d1 = LocalDate.of(2020, mesNasc, diaNasc);
        LocalDate d2 = d1.plusDays(20);

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dataPag = dateFormat.format(dateFormat);




        //chama prox tela e puxa os dados
        Intent intent = new Intent(MainActivity.this, segundatela.class);
        Bundle b = new Bundle();
        b.putDouble("recebimento", recebimento);
        b.putString("testeIdade", testeIdade);
        b.putString("testeRenda", testeRenda);
        b.putString("dataPagamento", dataPag);
        intent.putExtras(b);
        startActivity(intent);
        finish();


    }





}








