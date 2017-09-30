package factos.ufpi.br.projetox;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.Serializable;
import java.util.List;

import factos.ufpi.br.projetox.adapters.EventoAdapter;
import factos.ufpi.br.projetox.dao.EventoDAO;
import factos.ufpi.br.projetox.model.Evento;

public class TelaHome extends AppCompatActivity implements AdapterView.OnItemClickListener, SearchView.OnQueryTextListener {


    private Toolbar myToolbar;
    private BottomNavigationView myBottomNav;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_home);

        myToolbar = (Toolbar) findViewById(R.id.toolbar);
        myToolbar.setTitle("ProjetoX");
        setSupportActionBar(myToolbar);

        myBottomNav = (BottomNavigationView) findViewById(R.id.bottomNavViewBar);
        myBottomNav.setOnNavigationItemSelectedListener( new BottomNavigationView.OnNavigationItemSelectedListener(){

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.ic_home:
                        break;
                    case R.id.ic_user:
                        // Quando o usuario clicar nesse botão, temos que testar se ele já ta logado primeiro.
                        Intent it = new Intent(TelaHome.this,TelaLongin.class);
                        startActivity(it);
                        break;
                    case R.id.ic_Top10:
                        break;
                }
                return true;
            }
        });



        List<Evento> listaEventos = new EventoDAO().getSetEventos(3);
        listView = (ListView) findViewById(R.id.listaEventos);

        EventoAdapter eventoAdapter = new EventoAdapter(this,listaEventos);
        listView.setAdapter(eventoAdapter);
        listView.setOnItemClickListener(TelaHome.this);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_procurar, menu);

        MenuItem procurarItem = menu.findItem(R.id.procurar);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(procurarItem);
        searchView.setOnQueryTextListener(this);
        return true;
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Intent intent = new Intent(TelaHome.this, TelaEvento.class);
        intent.putExtra("evento", (Serializable) listView.getItemAtPosition(i));
        startActivity(intent);

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}
