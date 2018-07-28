package cristhian.com.scalascarlosarturo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorProductos extends RecyclerView.Adapter<AdaptadorProductos.ViewHolderProductos> {

    List<Productos> listaProductos;


    public AdaptadorProductos(List<Productos> listaProductos) {
        this.listaProductos = listaProductos;
    }

    @NonNull
    @Override
    public ViewHolderProductos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,null,false);
        return new ViewHolderProductos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderProductos holder, int position) {
        holder.etNombre.setText(listaProductos.get(position).getNombre());
        holder.etComentario.setText(listaProductos.get(position).getComentario());
        holder.etPagar.setText(listaProductos.get(position).getTotal_a_pagar());
        holder.etFechaRegistro.setText(listaProductos.get(position).getFecha_registro());
        holder.etFechaEntrega.setText(listaProductos.get(position).getFecha_entrega());
        holder.etCantidad.setText(listaProductos.get(position).getCantidad());
    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }

    public class ViewHolderProductos extends RecyclerView.ViewHolder {


        TextView etNombre,etComentario,etPagar,etFechaRegistro,etFechaEntrega,etCantidad;


        public ViewHolderProductos(View itemView) {
            super(itemView);
                etNombre=(TextView)itemView.findViewById(R.id.idNombre);
            etComentario=(TextView)itemView.findViewById(R.id.idComentario);
            etPagar=(TextView)itemView.findViewById(R.id.idTotalpagar);
            etFechaRegistro=itemView.findViewById(R.id.idFechaDejada);
            etFechaEntrega=itemView.findViewById(R.id.idFechaEntrega);
            etCantidad=itemView.findViewById(R.id.idCantidad);


        }
    }
}
