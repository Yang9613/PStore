package com.example.model;

public class Cart extends CartKey {
    private Integer quantity;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    private Object ilist;

    public Object getIlist() {
        return ilist;
    }

    public void setIlist(Object ilist) {
        this.ilist = ilist;
    }
}