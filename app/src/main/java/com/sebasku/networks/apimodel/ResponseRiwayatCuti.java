package com.sebasku.networks.apimodel;

/**
 * Created by fadil on 4/9/18.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseRiwayatCuti {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("awal_cuti")
    @Expose
    private String awalCuti;
    @SerializedName("akhir_cuti")
    @Expose
    private String akhirCuti;
    @SerializedName("keterangan")
    @Expose
    private String keterangan;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;
    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;
    @SerializedName("__v")
    @Expose
    private int v;

    public ResponseRiwayatCuti(String status, String id, String email, String awalCuti, String akhirCuti, String keterangan, String createdAt, String updatedAt, int v) {
        this.status = status;
        this.id = id;
        this.email = email;
        this.awalCuti = awalCuti;
        this.akhirCuti = akhirCuti;
        this.keterangan = keterangan;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.v = v;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }
}