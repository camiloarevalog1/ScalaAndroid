package cristhian.com.scalascarlosarturo;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface EliminarTokenInterfaces {

    @FormUrlEncoded
    @POST("token.php")
    Call<String> InsertToken(@Field("DOCUMENTO") String usuario, @Field("token") String token);
}
