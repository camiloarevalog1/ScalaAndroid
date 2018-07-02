package cristhian.com.scalascarlosarturo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class AdaptadorRemision extends RecyclerView.Adapter<AdaptadorRemision.ViewHolderProductos> {

    List<Remision> listaRemision;


    public AdaptadorRemision(List<Remision> listaRemision) {
        this.listaRemision = listaRemision;
    }

    @NonNull
    @Override
    public ViewHolderProductos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list2,null,false);
        return new ViewHolderProductos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderProductos holder, int position) {
        holder.etNombre.setText(listaRemision.get(position).getId()+"");
        holder.etComentario.setText(listaRemision.get(position).getTotal_a_pagar());
        holder.etPagar.setText(listaRemision.get(position).getTotal_pagado());
    }

    @Override
    public int getItemCount() {
        return listaRemision.size();
    }

    public class ViewHolderProductos extends RecyclerView.ViewHolder {


        TextView etNombre,etComentario,etPagar;


        public ViewHolderProductos(View itemView) {
            super(itemView);
                etNombre=(TextView)itemView.findViewById(R.id.idNombre);
            etComentario=(TextView)itemView.findViewById(R.id.idComentario);
            etPagar=(TextView)itemView.findViewById(R.id.idTotalpagar);

        }
    }
}
