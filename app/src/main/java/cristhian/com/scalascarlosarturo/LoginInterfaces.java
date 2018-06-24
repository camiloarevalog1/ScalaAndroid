package cristhian.com.scalascarlosarturo;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginInterfaces {

    @FormUrlEncoded
    @POST("login.php")
    Call<Usuario> getLogin(@Field("DOCUMENTO") String usuario);
}
