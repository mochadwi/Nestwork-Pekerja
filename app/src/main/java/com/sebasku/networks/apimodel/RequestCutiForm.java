package com.sebasku.networks.apimodel;

/**
 * Created by fadil on 4/2/18.
 */

public class RequestCutiForm {
    private String email;
    private String nama;
    private String awalCuti;
    private String akhirCuti;
    private String keterangan;
    private String respons;
    private String status;

    public RequestCutiForm(String email, String nama, String awalCuti, String akhirCuti, String keterangan, String respons, String status) {
        this.email = email;
        this.nama = nama;
        this.awalCuti = awalCuti;
        this.akhirCuti = akhirCuti;
        this.keterangan = keterangan;
        this.respons = respons;
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAwalCuti() {
        return awalCuti;
    }

    public void setAwalCuti(String awalCuti) {
        this.awalCuti = awalCuti;
    }

    public String getAkhirCuti() {
        return akhirCuti;
    }

    public void setAkhirCuti(String akhirCuti) {
        this.akhirCuti = akhirCuti;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getRespons() {
        return respons;
    }

    public void setRespons(String respons) {
        this.respons = respons;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
