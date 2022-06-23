package com.example.tokosahabat.model;



public class FormPembayaranModel {

    String rgks, tota, bila, rptota, rpbila;

    public FormPembayaranModel(String rgks, String tota, String bila, String rptota, String rpbila) {
        this.rgks = rgks;
        this.tota = tota;
        this.bila = bila;
        this.rptota = rptota;
        this.rpbila = rpbila;
    }

    public String getRgks() {
        return rgks;
    }

    public void setRgks(String rgks) {
        this.rgks = rgks;
    }

    public String getTota() {
        return tota;
    }

    public void setTota(String tota) {
        this.tota = tota;
    }

    public String getBila() {
        return bila;
    }

    public void setBila(String bila) {
        this.bila = bila;
    }

    public String getRptota() {
        return rptota;
    }

    public void setRptota(String rptota) {
        this.rptota = rptota;
    }

    public String getRpbila() {
        return rpbila;
    }

    public void setRpbila(String rpbila) {
        this.rpbila = rpbila;
    }
}
