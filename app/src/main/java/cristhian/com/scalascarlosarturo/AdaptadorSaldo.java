package cristhian.com.scalascarlosarturo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class AdaptadorSaldo extends RecyclerView.Adapter<AdaptadorSaldo.ViewHolderProductos> {

    List<Saldo> listaSaldo;


    public AdaptadorSaldo(List<Saldo> listaSaldo) {
        this.listaSaldo = listaSaldo;
    }

    @NonNull
    @Override
    public ViewHolderProductos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list3,null,false);
        return new ViewHolderProductos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderProductos holder, int position) {
        holder.etNombre.setText(listaSaldo.get(position).getSaldo()+"");

    }

    @Override
    public int getItemCount() {
        return listaSaldo.size();
    }

    public class ViewHolderProductos extends RecyclerView.ViewHolder {


        TextView etNombre,etComentario,etPagar;


        public ViewHolderProductos(View itemView) {
            super(itemView);
                etNombre=(TextView)itemView.findViewById(R.id.idNombre);


        }
    }
}
