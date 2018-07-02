package cristhian.com.scalascarlosarturo;

public class Remision {
    private boolean success;
    private int id;
    private String total_a_pagar;
    private String total_pagado;

    public Remision(boolean success, int id, String total_a_pagar, String total_pagado) {
        this.success = success;
        this.id = id;
        this.total_a_pagar = total_a_pagar;
        this.total_pagado = total_pagado;
    }

    public Remision() {
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

    public String getTotal_a_pagar() {
        return total_a_pagar;
    }

    public void setTotal_a_pagar(String total_a_pagar) {
        this.total_a_pagar = total_a_pagar;
    }

    public String getTotal_pagado() {
        return total_pagado;
    }

    public void setTotal_pagado(String total_pagado) {
        this.total_pagado = total_pagado;
    }

    @Override
    public String toString() {
        return "Remision{" +
                "success=" + success +
                ", id=" + id +
                ", total_a_pagar='" + total_a_pagar + '\'' +
                ", total_pagado='" + total_pagado + '\'' +
                '}';
    }
}
