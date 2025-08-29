package com.itgroup.bean;

import java.util.Objects;

public class Delivery {// 가게이름, 메뉴, 메뉴가격, 배달비

    private String dname ;
    private String menu ;
    private  int price ;
    private int  fee ;

    @Override
    public String toString() {
        return "Delivery{" +
                "dname='" + dname + '\'' +
                ", menu='" + menu + '\'' +
                ", price=" + price +
                ", fee=" + fee +
                '}';
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public Delivery() {
        this.dname = dname;
        this.menu = menu;
        this.price = price;
        this.fee = fee;
    }

    public Delivery(String dname,String menu,int price,int fee) {
        this.dname = dname;
        this.menu = menu;
        this.price = price;
        this.fee = fee;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Delivery delivery = (Delivery) o;
        return price == delivery.price && fee == delivery.fee && Objects.equals(dname, delivery.dname) && Objects.equals(menu, delivery.menu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dname, menu, price, fee);
    }
}
