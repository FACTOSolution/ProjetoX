package factos.ufpi.br.projetox.api;

/**
 * Created by fmendes on 28/09/17.
 */


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by fmendes on 28/09/17.
 */

public class ConsumirJson {

    private static final String BASE_URL = "https://still-reaches-96571.herokuapp.com/";

    public ConsumirJson(){

    }

    public EventService getService() {

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(
                        new Interceptor() {
                            @Override
                            public Response intercept(Chain chain) throws IOException {
                                Request request = chain.request().newBuilder()
                                        .addHeader("Accept","Application/JSON").build();
                                return chain.proceed(request);
                            }
                        }).build();

        // Retrofit Reference
        Retrofit retrofitRef = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //MyEndPoint
        EventService service = retrofitRef.create(EventService.class);

        return service;
    }


}
