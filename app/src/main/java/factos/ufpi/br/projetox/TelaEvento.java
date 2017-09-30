package factos.ufpi.br.projetox;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.Objects;

import factos.ufpi.br.projetox.model.Evento;


public class TelaEvento extends AppCompatActivity {

    private TextView data;
    private TextView descricao;
    private TextView valor;
    private TextView local;
    private TextView user;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_evento);

        Intent it = getIntent();
        Evento evento = (Evento) it.getSerializableExtra("evento");

        data = (TextView) findViewById(R.id.txtDataEvent);
        descricao = (TextView) findViewById(R.id.txtDescEvent);
        valor = (TextView) findViewById(R.id.txtValorEvent);
        local = (TextView) findViewById(R.id.txtLocalEvent);
        user = (TextView) findViewById(R.id.txtUserEvent);
        toolbar = (Toolbar) findViewById(R.id.toolbar);


        toolbar.setTitle(evento.getNome());

        data.setText(evento.getData());
        descricao.setText("Falta colocar descrição no evento!!");
        valor.setText("0800");
        local.setText(evento.getLocal());
        user.setText("Lucas China");


        if(Objects.equals(evento.getTipo(), "academico")) {

            toolbar.setLogo(R.drawable.ic_academico_tab);
        }
        else{
            toolbar.setLogo(R.drawable.ic_cultural_tab);
        }
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(getApplicationContext(), TelaHome.class);
                finish();
                startActivity(home);
            }
        });
    }



}
