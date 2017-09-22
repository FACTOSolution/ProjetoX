package factos.ufpi.br.projetox.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import factos.ufpi.br.projetox.R;
import factos.ufpi.br.projetox.model.Evento;

/**
 * Created by lucas_brito on 14/09/17.
 */

public class EventoAdapter extends BaseAdapter{

    private List<Evento> eventos;
    private Activity act;

    public EventoAdapter(Activity act, List<Evento> eventos){
        this.act = act;
        this.eventos = eventos;
    }

    @Override
    public int getCount() {
        return eventos.size();
    }

    @Override
    public Object getItem(int i) {
        return eventos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View v = act.getLayoutInflater().inflate(R.layout.evento_card, viewGroup, false);
        Evento evento = eventos.get(i);

        TextView nome = (TextView) v.findViewById(R.id.tv_nome);
        TextView local = (TextView) v.findViewById(R.id.tv_local);
        TextView data = (TextView) v.findViewById(R.id.tv_data);
        ImageView foto = (ImageView) v.findViewById(R.id.iv_foto);

        nome.setText(evento.getNome());
        local.setText(evento.getLocal());
        data.setText(evento.getData());
        foto.setImageResource(R.drawable.evento);

        return v;
    }
}




