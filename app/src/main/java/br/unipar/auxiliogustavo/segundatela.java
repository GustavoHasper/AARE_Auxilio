package br.unipar.auxiliogustavo;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class segundatela extends AppCompatActivity {


    //declara objeto da tela
    TextView tvLPA;
    TextView tvPL;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundatela);

        //associando objetos
        TextView tvSaldo = (TextView) findViewById(R.id.tvSaldo);
        TextView tvDataPag = (TextView) findViewById(R.id.tvDataPag);
        TextView tvIdade = (TextView) findViewById(R.id.tvIdade);
        TextView tvRenda = (TextView) findViewById(R.id.tvRenda);


        Bundle b = getIntent().getExtras();
        assert b != null;
        double recebimento = b.getDouble("recebimento");
        String testeIdade = b.getString("testeIdade");
        String testeRenda = b.getString("testeRenda");
        String dataPagamento = b.getString("dataPag");

        String tSaldo = ("Você tem um total para receber de:" +recebimento);
        String tDataPag = "A sua data de pagamento é:" + dataPagamento;
        String tIdade = "A sua idade foi" +testeIdade;
        String tRenda = "A sua renda foi" +testeRenda;


        tvSaldo.setText(tSaldo);
        tvDataPag.setText(tDataPag);
        tvIdade.setText(tIdade);
        tvRenda.setText(tRenda);

    }


}




