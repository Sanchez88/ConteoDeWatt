package entidades;

/**
 * Created by Ronald on 04/02/15.
 */
public class clLista {
    public clLista(int cantidad, String mes) {
        this.cantidad = cantidad;
        this.Mes = mes;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getMes() {
        return Mes;
    }

    public void setMes(String mes) {
        Mes = mes;
    }

    public clLista(){}

    private int cantidad;
    private String Mes;
}
