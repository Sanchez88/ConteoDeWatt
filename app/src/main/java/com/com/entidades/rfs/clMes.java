package com.com.entidades.rfs;

/**
 * Created by Ronald on 9/2/2015.
 */
public class clMes {
    public clMes(String mes, int conteo) {
        this.mes = mes;
        this.conteo = conteo;
    }

    public clMes() {
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public int getConteo() {
        return conteo;
    }

    public void setConteo(int conteo) {
        this.conteo = conteo;
    }

    private String mes;
    private int conteo;
}
