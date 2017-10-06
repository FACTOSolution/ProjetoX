package factos.ufpi.br.projetox.api;


import java.util.List;
import retrofit2.Call;

import factos.ufpi.br.projetox.model.Evento;
import retrofit2.http.GET;

/**
 * Created by fmendes on 28/09/17.
 */

public interface EventService {

    @GET("event?page=1")
    Call<List<Evento>> listEvent();
}
