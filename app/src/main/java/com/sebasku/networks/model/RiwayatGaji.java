package com.sebasku.networks.model;

/**
 * Created by fadil on 3/19/18.
 */

public class RiwayatGaji {
    private String nama;
    private String posisi;
    private String jumlahTask;
    private String totalGaji;
    private String sesi;

    public String getSesi() {
        return sesi;
    }

    public void setSesi(String sesi) {
        this.sesi = sesi;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPosisi() {
        return posisi;
    }

    public void setPosisi(String posisi) {
        this.posisi = posisi;
    }

    public String getJumlahTask() {
        return jumlahTask;
    }

    public void setJumlahTask(String jumlahTask) {
        this.jumlahTask = jumlahTask;
    }

    public String getTotalGaji() {
        return totalGaji;
    }

    public void setTotalGaji(String totalGaji) {
        this.totalGaji = totalGaji;
    }

    public RiwayatGaji(String nama, String posisi, String jumlahTask, String totalGaji,String sesi) {
        this.nama = nama;
        this.sesi = sesi;
        this.posisi = posisi;
        this.jumlahTask = jumlahTask;
        this.totalGaji = totalGaji;


    }

}
