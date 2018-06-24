package cristhian.com.scalascarlosarturo;

public class Usuario {

    private boolean success;
    private int id;
    private String documento;
    private String nombres;
    private String DIRECCION;
    private String TELEFONO;
    private String FECHA_REGISTRO;

    public Usuario() {
    }

    public Usuario(boolean success, int id, String documento, String nombres, String DIRECCION, String TELEFONO, String FECHA_REGISTRO) {
        this.success = success;
        this.id = id;
        this.documento = documento;
        this.nombres = nombres;
        this.DIRECCION = DIRECCION;
        this.TELEFONO = TELEFONO;
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

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDIRECCION() {
        return DIRECCION;
    }

    public void setDIRECCION(String DIRECCION) {
        this.DIRECCION = DIRECCION;
    }

    public String getTELEFONO() {
        return TELEFONO;
    }

    public void setTELEFONO(String TELEFONO) {
        this.TELEFONO = TELEFONO;
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
