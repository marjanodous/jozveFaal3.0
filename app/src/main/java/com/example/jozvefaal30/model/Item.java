package com.example.jozvefaal30.model;

public class Item {
    private int uAvatar;
    private String uName;
    private String uReshte;
    private String uPrice;
    private String uEnteshar;
    private String uUpload;
    private String uTozihat;
    private String uOstadName;
    private String uDaneshgah;
    /* 2.constructors */
    public Item() {
    }

//    public model(int uAvatar) {
//        this.uAvatar = uAvatar;
//    }


    public Item(int uAvatar, String uName, String uReshte, String uPrice, String uEnteshar, String uUpload, String uTozihat, String uOstadName, String uDaneshgah) {
        this.uAvatar = uAvatar;
        this.uName = uName;
        this. uReshte= uReshte;
        this.uPrice = uPrice;
        this.uEnteshar=uEnteshar;
        this.uUpload=uUpload;
        this.uTozihat=uTozihat;
        this.uOstadName=uOstadName;
        this.uDaneshgah=uDaneshgah;
    }



    public int getuAvatar() {
        return uAvatar;
    }

    public void setuAvatar(int uAvatar) {
        this.uAvatar = uAvatar;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuReshte() {
        return uReshte;
    }

    public void setuReshte(String uReshte) {
        this.uReshte = uReshte;
    }

    public String getuPrice() {
        return uPrice;
    }

    public void setuPrice(String uPrice) {
        this.uPrice = uPrice;
    }

    public String getuEnteshar() {
        return uEnteshar;
    }

    public void setuEnteshar(String uEnteshar) {
        this.uEnteshar = uEnteshar;
    }

    public String getuUpload() {
        return uUpload;
    }

    public void setuUpload(String uUpload) {
        this.uUpload = uUpload;
    }

    public String getuTozihat() {
        return uTozihat;
    }

    public void setuTozihat(String uTozihat) {
        this.uTozihat = uTozihat;
    }

    public String getuOstadName() {
        return uOstadName;
    }

    public void setuOstadName(String uOstadName) {
        this.uOstadName = uOstadName;
    }

    public String getuDaneshgah() {
        return uDaneshgah;
    }

    public void setuDaneshgah(String uDaneshgah) {
        this.uDaneshgah = uDaneshgah;
    }
}
