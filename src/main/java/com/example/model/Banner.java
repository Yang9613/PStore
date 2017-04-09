package com.example.model;

public class Banner {
    private String favcategory;

    private String bannername;

    public String getFavcategory() {
        return favcategory;
    }

    public void setFavcategory(String favcategory) {
        this.favcategory = favcategory == null ? null : favcategory.trim();
    }

    public String getBannername() {
        return bannername;
    }

    public void setBannername(String bannername) {
        this.bannername = bannername == null ? null : bannername.trim();
    }
}