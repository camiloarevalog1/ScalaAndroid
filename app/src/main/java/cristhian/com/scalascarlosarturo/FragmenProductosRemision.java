package cristhian.com.scalascarlosarturo;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
 * {@link FragmenProductosRemision.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmenProductosRemision#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmenProductosRemision extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView recyclerViewPersonajes;
    List<ProductosRemision> productos;
    private SharedPreferences prefs;
    ProductoRemisionInterfaces productoRemisionInterfaces;

    private OnFragmentInteractionListener mListener;

    public FragmenProductosRemision() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmenProductosRemision.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmenProductosRemision newInstance(String param1, String param2) {
        FragmenProductosRemision fragment = new FragmenProductosRemision();
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
        View view = inflater.inflate(R.layout.fragment_fragmen_productos_remision, container, false);

        productoRemisionInterfaces = Connection.getApiClient().create(ProductoRemisionInterfaces.class);
        productos = new ArrayList<>();
        recyclerViewPersonajes = view.findViewById(R.id.recyclerRePro);
        recyclerViewPersonajes.setLayoutManager(new LinearLayoutManager(getContext()));
        Bundle b=getArguments();
        Remision p= (Remision) b.getSerializable("objeto");
        String documento = prefs.getString("documento", "");
        llenarProductos(p.getId()+"");
        return view;
    }

    private void llenarProductos(String documento) {
        Call<List<ProductosRemision>> userCall = productoRemisionInterfaces.getDocumento(documento);


        userCall.enqueue(new Callback<List<ProductosRemision>>() {
            @Override
            public void onResponse(Call<List<ProductosRemision>> call, Response<List<ProductosRemision>> response) {
                List<ProductosRemision> productos = response.body();
                AdaptadorProductosRemision adapter = new AdaptadorProductosRemision(productos);
                recyclerViewPersonajes.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<ProductosRemision>> call, Throwable t) {

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
