package cristhian.com.scalascarlosarturo;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentInicio.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentInicio#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentInicio extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    RecyclerView recyclerViewPersonajes;
    List<Productos> productos;
    private SharedPreferences prefs;
    UsuarioInterfaces usuarioInterfaces;
    ProcesoInterfaces procesoInterfaces;
    private OnFragmentInteractionListener mListener;

    public FragmentInicio() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentInicio.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentInicio newInstance(String param1, String param2) {
        FragmentInicio fragment = new FragmentInicio();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        prefs = this.getContext().getSharedPreferences("Preferences", Context.MODE_PRIVATE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_inicio, container, false);

        usuarioInterfaces = Connection.getApiClient().create(UsuarioInterfaces.class);
        productos = new ArrayList<>();
        recyclerViewPersonajes = view.findViewById(R.id.recyclerUsuario);
        recyclerViewPersonajes.setLayoutManager(new LinearLayoutManager(getContext()));
        String documento = prefs.getString("documento", "");
        llenarProductos(documento);
        return view;
    }

    private void llenarProductos(String documento) {
        Call<List<UsuarioInicio>> userCall = usuarioInterfaces.getDocumento(documento);
        Log.e("111",userCall.toString());
        Log.e("111",documento);
        userCall.toString();
//        Log.e("111",usuarioInterfaces.toString());
        Log.e("111",userCall.toString());
        userCall.enqueue(new Callback<List<UsuarioInicio>>() {
            @Override
            public void onResponse(Call<List<UsuarioInicio>> call, Response<List<UsuarioInicio>> response) {
                Log.e("222","22222");
                List<UsuarioInicio> productos = response.body();//error
                //Log.e("inicio",productos.toString());
                Log.e("inicio",productos.toString());
                AdaptadorUsuario adapter = new AdaptadorUsuario(productos);
                Log.e("222",productos.toString());
                recyclerViewPersonajes.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<UsuarioInicio>> call, Throwable t) {

            }
        });
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
