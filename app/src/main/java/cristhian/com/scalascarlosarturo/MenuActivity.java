package cristhian.com.scalascarlosarturo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MenuActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, FragmentDeposito.OnFragmentInteractionListener,
        FragmentEntregado.OnFragmentInteractionListener,FragmentProceso.OnFragmentInteractionListener,
        fragment_remision.OnFragmentInteractionListener,FragmentSaldo.OnFragmentInteractionListener,IComunicaFragments,
            FragmenProductosRemision.OnFragmentInteractionListener{

    private SharedPreferences prefs;
    TokenInterfaces tokenInterfaces;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        prefs = getSharedPreferences("Preferences", Context.MODE_PRIVATE);
        tokenInterfaces=Connection.getApiClient().create(TokenInterfaces.class);

        existsUser(prefs);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void existsUser(SharedPreferences prefs) {
        if (prefs.getString("documento", "").isEmpty() || prefs.getString("documento", "").length() == 0) {
            Intent intent = new Intent(this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
            case R.id.action_logOut:
                String documento = prefs.getString("documento", "");
                Call<String > stringCall = tokenInterfaces.InsertToken(documento,"0"+"");

               stringCall.enqueue(new Callback<String>() {
                   @Override
                   public void onResponse(Call<String> call, Response<String> response) {
                       response.body();
                   }

                   @Override
                   public void onFailure(Call<String> call, Throwable t) {

                   }
               });
                removeSharedPreferences();
                logOut();
                System.exit(0);
                return true;
        }
        return super.onOptionsItemSelected(item);


    }

    private void removeSharedPreferences() {
        prefs.edit().clear().apply();
    }

    private void logOut() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment fragment = null;
        boolean FragmentSeleccionado = false;


        if (id == R.id.nav_camera) {
            fragment = new FragmentEntregado();
            FragmentSeleccionado = true;

        } else if (id == R.id.nav_gallery) {
            fragment= new FragmentProceso();
            FragmentSeleccionado=true;
        } else if (id == R.id.nav_slideshow) {
            fragment=new FragmentDeposito();
            FragmentSeleccionado=true;
        } else if (id == R.id.nav_share) {
            fragment=new fragment_remision();
            FragmentSeleccionado=true;
        } else if (id == R.id.nav_send) {
            fragment = new FragmentSaldo();
            FragmentSeleccionado = true;
        }

        if (FragmentSeleccionado) {
            getSupportFragmentManager().beginTransaction().replace(R.id.idMenu, fragment).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    FragmenProductosRemision fragment_productosRemision;

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void enviarRemision(Remision remision) {
    fragment_productosRemision=new FragmenProductosRemision();
    Bundle bundleEnvio=new Bundle();
    bundleEnvio.putSerializable("objeto",remision);
    fragment_productosRemision.setArguments(bundleEnvio);


    getSupportFragmentManager().beginTransaction().replace(R.id.idMenu,fragment_productosRemision).addToBackStack(null).commit();
    }
}
