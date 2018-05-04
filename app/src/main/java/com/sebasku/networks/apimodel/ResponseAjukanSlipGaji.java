package com.sebasku.networks.apimodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseAjukanSlipGaji {

    /*    	"email":"tsani@gmail.com",
                "waktu":"08-02-1996",
                "status":"0",
                "gaji":"0"*/

    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("waktu")
    @Expose
    private String waktu;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("gaji")
    @Expose
    private String gaji;

    public ResponseAjukanSlipGaji(String email, String waktu, String status, String gaji) {
        this.email = email;
        this.waktu = waktu;
        this.status = status;
        this.gaji = gaji;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGaji() {
        return gaji;
    }

    public void setGaji(String gaji) {
        this.gaji = gaji;
    }
}
