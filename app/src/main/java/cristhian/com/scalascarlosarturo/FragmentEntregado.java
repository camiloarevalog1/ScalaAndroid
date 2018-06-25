package cristhian.com.scalascarlosarturo;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * <p>
 * to handle interaction events.
 * <p>
 * create an instance of this fragment.
 */
public class FragmentEntregado extends Fragment {

    RecyclerView recyclerViewPersonajes;
    List<Productos> productos;
    private SharedPreferences prefs;
    EntregadoInterfaces entregadoInterfaces;

    private OnFragmentInteractionListener myListener;

    public FragmentEntregado() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefs = this.getContext().getSharedPreferences("Preferences", Context.MODE_PRIVATE);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_entregado, container, false);

        entregadoInterfaces = Connection.getApiClient().create(EntregadoInterfaces.class);
        productos = new ArrayList<>();
        recyclerViewPersonajes = view.findViewById(R.id.recycler);
        recyclerViewPersonajes.setLayoutManager(new LinearLayoutManager(getContext()));
        String documento = prefs.getString("documento", "");
        llenarProductos(documento);
        return view;
    }

    private void llenarProductos(String documento) {
        Call<List<Productos>> userCall = entregadoInterfaces.getDocumento(documento);


        userCall.enqueue(new Callback<List<Productos>>() {
            @Override
            public void onResponse(Call<List<Productos>> call, Response<List<Productos>> response) {
                List<Productos> productos = response.body();
                AdaptadorProductos adapter = new AdaptadorProductos(productos);
                recyclerViewPersonajes.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Productos>> call, Throwable t) {

            }
        });
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


}
