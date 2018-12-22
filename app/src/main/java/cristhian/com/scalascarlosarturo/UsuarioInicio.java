package cristhian.com.scalascarlosarturo;

public class UsuarioInicio {

    private boolean success;
    private int id;
    private String documento;
    private String nombres,apellidos;
    private String direcccion;
    private String telefono;
    private String FECHA_REGISTRO;

    public UsuarioInicio() {
    }

    public UsuarioInicio(boolean success, int id, String documento, String nombres,String apellidos, String DIRECCION, String TELEFONO, String FECHA_REGISTRO) {
        this.success = success;
        this.id = id;
        this.documento = documento;
        this.nombres = nombres;
        this.apellidos=apellidos;
        this.direcccion = DIRECCION;
        this.telefono = TELEFONO;
        this.FECHA_REGISTRO = FECHA_REGISTRO;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDocumento() {
        return documento;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDirecccion() {
        return direcccion;
    }

    public void setDirecccion(String DIRECCION) {
        this.direcccion = DIRECCION;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String TELEFONO) {
        this.telefono = TELEFONO;
    }

    public String getFECHA_REGISTRO() {
        return FECHA_REGISTRO;
    }

    public void setFECHA_REGISTRO(String FECHA_REGISTRO) {
        this.FECHA_REGISTRO = FECHA_REGISTRO;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "success=" + success +
                ", id=" + id +
                ", documento='" + documento + '\'' +
                ", nombre='" + nombres + '\'' +
                '}';
    }
}
