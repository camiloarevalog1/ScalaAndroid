package cristhian.com.scalascarlosarturo;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginInterfaces {

    @FormUrlEncoded
    @POST("Entregado.php")
    Call<Usuario> getLogin(@Field("usuario") String usuario);
}
