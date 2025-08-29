/*package com.itgroup;

import com.itgroup.Dao.DataDao;
import com.itgroup.bean.Delivery;
import com.itgroup.bean.Orders;
import com.itgroup.bean.Person;

import java.util.List;

public class Datamanager {


    DataDao dao = new DataDao();

    public int Login(String findid, String findpw) {
         int login = dao.Login(findid,findpw);
         return login;
    }

    public void Selectmylist(String findid, String findpw) {

        List<Orders> myalllist = dao.Selectmylist(findid,findpw);

        System.out.println("주문번호  /  가게이름  /  메뉴");

        for (Orders bean:myalllist){
            int no = bean.getNo();
            String odname = bean.getOdname();
            String omenu = bean.getOmenu();

            System.out.println(no +"   "+ odname+"   " + omenu);
        }

        System.out.println("\n");

    }

    public void Mypage(String findid) {
        Person mypage = dao.Mypage(findid);
        String id = mypage.getId();
        String name = mypage.getName();
        String address = mypage.getAddress();

        System.out.println( "id : " + id + "\n이름 : "+ name + "\n주소 : "+address);
        System.out.println("\n");
    }

    public void myupdate(String findid,String updatename) {

        int myupdate = dao.myupdate(findid,updatename);

        if (myupdate == -1){
            System.out.println("접속실패");
        }else if (myupdate == 0){
            System.out.println("이름 수정실패");
        }else if (myupdate ==1){
            System.out.println("이름 수정완료");
        }else {
            System.out.println("관리자에게 문의하세요.");
        }
        System.out.println("\n");
    }

    public void myupdate2(String findid,String updatead) {

        int myupdate = dao.myupdate2(findid,updatead);

        if (myupdate == -1){
            System.out.println("접속실패");
        }else if (myupdate == 0){
            System.out.println("주소 수정실패");
        }else if (myupdate ==1){
            System.out.println("주소 수정완료");
        }else {
            System.out.println("관리자에게 문의하세요.");
        }
        System.out.println("\n");
    }

    public void mydelete(String findid) {

        int mydeletes = dao.mydelete(findid);

        if (mydeletes == -1){
            System.out.println("접속실패");
        }else if (mydeletes == 0){
            System.out.println("탈퇴실패");
        }else if (mydeletes ==1){
            System.out.println("탈퇴완료");
        }else {
            System.out.println("관리자에게 문의하세요.");
        }
        System.out.println("\n");
    }


    public void myfind1(String findid,int myorderno) {
        List<Orders> mfind1 = dao.myfind1(findid,myorderno);

        if (mfind1.size()==0){
            System.out.println("주문 번호에 맞는 주문 내역이 없습니다.");
        }else {

            System.out.println("주문번호  /  가게이름  /  메뉴");

            for (Orders bean : mfind1) {
                int no = bean.getNo();
                String odname = bean.getOdname();
                String omenu = bean.getOmenu();
                System.out.println(no+"    "+ odname+"    " + omenu);
            }
        }
        System.out.println("\n");
    }

    public void myfind2(String findid, String myorderodname) {
        List<Orders> mfind2 = dao.myfind2(findid,myorderodname);

        if (mfind2.size()==0){
            System.out.println("주문 번호에 맞는 주문 내역이 없습니다.");
        }else {

            System.out.println("주문번호  /  가게이름  /  메뉴");

            for (Orders bean : mfind2) {
                int no = bean.getNo();
                String odname = bean.getOdname();
                String omenu = bean.getOmenu();
                System.out.println(no+"    "+ odname+"    " + omenu);
            }
        }
        System.out.println("\n");
    }

    public Delivery DLogin(String finddname, int findprice) {

        Delivery Dlogin = dao.Dlogin(finddname,findprice);

        return Dlogin;
    }
}*/
package com.itgroup;

