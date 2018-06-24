package cristhian.com.scalascarlosarturo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;

import retrofit2.Call;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private LoginInterfaces loginInterfaces;

    private EditText editTextDocumento;
    private Button buttonIngresar;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        prefs = getSharedPreferences("Preferences", Context.MODE_PRIVATE);
        bindUI();
    }

    private void bindUI() {
        loginInterfaces = Connection.getApiClient().create(LoginInterfaces.class);
        editTextDocumento = findViewById(R.id.editTextDocumento);
        buttonIngresar = findViewById(R.id.buttonIngresar);
        buttonIngresar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == buttonIngresar) {
            String documento = editTextDocumento.getText().toString().trim();
            if (documento.isEmpty()) {
                editTextDocumento.setError("Ingrese Documento");
                editTextDocumento.requestFocus();
            } else {
                new enterMain().execute(documento);
            }

        }
    }

    private void saveOnPreferences(Usuario usuario) {
        try {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("success", usuario.isSuccess());
            editor.putInt("id", usuario.getId());
            editor.putString("documento", usuario.getDocumento());
            editor.putString("nombre", usuario.getNombres());

            // no olviodes completas aqui los demas datos
            editor.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private String goToMainActivity(String documento) {
        String result;
        Call<Usuario> userCall = loginInterfaces.getLogin(documento);

        try {
            Usuario user = userCall.execute().body();
            if (user != null) {
                if (user.isSuccess()) {
                    saveOnPreferences(user);
                    result = "Go";
                } else {
                    result = "pass";
                }
            } else {
                result = "user";
            }
        } catch (IOException e) {
            result = "Verificar si cuenta con Internet";
        }

        return result;

    }

    @SuppressLint("StaticFieldLeak")
    private class enterMain extends AsyncTask<String, Void, String> {

        private AlertDialog.Builder builder, builder2;
        private AlertDialog dialog, dialog2;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            builder = new AlertDialog.Builder(new ContextThemeWrapper(LoginActivity.this, R.style.AppTheme));
            @SuppressLint("InflateParams") View view = LayoutInflater.from(LoginActivity.this).inflate(R.layout.dialog_login, null);
            builder.setView(view);
            dialog = builder.create();
            dialog.setCanceledOnTouchOutside(false);
            dialog.setCancelable(false);
            dialog.show();
        }

        @Override
        protected String doInBackground(String... string) {
            String result = null;
            String documento = string[0];
            try {
                result = goToMainActivity(documento);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            publishProgress();
            return result;
        }

        @SuppressLint("RestrictedApi")
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (dialog.isShowing()) {
                dialog.dismiss();
            }

            switch (s) {
//                case "pass":
//                    EditTextPassError.setError("Contraseña Incorrecta");
//                    break;
//                case "user":
//                    EditTextUserError.setError("Usuario no existe.");
//                    break;
                case "Go":
                    Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    break;
                case "Verificar si cuenta con Internet":
                    builder2 = new AlertDialog.Builder(new ContextThemeWrapper(LoginActivity.this, R.style.AppTheme));
                    builder2.setTitle("Error");
                    builder2.setMessage(s);
                    builder2.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    dialog2 = builder2.create();
                    dialog2.setCanceledOnTouchOutside(false);
                    dialog2.show();
                    break;
            }
        }
    }
}
