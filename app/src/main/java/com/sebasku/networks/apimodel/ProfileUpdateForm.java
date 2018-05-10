package com.sebasku.networks.apimodel;

/**
 * Created by fadil on 4/1/18.
 */

public class ProfileUpdateForm {
    /*mNama,mEmail,mBidang,mNoHp,mTanggal,mPswdBaru*/

    private String nama;
    private String email;
    private String bidang;
    private String noHp;
    private String tanggal;
    private String password;

    public ProfileUpdateForm(String nama, String email, String bidang, String noHp, String tanggal, String password) {
        this.nama = nama;
        this.email = email;
        this.bidang = bidang;
        this.noHp = noHp;
        this.tanggal = tanggal;
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBidang() {
        return bidang;
    }

    public void setBidang(String bidang) {
        this.bidang = bidang;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

