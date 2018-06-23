package cristhian.com.scalascarlosarturo;

public class Productos {

    private String nombre;
    private String comentario;
    private String total_a_pagar;

    public Productos(String nombre, String comentario, String total_a_pagar) {
        this.nombre = nombre;
        this.comentario = comentario;
        this.total_a_pagar = total_a_pagar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getTotal_a_pagar() {
        return total_a_pagar;
    }

    public void setTotal_a_pagar(String total_a_pagar) {
        this.total_a_pagar = total_a_pagar;
    }

    @Override
    public String toString() {
        return "Productos{" +
                "nombre='" + nombre + '\'' +
                ", comentario='" + comentario + '\'' +
                ", total_a_pagar='" + total_a_pagar + '\'' +
                '}';
    }
}
