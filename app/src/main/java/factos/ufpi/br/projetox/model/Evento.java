package factos.ufpi.br.projetox.model;

import java.io.Serializable;

/**
 * Created by lucas_brito on 14/09/17.
 */

public class Evento implements Serializable {

    private int foto;
    private String nome;
    private String local;
    private String date;
    private String tipo;

    public Evento(){}

    public Evento( String nome, String local, String data, String tipo, int foto) {
        this.foto = foto;
        this.nome = nome;
        this.local = local;
        this.date = data;
        this.tipo = tipo;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getData() {
        return date;
    }

    public void setData(String data) {
        this.date = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
