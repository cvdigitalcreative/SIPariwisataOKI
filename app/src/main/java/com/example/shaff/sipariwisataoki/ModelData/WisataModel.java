package com.example.shaff.sipariwisataoki.ModelData;

public class WisataModel {
    private String nama_wisata;
    private String sejarah_wisata;
    private double longitude;
    private double latitude;
    private int foto;

    public WisataModel() {
    }

    public String getNama_wisata() {
        return nama_wisata;
    }

    public void setNama_wisata(String nama_wisata) {
        this.nama_wisata = nama_wisata;
    }

    public String getSejarah_wisata() {
        return sejarah_wisata;
    }

    public void setSejarah_wisata(String sejarah_wisata) {
        this.sejarah_wisata = sejarah_wisata;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
