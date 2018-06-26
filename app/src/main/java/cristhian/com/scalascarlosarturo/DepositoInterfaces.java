package cristhian.com.scalascarlosarturo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface DepositoInterfaces {

    @FormUrlEncoded
    @POST("Deposito.php")
    Call<List<Productos>> getDocumento(@Field("DOCUMENTO") String usuario);
}
