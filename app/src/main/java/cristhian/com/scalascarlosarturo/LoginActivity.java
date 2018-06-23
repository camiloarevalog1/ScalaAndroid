package cristhian.com.scalascarlosarturo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import retrofit2.Call;


public class LoginActivity extends AppCompatActivity {

    private LoginInterfaces loginInterfaces;
    private Call<Usuario> usuarioCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginInterfaces = Connection.getApiClient().create(LoginInterfaces.class);

// delcaras tus variables
//        EditText editText = findViewById(R.id.asd);
//        Button data =

        //despues usas el retrofit
        // avisame cuando estas en la parte de retrofit ,, dale amigo ,listo me avisas si
        // mandame tu correo para pasarte el login

        // entonces arreglare todo con los adapter y todo , y cuando sea la parte
        //del retrofit te aviso? si?
        // valeee me avisas
        // mira el correo   cristianarevalogutierrez@gmail.com
        // listo me avisas
        //dale
    }
}
