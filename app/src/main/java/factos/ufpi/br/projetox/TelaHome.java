package factos.ufpi.br.projetox;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;

import factos.ufpi.br.projetox.adapters.EventoAdapter;
import factos.ufpi.br.projetox.dao.EventoDAO;
import factos.ufpi.br.projetox.model.Evento;

public class TelaHome extends AppCompatActivity implements AdapterView.OnItemClickListener {


    private LinearLayoutManager lLayout;
    private Toolbar myToolbar;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_home);

        myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);


        List<Evento> listaEventos = new EventoDAO().getSetEventos(3);
        listView = (ListView) findViewById(R.id.listaEventos);

        EventoAdapter eventoAdapter = new EventoAdapter(this,listaEventos);
        listView.setAdapter(eventoAdapter);
        listView.setOnItemClickListener(TelaHome.this);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Intent intent = new Intent(TelaHome.this, TelaEvento.class);
        intent.putExtra("evento", (Serializable) listView.getItemAtPosition(i));
        startActivity(intent);

    }
}
