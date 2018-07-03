package cristhian.com.scalascarlosarturo;


import android.app.Activity;
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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link fragment_remision.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link fragment_remision#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_remision extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView recyclerViewPersonajes;
    List<Remision> productos1;
    private SharedPreferences prefs;
    RemisionInterfaces remisionInterfaces;

    Activity activity;
    IComunicaFragments iComunicaFragments;

    private OnFragmentInteractionListener mListener;

    public fragment_remision() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_remision.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_remision newInstance(String param1, String param2) {
        fragment_remision fragment = new fragment_remision();
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
        View view = inflater.inflate(R.layout.fragment_fragment_remision, container, false);

        remisionInterfaces = Connection.getApiClient().create(RemisionInterfaces.class);
        productos1 = new ArrayList<>();
        recyclerViewPersonajes = view.findViewById(R.id.recyclerRe);
        recyclerViewPersonajes.setLayoutManager(new LinearLayoutManager(getContext()));
        String documento = prefs.getString("documento", "");

        llenarProductos(documento,view);

        return view;
    }

    private void llenarProductos(String documento, final View view) {
        Call<List<Remision>> userCall = remisionInterfaces.getDocumento(documento);


        userCall.enqueue(new Callback<List<Remision>>() {
            @Override
            public void onResponse(Call<List<Remision>> call, Response<List<Remision>> response) {
                List<Remision> productos = response.body();
                final AdaptadorRemision adapter = new AdaptadorRemision(productos);
                productos1=response.body();

                Log.e("Prueba","Onclick"+productos.size());

                recyclerViewPersonajes.setAdapter(adapter);

                recyclerViewPersonajes.addOnItemTouchListener(new RecyclerTouchListener(getContext(), recyclerViewPersonajes,
                        new RecyclerTouchListener.ClickListener() {
                            @Override
                            public void onClick(View view, int position) {
                                Log.e("hola","se pudo");
                               Remision r=adapter.listaRemision.get(position);
                                Log.e("hola","remision"+r);
                                iComunicaFragments.enviarRemision(r);
                            }

                            @Override
                            public void onLongClick(View view, int position) {

                            }
                        }));



            }

            @Override
            public void onFailure(Call<List<Remision>> call, Throwable t) {

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

        if(context instanceof  Activity){
            this.activity= (Activity) context;
            iComunicaFragments= (IComunicaFragments) this.activity;
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
