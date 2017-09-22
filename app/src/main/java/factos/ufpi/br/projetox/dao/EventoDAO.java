package factos.ufpi.br.projetox.dao;

import java.util.ArrayList;
import java.util.List;

import factos.ufpi.br.projetox.R;
import factos.ufpi.br.projetox.model.Evento;

/**
 * Created by lucas_brito on 14/09/17.
 */

public class EventoDAO {

    private String[] nome = new String[]{"Encontro das Emas","ERIPI","Vinhada da Filosofia"};
    private String[] local = new String[]{"Parque das Emas - UFPI", "Bloco de Computação - DC - UFPI", "Praçinha da filosofia"};
    private String[] data = new String[]{"21/10/17 17:30", "24/10/17 10:00", "23/10/17 21:17"};
    private String[] tipo = new String[]{"cultural","academico","cultural"};
    private int[] fotos = new int[]{R.drawable.evento, R.drawable.eripi, R.drawable.evento};
    List<Evento> listAux = new ArrayList<>();


    public List<Evento> getSetEventos(int quant){

        for(int i=0; i < quant; i++){
            Evento e = new Evento(nome[i % nome.length],local[i % local.length],data[i % data.length],tipo[i % tipo.length], fotos[i % fotos.length]);
            listAux.add(e);
        }

        return (listAux);
    }

}
