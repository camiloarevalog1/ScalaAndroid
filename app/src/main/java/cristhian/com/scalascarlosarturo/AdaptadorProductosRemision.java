package cristhian.com.scalascarlosarturo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class AdaptadorProductosRemision extends RecyclerView.Adapter<AdaptadorProductosRemision.ViewHolderProductos> {

    List<ProductosRemision> listaProductos;


    public AdaptadorProductosRemision(List<ProductosRemision> listaProductos) {
        this.listaProductos = listaProductos;
    }

    @NonNull
    @Override
    public ViewHolderProductos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list4,null,false);
        return new ViewHolderProductos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderProductos holder, int position) {
        holder.etNombre.setText(listaProductos.get(position).getNombre());
        holder.etComentario.setText(listaProductos.get(position).getComentario());
        holder.etPagar.setText(listaProductos.get(position).getTotal_a_pagar());
        holder.etEstado.setText(listaProductos.get(position).getEstado());
    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }

    public class ViewHolderProductos extends RecyclerView.ViewHolder {


        TextView etNombre,etComentario,etPagar,etEstado;


        public ViewHolderProductos(View itemView) {
            super(itemView);
                etNombre=(TextView)itemView.findViewById(R.id.idNombre);
            etComentario=(TextView)itemView.findViewById(R.id.idComentario);
            etPagar=(TextView)itemView.findViewById(R.id.idTotalpagar);
            etEstado=itemView.findViewById(R.id.idEstado);

        }
    }
}
