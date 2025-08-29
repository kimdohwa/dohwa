package com.itgroup.bean;

public class Orders {//주문번호, 주문한고객아이디, 주문한가게이름, 주문한메뉴

    private int no ;
    private String oid ;
    private String odname ;
    private String omenu ;
    private int total ;
    private String etc ;

    @Override
    public String toString() {
        return "Orders{" +
                "no=" + no +
                ", oid='" + oid + '\'' +
                ", odname='" + odname + '\'' +
                ", omenu='" + omenu + '\'' +
                ", total='" + total + '\'' +
                ", etc='" + etc + '\'' +
                '}';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getOdname() {
        return odname;
    }

    public void setOdname(String odname) {
        this.odname = odname;
    }

    public String getOmenu() {
        return omenu;
    }

    public void setOmenu(String omenu) {
        this.omenu = omenu;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getEtc() {
        return etc;
    }

    public void setEtc(String etc) {
        this.etc = etc;
    }

    public Orders() {
        this.no = no;
        this.oid = oid;
        this.odname = odname;
        this.omenu = omenu;
        this.total = total;
        this.etc = etc;
    }
}
