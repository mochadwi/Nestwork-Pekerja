package com.sebasku.networks.apimodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseRiwayatGaji {

    /*            "status": "0",
                        "_id": "5aec28556f1f842598913a6a",
                        "email": "tsani@gmail.com",
                        "waktu": "1996-08-01T17:00:00.000Z",
                        "gaji": 0,
                        "createdAt": "2018-05-04T09:31:01.068Z",
                        "updatedAt": "2018-05-04T09:31:01.068Z",
                        "__v": 0*/
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("waktu")
    @Expose
    private String waktu;
    @SerializedName("gaji")
    @Expose
    private String gaji;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;
    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;
    @SerializedName("__v")
    @Expose
    private int v;

    public ResponseRiwayatGaji(String status, String id, String email, String waktu, String gaji, String createdAt, String updatedAt, int v) {
        this.status = status;
        this.id = id;
        this.email = email;
        this.waktu = waktu;
        this.gaji = gaji;
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

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getGaji() {
        return gaji;
    }

    public void setGaji(String gaji) {
        this.gaji = gaji;
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
