package factos.ufpi.br.projetox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import factos.ufpi.br.projetox.model.Evento;

public class TelaEvento extends AppCompatActivity {

    private TextView data;
    private TextView descricao;
    private TextView valor;
    private TextView local;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_evento);

        Intent it = getIntent();
        Evento evento = (Evento) it.getSerializableExtra("evento");

        data = (TextView) findViewById(R.id.textData);
        descricao = (TextView) findViewById(R.id.textDesc);
        valor = (TextView) findViewById(R.id.textValor);
        local = (TextView) findViewById(R.id.textLocal);

        data.setText(evento.getData());
        descricao.setText("Falta colocar descrição no evento!!");
        valor.setText("0800");
        local.setText(evento.getLocal());

    }
}
