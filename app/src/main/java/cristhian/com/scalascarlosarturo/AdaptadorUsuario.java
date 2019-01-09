package cristhian.com.scalascarlosarturo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class AdaptadorUsuario extends RecyclerView.Adapter<AdaptadorUsuario.ViewHolderProductos> {

    List<UsuarioInicio> listaUsuario;


    public AdaptadorUsuario(List<UsuarioInicio> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    @NonNull
    @Override
    public ViewHolderProductos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list5,null,false);
        return new ViewHolderProductos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderProductos holder, int position) {
        holder.etNombre.setText(listaUsuario.get(position).getNombres()+" "+listaUsuario.get(position).getApellidos());
        holder.etDireccion.setText(listaUsuario.get(position).getDirecccion());
        holder.etTelefono.setText(listaUsuario.get(position).getTelefono());
        holder.etDocumento.setText(listaUsuario.get(position).getDocumento());
        Log.e("",listaUsuario.get(position).getTelefono()+"Telefono");
        Log.e("",listaUsuario.get(position).getDocumento()+"Documento");


    }

    @Override
    public int getItemCount() {
        return listaUsuario.size();
    }

    public class ViewHolderProductos extends RecyclerView.ViewHolder {


        TextView etNombre,etDireccion,etTelefono,etDocumento;


        public ViewHolderProductos(View itemView) {
            super(itemView);
                etNombre=(TextView)itemView.findViewById(R.id.idNombre);
            etDireccion=(TextView)itemView.findViewById(R.id.idComentario);
            etDocumento=(TextView)itemView.findViewById(R.id.idEstado);
            etTelefono=(TextView)itemView.findViewById(R.id.idTotalpagar);




        }
    }
}
