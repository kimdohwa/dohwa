package com.itgroup.bean;

public class Person {//주문자 아이디, 이름, 주소

    private String id;
    private String name;
    private String address ;
    private int coupon ;

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", coupon='" + coupon + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCoupon() {
        return coupon;
    }

    public void setCoupon(int coupon) {
        this.coupon = coupon;
    }

    public Person() {
        this.id = id;
        this.name = name;
        this.address = address;
        this.coupon = coupon;
    }
}
