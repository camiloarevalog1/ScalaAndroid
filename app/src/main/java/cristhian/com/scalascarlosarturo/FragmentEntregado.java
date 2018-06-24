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

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentEntregado.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentEntregado#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentEntregado extends Fragment {

    RecyclerView recyclerViewPersonajes;
    ArrayList<Productos> productos;

    public FragmentEntregado() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_entregado, container, false);

        productos = new ArrayList<>();
        recyclerViewPersonajes = view.findViewById(R.id.recycler);
        recyclerViewPersonajes.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }


}
