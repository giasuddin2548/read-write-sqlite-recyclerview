package com.genxmultiplexer.sqlitefinalproject;

public class ViewData_Model {
    private String std_id, std_name, std_phoneno,std_imagelink;


    public ViewData_Model(String std_id, String std_name, String std_phoneno, String std_imagelink) {
        this.std_id = std_id;
        this.std_name = std_name;
        this.std_phoneno = std_phoneno;
        this.std_imagelink = std_imagelink;
    }

    public String getStd_id() {
        return std_id;
    }

    public void setStd_id(String std_id) {
        this.std_id = std_id;
    }

    public String getStd_name() {
        return std_name;
    }

    public void setStd_name(String std_name) {
        this.std_name = std_name;
    }

    public String getStd_phoneno() {
        return std_phoneno;
    }

    public void setStd_phoneno(String std_phoneno) {
        this.std_phoneno = std_phoneno;
    }

    public String getStd_imagelink() {
        return std_imagelink;
    }

    public void setStd_imagelink(String std_imagelink) {
        this.std_imagelink = std_imagelink;
    }
}
