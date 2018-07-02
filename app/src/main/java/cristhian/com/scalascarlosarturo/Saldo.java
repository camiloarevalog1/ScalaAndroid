package cristhian.com.scalascarlosarturo;

public class Saldo {

    private boolean success;
    private String saldo;

    public Saldo() {
    }

    public Saldo(boolean success, String saldo) {
        this.success = success;
        this.saldo = saldo;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Saldo{" +
                "success=" + success +
                ", saldo='" + saldo + '\'' +
                '}';
    }
}
