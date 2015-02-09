package com.com.entidades.rfs;

/**
 * Created by Ronald on 8/2/2015.
 */
public class clDias {

    public clDias() {
    }

    public clDias(int nreg, int consumo, String fecha) {
        this.nreg = nreg;
        this.consumo = consumo;
        this.fecha = fecha;
    }

    private int nreg;
    private int consumo;
    private String fecha;

    public int getNreg() {
        return nreg;
    }

    public void setNreg(int nreg) {
        this.nreg = nreg;
    }

    public int getConsumo() {
        return consumo;
    }

    public void setConsumo(int consumo) {
        this.consumo = consumo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }


}
