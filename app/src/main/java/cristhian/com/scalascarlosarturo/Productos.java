package cristhian.com.scalascarlosarturo;

public class Productos {

    private String nombre;
    private String comentario;
    private String total_a_pagar;
    private String fecha_registro;
    private String fecha_entrega;
    private String cantidad;

    public Productos(String nombre, String comentario, String total_a_pagar,String fecha_registro,String fecha_entrega,String cantidad) {
        this.nombre = nombre;
        this.comentario = comentario;
        this.total_a_pagar = total_a_pagar;
        this.fecha_registro=fecha_registro;
        this.fecha_entrega=fecha_entrega;
        this.cantidad=cantidad;
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

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(String fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Productos{" +
                "nombre='" + nombre + '\'' +
                ", comentario='" + comentario + '\'' +
                ", total_a_pagar='" + total_a_pagar + '\'' +
                ", fecha_registro='" + fecha_registro + '\'' +
                ", fecha_entrega='" + fecha_entrega + '\'' +
                ", cantidad='" + cantidad + '\'' +
                '}';
    }
}
