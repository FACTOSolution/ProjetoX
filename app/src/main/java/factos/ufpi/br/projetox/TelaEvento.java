package factos.ufpi.br.projetox;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Objects;

import factos.ufpi.br.projetox.extras.CustomImageView;
import factos.ufpi.br.projetox.model.Evento;


public class TelaEvento extends AppCompatActivity {

    private TextView data;
    private TextView descricao;
    private TextView valor;
    private TextView local;
    private TextView user;
    private Toolbar toolbar;
    private ImageView imagem;

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
        imagem = (ImageView) findViewById(R.id.img_event);


        toolbar.setTitle(evento.getName());

        data.setText(evento.getDate());
        descricao.setText(evento.getDescription());
        valor.setText(evento.getValue());
        local.setText(evento.getAddress());
        Picasso.with(this).load(evento.getImages().get(0)).resize(900, 500).into(imagem);



        if(evento.getType().equals("Academic")) {

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