import com.itgroup.Dao.DataDao;
import com.itgroup.bean.Delivery;
import com.itgroup.bean.Orders;
import com.itgroup.bean.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Datamanager {
    Scanner scan = new Scanner(System.in);

    String findid;
    String findpw;
    String finddname;
    int findprice;


    DataDao dao = new DataDao();

    public int Login() {
        System.out.println("■ ID를 입력해주세요.");
        findid = scan.next();

        System.out.println("■ pw를 입력해주세요.");
        findpw = scan.next();
        int login = dao.Login(findid, findpw);

        if (login == -1) {
            System.out.println("■ 접속실패");
        } else if (login == 0) {
            System.out.println("■ 로그인 정보가 없습니다.");
        } else if (login == 1) {
            System.out.println("■ 로그인 성공");
        }

        return login;
    }


    public void Selectmylist() {
        List<Orders> myalllist = dao.Selectmylist(findid, findpw);
        System.out.println("■ 주문번호  /  ■ 가게이름  /  ■ 메뉴");
        for (Orders bean : myalllist) {
            int no = bean.getNo();
            String odname = bean.getOdname();
            String omenu = bean.getOmenu();

            System.out.println(no + "   " + odname + "   " + omenu);
        }
        System.out.println("\n");
    }

    public void Mypage() {
        Person mypage = dao.Mypage(findid);
        String id = mypage.getId();
        String name = mypage.getName();
        String address = mypage.getAddress();
        int coupon = mypage.getCoupon();

        System.out.println("■ id : " + id + "\n■ 이름 : " + name + "\n■ 주소 : " + address+ "\n■ 쿠폰 : " + coupon);
        System.out.println("\n");
    }

    public void myupdate() {

        System.out.println("■ 변경할 이름 입력");
        String updatename = scan.next();

        int myupdate = dao.myupdate(findid, updatename);

        if (myupdate == -1) {
            System.out.println("■ 접속실패");
        } else if (myupdate == 0) {
            System.out.println("■ 이름 수정실패");
        } else if (myupdate == 1) {
            System.out.println("■ 이름 수정완료");
        } else {
            System.out.println("■ 관리자에게 문의하세요.");
        }
    }

    public void myupdate2() {
        System.out.println("■ 변경할 주소 입력");
        String updatead = scan.next();

        int myupdate = dao.myupdate2(findid, updatead);

        if (myupdate == -1) {
            System.out.println("■ 접속실패");
        } else if (myupdate == 0) {
            System.out.println("■ 주소 수정실패");
        } else if (myupdate == 1) {
            System.out.println("■ 주소 수정완료");
        } else {
            System.out.println("■ 관리자에게 문의하세요.");
        }
        System.out.println("\n");
    }

    public void mydelete() {

        int mydeletes = dao.mydelete(findid);

        if (mydeletes == -1) {
            System.out.println("■ 접속실패");
        } else if (mydeletes == 0) {
            System.out.println("■ 탈퇴실패");
        } else if (mydeletes == 1) {
            System.out.println("■ 탈퇴완료");
        } else {
            System.out.println("■ 관리자에게 문의하세요.");
        }
        System.out.println("\n");
    }


    public void myfind1() {

        System.out.println("■ 주문번호를 입력해주세요.");
        int myorderno = scan.nextInt();

        List<Orders> mfind1 = dao.myfind1(findid, myorderno);

        if (mfind1.size() == 0) {
            System.out.println("■ 주문 번호에 맞는 주문 내역이 없습니다.");
        } else {

            System.out.println("■ 주문번호  /  ■ 가게이름  /  ■ 메뉴");

            for (Orders bean : mfind1) {
                int no = bean.getNo();
                String odname = bean.getOdname();
                String omenu = bean.getOmenu();
                System.out.println(no + "    " + odname + "    " + omenu);
            }
        }
        System.out.println("\n");
    }

    public void myfind2() {
        System.out.println("■ 가게 이름을 입력해주세요.");
        String myorderodname = scan.next();

        List<Orders> mfind2 = dao.myfind2(findid, myorderodname);

        if (mfind2.size() == 0) {
            System.out.println("■ 가게이름에 맞는 주문 내역이 없습니다.");
        } else {

            System.out.println("■ 주문번호  /  ■ 가게이름  /  ■ 메뉴");

            for (Orders bean : mfind2) {
                int no = bean.getNo();
                String odname = bean.getOdname();
                String omenu = bean.getOmenu();
                System.out.println(no + "    " + odname + "    " + omenu);
            }
        }
        System.out.println("\n");
    }

    //*****************************************************************************

    String dvname;

    public String DLogin() {
        System.out.println("■ 가게이름을 입력해주세요.");
        String finddname = scan.next();

        System.out.println("■ 메뉴가격을 입력해주세요.");
        int findprice = scan.nextInt();

        Delivery Dlogin = dao.Dlogin(finddname, findprice);
        dvname = Dlogin.getDname();

        if (Dlogin.getDname() == null) {
            System.out.println("■ 로그인 정보가 없습니다.");
        } else {
            System.out.println("■ "+Dlogin.getDname() + "(으)로 로그인되었습니다.");
        }

        return dvname;
    }


    public void SelectDlist() {
        List<Orders> Dalllist = dao.SelectDlist(dvname);
        System.out.println("■ 주문번호  /  ■ 고객 ID  /  ■ 메뉴  / ■ 총 금액");
        for (Orders bean : Dalllist) {

            int no = bean.getNo();
            String oid = bean.getOid();
            String omenu = bean.getOmenu();
            int total = bean.getTotal();

            System.out.println(no + "   " + oid + "   " + omenu + "   " + total);
        }
        System.out.println("\n");
    }

    public void Dfind1() {
        System.out.println("■ 주문번호를 입력해주세요.");
        int Dorderno = scan.nextInt();

        List<Orders> dfind1 = dao.dfind1(Dorderno, dvname);

        if (dfind1.size() == 0) {
            System.out.println("■ 주문 번호에 맞는 주문 내역이 없습니다.");
        } else {

            System.out.println("■주문번호  /  ■ 고객 ID  /  ■ 메뉴  /  ■ 총 금액");

            for (Orders bean : dfind1) {
                int no = bean.getNo();
                String oid = bean.getOid();
                String omenu = bean.getOmenu();
                int total = bean.getTotal();
                System.out.println(no + "    " + oid + "    " + omenu + "    " + total);
            }
        }
        System.out.println("\n");
    }

    public void Dfind2() {
        System.out.println("■ 고객 ID를 입력해주세요.");
        String Dorderid = scan.next();

        List<Orders> dfind2 = dao.dfind2(Dorderid, dvname);

        if (dfind2.size() == 0) {
            System.out.println("■ 주문 번호에 맞는 주문 내역이 없습니다.");
        } else {

            System.out.println("■ 주문번호  /  ■ 고객 ID  /  ■ 메뉴  /  ■ 총 금액");

            for (Orders bean : dfind2) {
                int no = bean.getNo();
                String oid = bean.getOid();
                String omenu = bean.getOmenu();
                int total = bean.getTotal();
                System.out.println(no + "    " + oid + "    " + omenu + "    " + total);
            }
        }
        System.out.println("\n");
    }

    public void Dfind3() {
        System.out.println("■ 고객 주소를 입력해주세요.");
        String Dorderad = scan.next();

        List<Orders> dfind3 = dao.dfind3(Dorderad, dvname);

        if (dfind3.size() == 0) {
            System.out.println("■ 주문 번호에 맞는 주문 내역이 없습니다.");
        } else {

            System.out.println("■ 주문번호  /  ■ 고객 ID   /  ■ 주소  /  ■ 메뉴  /  ■ 총 금액");

            for (Orders bean : dfind3) {
                int no = bean.getNo();
                String oid = bean.getOid();
                String ad = bean.getEtc();
                String omenu = bean.getOmenu();
                int total = bean.getTotal();
                System.out.println(no + "    " + oid + "    " + ad + "     " + omenu + "    " + total);
            }
        }
        System.out.println("\n");
    }

    public void priceupdate() {

        System.out.println("■ 변경할 가격 입력");
        int updateprice = scan.nextInt();
        scan.nextLine();

        int cnt = dao.priceupdate(dvname, updateprice);

        if (cnt == -1) {
            System.out.println("■ 접속실패");
        } else if (cnt == 0) {
            System.out.println("■ 가격 수정실패");
        } else if (cnt == 1) {
            System.out.println("■ 가격 수정완료");
        } else {
            System.out.println("■ 관리자에게 문의하세요.");
        }
        System.out.println(" ");
    }


    public void priceupdate2() {

        System.out.println("■ 변경할 배달비 입력");
        int updateprice2 = scan.nextInt();
        scan.nextLine();

        int cnt = dao.priceupdate2(dvname, updateprice2);

        if (cnt == -1) {
            System.out.println("■ 접속실패");
        } else if (cnt == 0) {
            System.out.println("■ 배달비 수정실패");
        } else if (cnt == 1) {
            System.out.println("■ 배달비 수정완료");
        } else {
            System.out.println("■ 관리자에게 문의하세요.");
        }
        System.out.println(" ");
    }

    public void Ddelete() {
        int Ddelete = dao.Ddelete(dvname);

        if (Ddelete == -1) {
            System.out.println("■ 접속실패");
        } else if (Ddelete == 0) {
            System.out.println("■ 탈퇴실패");
        } else if (Ddelete == 1) {
            System.out.println("■ 탈퇴완료");
        } else {
            System.out.println("■ 관리자에게 문의하세요.");
        }
        System.out.println(" ");
    }

    public void Dpage() {
        Delivery Dpage = dao.Dpage(dvname);
        String dname = Dpage.getDname();
        String menu = Dpage.getMenu();
        int price = Dpage.getPrice();
        int fee = Dpage.getFee();


        System.out.println("■ 가게이름 : " + dname + "\n■ 메뉴 : " + menu + "\n■ 가격 : " + price + "\n■ 배달비 : " + fee);
        System.out.println(" ");
    }

    //*************************************************************************************

    public void order() {

        String dname1 = null;
        String menu = null;
        int price = 0;
        int fee = 0;

        List<Delivery> bean = null;

        boolean bool3 = true;
        while (bool3){
            try {
                System.out.println("1.가게찾기 2.뒤로가기");
                int order = scan.nextInt();

                switch (order) {
                    case 1:
                        boolean bool = true;
                        while (bool) {
                            scan.nextLine();
                            System.out.println("■ 주문할 가게 이름을 입력해주세요.");
                            String dname = scan.next();
                            bean = dao.dvselect(dname);

                            if (bean.size() == 0) {
                                System.out.println("■ 입력한 가게를 찾을수 없습니다.");
                            } else if (bean.size() == 1) {
                                for (Delivery one : bean) {

                                    dname1 = one.getDname();
                                    menu = one.getMenu();
                                    price = one.getPrice();
                                    fee = one.getFee();
                                    System.out.println("■ 주문할 가게와 메뉴 이름을 확인해주세요.");
                                    System.out.println(dname1 + "    " + menu + "    " + price + "    " + fee + "    ");
                                    bool = false;
                                }//for
                            }//elsof
                            else {
                                System.out.println("■ 가게이름을 상세히 다시 입력해주세요");
                            }//els
                        } //while

                        bool = true;

                        while (bool) {

                            try {System.out.println("1.추가하기 2.삭제하기 3.주문하기 4.뒤로가기");
                                int ordermenu = scan.nextInt();

                                switch (ordermenu) {
                                    case 1:
                                        scan.nextLine();
                                        System.out.println("■ 추가할 가게 이름을 입력해주세요.");
                                        String dname2 = scan.nextLine();

                                        List<Delivery> bean2 = dao.dvselect2(dname2);

                                        if (bean2.isEmpty()) {
                                            System.out.println("■ 입력한 가게를 찾을수 없습니다.");
                                        } else if (bean2.size() == 1) {
                                            for (Delivery item : bean2) {
                                                dname1 = item.getDname();
                                                menu = item.getMenu();
                                                price = item.getPrice();
                                                fee = item.getFee();

                                                bean.add(item);

                                                System.out.println("\n■ " + dname1 + "이 추가되었습니다.");
                                            }
                                            System.out.println("\n■ 총 목록 \n");
                                            for (Delivery one : bean) {
                                                dname1 = one.getDname();
                                                menu = one.getMenu();
                                                price = one.getPrice();
                                                fee = one.getFee();

                                                System.out.println(dname1 + "    " + menu + "    " + price + "    " + fee + "    ");
                                            }
                                            System.out.println(" ");
                                        }//elsof
                                        else {
                                            for (Delivery one : bean2) {
                                                dname1 = one.getDname();
                                                System.out.println(dname1);
                                            }
                                            System.out.println("■ 가게이름을 상세히 다시 입력해주세요.");
                                        }
                                        break;
                                    case 2://삭제
                                        scan.nextLine();
                                        System.out.println("■ 삭제할 가게 이름을 입력해주세요.");
                                        String deletdname = scan.nextLine();

                                        List<Delivery> bean3 = dao.deletdname(deletdname);

                                        if (bean3.isEmpty()) {
                                            System.out.println("■ 입력한 가게를 찾을수 없습니다.");
                                        } else if (bean3.size() == 1) {

                                            for (Delivery item : bean3) {

                                                dname1 = item.getDname();
                                                menu = item.getMenu();
                                                price = item.getPrice();
                                                fee = item.getFee();

                                                if(bean.remove(item)){
                                                    System.out.println("\n■ " + dname1 + "이 삭제되었습니다.");
                                                }else {
                                                    System.out.println("■ 목록에 해당 가게가 없습니다.");
                                                }
                                                //딜리버리클래스에 오버라이드 확인


                                            }

                                            System.out.println("\n■ 총 목록 \n");
                                            for (Delivery one : bean) {
                                                dname1 = one.getDname();
                                                menu = one.getMenu();
                                                price = one.getPrice();
                                                fee = one.getFee();

                                                System.out.println(dname1 + "    " + menu + "    " + price + "    " + fee + "    ");
                                            }
                                            System.out.println(" ");
                                        }//elsof
                                        else {
                                            for (Delivery one : bean3) {
                                                dname1 = one.getDname();
                                                System.out.println(dname1);
                                            }
                                            System.out.println("■ 가게이름을 상세히 다시 입력해주세요.");
                                        }
                                        break;
                                    case 3://주문하기
                                        System.out.println("■ 주문내용을 확인해주세요.");
                                        System.out.println("\n■ 가게이름  /  ■ 메뉴  /  ■ 가격  /  ■ 배달비  ");

                                        int totalprice = 0;
                                        int totalfee = 0;

                                        for (Delivery listprice:bean){

                                            dname1 = listprice.getDname();
                                            menu = listprice.getMenu();
                                            price = listprice.getPrice();
                                            fee = listprice.getFee();

                                            System.out.println(dname1 + "    " + menu + "    " + price + "    " + fee + "    ");

                                            totalprice += price;
                                            totalfee += fee;
                                        }

                                        System.out.println("\n -메뉴 금액 : "+totalprice +"원");
                                        System.out.println(" -배달비 : "+totalfee+"원"+"\n");
                                        System.out.println("  ▷합계 금액 : "+(totalfee+totalprice)+"원"+"\n");

                                        //쿠폰
                                        Person coupon = dao.coupon(findid);

                                        System.out.println(" ▶쿠폰 적용 가능금액 : "+coupon.getCoupon()+"원"+"\n");

                                        int total = totalfee+totalprice-coupon.getCoupon();

                                        if (total<0){
                                            total = 0 ;
                                        }

                                        System.out.println("■ [총 결제 금액] : "+(total)+"원"+"\n");
                                        boolean bool1 = true;
                                        while (bool1){
                                            try {System.out.println("\n1.주문하기 2.뒤로가기");
                                                int listprice = scan.nextInt();

                                                switch (listprice){
                                                    case 1:
                                                        for (Delivery one : bean) {
                                                            String dname3 = one.getDname();
                                                            String menu1 = one.getMenu();
                                                            int price1 = one.getPrice();
                                                            int fee1 = one.getFee();

                                                            int cnt = dao.insetorder(findid, dname3, menu1);
                                                            if (cnt == -1) {
                                                                System.out.println("■ 접속실패");
                                                            } else if (cnt == 0) {
                                                                System.out.println("■ 주문불가");
                                                            } else if (cnt == 1) {
                                                                System.out.println("\n■ "+dname3 + "주문완료");
                                                            } else {
                                                                System.out.println("■ 관리자에게 문의하세요.");
                                                            }
                                                        }
                                                        System.out.println(" ");
                                                        System.exit(0);
                                                        break;
                                                    case 2:
                                                        bool1 =false;
                                                        break;
                                                }//switch

                                            }catch (InputMismatchException e){
                                                System.out.println("❌ 숫자가 아닙니다. 숫자만 입력해주세요.");
                                                scan.nextLine(); // 입력 버퍼 비우기
                                            }
                                        }
                                        break;//case3 브레이크*/
                                    case 4:
                                        bool = false;
                                        break;
                                }

                            }catch (InputMismatchException e){
                                System.out.println("❌ 숫자가 아닙니다. 숫자만 입력해주세요.");
                                scan.nextLine(); // 입력 버퍼 비우기
                            }

                        }
                        break;
                    case 2:
                        break;
                }

                bool3 = false;

            }catch (InputMismatchException e){
                System.out.println("❌ 숫자가 아닙니다. 숫자만 입력해주세요.");
                scan.nextLine(); // 입력 버퍼
                bool3 = false;
            }
        }
    }
}




