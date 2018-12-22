package cristhian.com.scalascarlosarturo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UsuarioInterfaces {

    @FormUrlEncoded
    @POST("usuario.php")
    Call<List<UsuarioInicio>> getDocumento(@Field("DOCUMENTO") String usuario);
}
