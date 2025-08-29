package com.itgroup;

import java.util.InputMismatchException;

import java.util.Scanner;

public class DohwaMain {
    public static void main(String[] args) {

        Datamanager manager = new Datamanager();
        Scanner scan = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("1.주문자  2.점주  3.종료");//1번분류

                int subject = scan.nextInt();

                switch (subject) {//1번분류 케이스
                    case 1:
                        int login = manager.Login();

                        if (login != 1) {
                            break;
                        }
                        boolean inSettings = true;

                        while (inSettings) {
                            try {

                                System.out.println("1.주문하기  2.전체주문보기  3.주문내역검색하기  4.내정보 5. 뒤로가기");//2번분류
                                int Customerist = scan.nextInt();
                                scan.nextLine();
                                switch (Customerist) {//2번분류 케이스
                                    case 1:
                                        manager.order();
                                        break;
                                    case 2://전체주문보기
                                        manager.Selectmylist();
                                        break;
                                    case 3:// 주문내역 검색하기
                                        boolean bool = true;
                                        while (bool){
                                            try {
                                                System.out.println("1.주문번호로 검색 2.가게이름으로 검색 3.뒤로가기");
                                                int find = scan.nextInt();
                                                scan.nextLine();
                                                switch (find) {
                                                    case 1:
                                                        manager.myfind1();
                                                        break;
                                                    case 2:
                                                        manager.myfind2();
                                                        break;
                                                    case 3:
                                                        bool=false;
                                                        break;
                                                }
                                            }catch (InputMismatchException e){
                                                System.out.println("❌ 숫자가 아닙니다. 숫자만 입력해주세요.");
                                                scan.nextLine(); // 입력 버퍼 비우기
                                            }
                                        }
                                        break;
                                    case 4:
                                        boolean inSettings1_4 = true;
                                        while (inSettings1_4) {

                                            try {
                                                System.out.println("1.정보보기 2.수정 3.탈퇴 4.뒤로가기");//내정보
                                                int mypage = scan.nextInt();
                                                switch (mypage) {//3번분류 케이스
                                                           case 1:
                                                        manager.Mypage();
                                                        break;
                                                    case 2:
                                                        boolean bool2 =true;
                                                        while (bool2){

                                                                System.out.println("1.이름수정 2.주소수정 3.뒤로가기");
                                                                int update = scan.nextInt();
                                                                switch (update) {
                                                                    case 1:
                                                                        manager.myupdate();
                                                                        break;
                                                                    case 2:
                                                                        manager.myupdate2();
                                                                        break;
                                                                    case 3:
                                                                        bool2=false;
                                                                        break;
                                                                }
                                                        }
                                                        break;
                                                    case 3:
                                                        System.out.println("1.탈퇴 2.취소");
                                                        int mydelete = scan.nextInt();
                                                        switch (mydelete) {
                                                            case 1:
                                                                manager.mydelete();
                                                                break;
                                                            case 2:
                                                        }
                                                        break;
                                                    case 4:
                                                        inSettings1_4 = false;
                                                        break;
                                                }

                                            }catch (InputMismatchException e){
                                                System.out.println("❌ 숫자가 아닙니다. 숫자만 입력해주세요.");
                                                scan.nextLine(); // 입력 버퍼 비우기
                                            }
                                        }
                                        break;
                                    case 5:
                                        inSettings = false;
                                        break;
                                }

                            }catch (InputMismatchException e){
                                System.out.println("❌ 숫자가 아닙니다. 숫자만 입력해주세요.");
                                scan.nextLine(); // 입력 버퍼 비우기
                            }

                            //여기까지
                        }
                        break;
                    //************************************************

                    case 2://점주메뉴

                        String Dlogin = manager.DLogin();//로그인

                        if (Dlogin == null) {
                            break;
                        }

                        boolean inSettings2 = true;

                        while (inSettings2) {
                            try {
                                System.out.println("1.전체주문보기 2.주문내역검색하기 3.내가게정보 4.뒤로가기");
                                int Deliverlist = scan.nextInt();

                                switch (Deliverlist) {
                                    case 1://전체주문보기
                                        manager.SelectDlist();
                                        break;
                                    case 2://주문내역 검색하기
                                        boolean bool = true;
                                        while (bool){
                                            try {
                                                System.out.println("1.주문번호로 검색 2.고객 ID로 검색 3.주소로 검색 4.뒤로가기");
                                                int find = scan.nextInt();
                                                switch (find) {
                                                    case 1:
                                                        manager.Dfind1();
                                                        break;
                                                    case 2:
                                                        manager.Dfind2();
                                                        break;
                                                    case 3:
                                                        manager.Dfind3();
                                                        break;
                                                    case 4:
                                                        bool=false;
                                                        break;
                                                }
                                            }catch (InputMismatchException e){
                                                System.out.println("❌ 숫자가 아닙니다. 숫자만 입력해주세요.");
                                                scan.nextLine(); // 입력 버퍼 비우기
                                            }
                                        }
                                        break;
                                    case 3://내정보
                                        boolean inSettings2_3 = true;
                                        while (inSettings2_3) {
                                            try {
                                                System.out.println("1.가게정보보기 2.수정 3.탈퇴 4.뒤로가기");//가게정보
                                                int Dpage = scan.nextInt();
                                                switch (Dpage) {
                                                    case 1:
                                                        manager.Dpage();
                                                        break;
                                                    case 2:
                                                        System.out.println("1.가격수정 2.배달비 수정 3.뒤로가기");
                                                        int priceupdate = scan.nextInt();
                                                        switch (priceupdate) {
                                                            case 1:
                                                                manager.priceupdate();
                                                                break;
                                                            case 2:
                                                                manager.priceupdate2();
                                                                break;
                                                            case 3:
                                                                break;
                                                        }
                                                        break;
                                                    case 3:
                                                        System.out.println("1.탈퇴 2.취소");
                                                        int Ddelete = scan.nextInt();
                                                        switch (Ddelete) {
                                                            case 1:
                                                                manager.Ddelete();
                                                                break;
                                                            case 2:
                                                        }
                                                        break;
                                                    case 4:
                                                        inSettings2_3 = false;
                                                        break;
                                                }
                                            }catch (InputMismatchException e){
                                                System.out.println("❌ 숫자가 아닙니다. 숫자만 입력해주세요.");
                                                scan.nextLine(); // 입력 버퍼 비우기
                                            }
                                        }
                                        break;

                                    case 4:
                                        inSettings2 = false;
                                        break;
                                }

                            }catch (InputMismatchException e){
                                System.out.println("❌ 숫자가 아닙니다. 숫자만 입력해주세요.");
                                scan.nextLine(); // 입력 버퍼 비우기
                            }
                        }
                        break;
                    case 3:
                        System.out.println("종료합니다.");
                        System.exit(0);

                    default:
                        System.out.println("다시 입력해주세요.");
                }
            } catch (InputMismatchException e) {
                System.out.println("❌ 숫자가 아닙니다. 숫자만 입력해주세요.");
                scan.nextLine(); // 입력 버퍼 비우기
            }
        }
    }
}