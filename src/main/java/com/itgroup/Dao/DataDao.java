package com.itgroup.Dao;

import com.itgroup.bean.Delivery;
import com.itgroup.bean.Orders;
import com.itgroup.bean.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataDao extends SuperDao {

    public int Login(String findid, String findpw) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int login = -1;

        String sql = "select count(*) from person where id = ? and password = ?";

        try {
            conn = super.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, findid);
            ps.setString(2, findpw);
            rs = ps.executeQuery();

            if (rs.next()) {
                login = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return login;

    }//고객 로그인


    public List<Orders> Selectmylist(String findid, String findpw) {
        List<Orders> myalllist = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;


        String sql = "select no, odname, omenu from orders where oid = ?";

        try {
            conn = super.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, findid);
            rs = ps.executeQuery();

            while (rs.next()) {
                Orders bean = new Orders();

                bean.setNo(rs.getInt("no"));
                bean.setOdname(rs.getNString("odname"));
                bean.setOmenu(rs.getNString("omenu"));

                myalllist.add(bean);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return myalllist;

    }// 고객주문 전체보기


    public Person Mypage(String findid) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Person bean = new Person();

        String sql = "select * from person where id = ?";

        try {
            conn = super.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, findid);
            rs = ps.executeQuery();

            if (rs.next()) {
                bean.setId(rs.getString("id"));
                bean.setName(rs.getString("name"));
                bean.setAddress(rs.getString("address"));
                bean.setCoupon(rs.getInt("coupon"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return bean;
    } //고객 내정보보기


    public int myupdate(String findid, String updatename) {
        Connection conn = null;
        PreparedStatement ps = null;
        int cnt = -1;

        String sql = "update person set name = ? where id = ?";

        try {
            conn = super.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(2, findid);
            ps.setString(1, updatename);
            cnt = ps.executeUpdate();
            conn.commit();

        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (Exception ex) {
                e.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return cnt;
    } // 고객 이름수정하기


    public int myupdate2(String findid, String updatead) {
        Connection conn = null;
        PreparedStatement ps = null;
        int cnt = -1;

        String sql = "update person set address = ? where id = ?";

        try {
            conn = super.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(2, findid);
            ps.setString(1, updatead);
            cnt = ps.executeUpdate();

            conn.commit();

        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (Exception ex) {
                e.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return cnt;
    } //고객 주소수정하기


    public int mydelete(String findid) {
        Connection conn = null;
        PreparedStatement ps = null;
        int cnt = -1;

        String sql = "delete from person where id = ?";

        try {
            conn = super.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, findid);
            cnt = ps.executeUpdate();

            conn.commit();

        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (Exception ex) {
                e.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return cnt;
    } //고객 탈퇴하기

    public List<Orders> myfind1(String findid, int myorderno) {
        List<Orders> myfind1 = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select * from orders where no = ? and oid = ?";

        try {
            conn = super.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, myorderno);
            ps.setString(2, findid);
            rs = ps.executeQuery();

            while (rs.next()) {
                Orders bean = new Orders();
                bean.setNo(rs.getInt("no"));
                bean.setOdname(rs.getString("odname"));
                bean.setOmenu(rs.getString("omenu"));

                myfind1.add(bean);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
                if (rs != null) {
                    rs.close();
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return myfind1;
    } // 고객 주문번호로검색

    public List<Orders> myfind2(String findid, String myorderodname) {
        List<Orders> myfind2 = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select * from orders where odname like ? and oid = ?";

        try {
            conn = super.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + myorderodname + "%");
            ps.setString(2, findid);
            rs = ps.executeQuery();

            while (rs.next()) {
                Orders bean = new Orders();
                bean.setNo(rs.getInt("no"));
                bean.setOdname(rs.getString("odname"));
                bean.setOmenu(rs.getString("omenu"));

                myfind2.add(bean);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
                if (rs != null) {
                    rs.close();
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return myfind2;
    }// 고객 가게이름으로 검색

    //-------------------------------------------------------------------------------------

    public Delivery Dlogin(String finddname, int findprice) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Delivery bean = new Delivery();


        String sql = "select * from delivery where dname like ? and price = ?";

        try {
            conn = super.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,  "%"+finddname + "%");
            ps.setInt(2, findprice);
            rs = ps.executeQuery();


            if (rs.next()) {
               bean.setDname(rs.getString("dname"));
            }

        } catch (Exception e) {
            System.out.println("접속실패");
            e.printStackTrace();
            System.exit(0);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
                if (rs != null) {
                    rs.close();
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return bean;
    } // 점주 로그인

    public List<Orders> SelectDlist(String Dlogin) {
        List<Orders> myDlist = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;


        String sql = "select o.no, o.oid, o.odname, o.omenu, (d.price+ d.fee) as total" +
                " from orders o join delivery d" +
                " on o.odname = d.dname" +
                " where odname = ?";

        try {
            conn = super.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, Dlogin);
            rs = ps.executeQuery();

            while (rs.next()) {
                Orders bean = new Orders();

                bean.setNo(rs.getInt("no"));
                bean.setOid(rs.getNString("oid"));
                bean.setOmenu(rs.getNString("omenu"));
                bean.setTotal(rs.getInt("total"));

                myDlist.add(bean);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return myDlist;

    } // 점주 주문 전체보기

    public List<Orders> dfind1(int Dorderno,String dvname) {
        List<Orders> dfind1 = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select o.no, o.oid, o.odname, o.omenu, (d.price+ d.fee) as total" +
                " from orders o join delivery d" +
                " on o.odname = d.dname" +
                " where odname = ? and no = ?";

        try {
            conn = super.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(2, Dorderno);
            ps.setString(1, dvname);
            rs = ps.executeQuery();

            while (rs.next()) {
                Orders bean = new Orders();
                bean.setNo(rs.getInt("no"));
                bean.setOid(rs.getString("oid"));
                bean.setOmenu(rs.getString("omenu"));
                bean.setTotal(rs.getInt("total"));

                dfind1.add(bean);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
                if (rs != null) {
                    rs.close();
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return dfind1;

    } // 점주 주문번호로 검색하기

    public List<Orders> dfind2(String dorderid, String dvname) {
        List<Orders> dfind2 = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select o.no, o.oid, o.odname, o.omenu, (d.price+ d.fee) as total" +
                " from orders o join delivery d" +
                " on o.odname = d.dname" +
                " where odname = ? and oid = ?";

        try {
            conn = super.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(2, dorderid);
            ps.setString(1, dvname);
            rs = ps.executeQuery();

            while (rs.next()) {
                Orders bean = new Orders();
                bean.setNo(rs.getInt("no"));
                bean.setOid(rs.getString("oid"));
                bean.setOmenu(rs.getString("omenu"));
                bean.setTotal(rs.getInt("total"));

                dfind2.add(bean);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
                if (rs != null) {
                    rs.close();
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return dfind2;
    } // 점주 고객id로 검색하기

    public List<Orders> dfind3(String dorderad, String dvname) {
        List<Orders> dfind2 = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT \n" +
                "    o.no,\n" +
                "    o.oid,\n" +
                "    o.odname,\n" +
                "    o.omenu,\n" +
                "    p.address,\n" +
                "    d.price + d.fee AS total\n" +
                "FROM orders o\n" +
                "JOIN person p ON o.oid = p.id\n" +
                "JOIN delivery d ON o.odname = d.dname\n" +
                "WHERE p.address LIKE ? \n" +
                "  AND o.odname = ? ";

        try {
            conn = super.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, dorderad+"%");
            ps.setString(2, dvname);
            rs = ps.executeQuery();


                while (rs.next()) {
                Orders bean = new Orders();
                bean.setNo(rs.getInt("no"));
                bean.setOid(rs.getString("oid"));
                bean.setOmenu(rs.getString("omenu"));
                bean.setTotal(rs.getInt("total"));
                bean.setEtc(rs.getString("address"));

                dfind2.add(bean);
                }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
                if (rs != null) {
                    rs.close();
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return dfind2;
    }// 점주 주소로 검색하기


    public int priceupdate(String dvname, int updateprice) {

        Connection conn = null;
        PreparedStatement ps = null;
        int cnt = -1;

        String sql = "update delivery set price = ? where dname = ?";

        try {
            conn = super.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,updateprice);
            ps.setString(2,dvname);

            cnt = ps.executeUpdate();

            conn.commit();

        }catch (Exception e){
            try {
                conn.rollback();
            }catch (Exception ex){
                e.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try{
                if (ps != null){ps.close();}
                if (conn != null){conn.close();}

            }catch (Exception ex){
                ex.printStackTrace();
            }
        }

        return cnt;
    } //점주 가격수정

    public int priceupdate2(String dvname, int updateprice2) {
        Connection conn = null;
        PreparedStatement ps = null;
        int cnt = -1;

        String sql = "update delivery set fee = ? where dname = ?";

        try {
            conn = super.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,updateprice2);
            ps.setString(2,dvname);

            cnt = ps.executeUpdate();

            conn.commit();

        }catch (Exception e){
            try {
                conn.rollback();
            }catch (Exception ex){
                e.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try{
                if (ps != null){ps.close();}
                if (conn != null){conn.close();}

            }catch (Exception ex){
                ex.printStackTrace();
            }
        }

        return cnt;

    }// 점주 배달비수정

    public int Ddelete(String dvname) {
        Connection conn = null;
        PreparedStatement ps = null;
        int cnt = -1;

        String sql = "delete from delivery where dname = ?";

        try {
            conn = super.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, dvname);
            cnt = ps.executeUpdate();

            conn.commit();

        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (Exception ex) {
                e.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return cnt;
    } // 점주 탈퇴

    public Delivery Dpage(String dvname) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Delivery bean = new Delivery();

        String sql = "select * from delivery where dname = ?";

        try {
            conn = super.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, dvname);
            rs = ps.executeQuery();

            if (rs.next()) {
                bean.setDname(rs.getString("dname"));
                bean.setMenu(rs.getString("menu"));
                bean.setPrice(rs.getInt("price"));
                bean.setFee(rs.getInt("fee"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return bean;

    } // 점주 가게정보보기

    //*************************************************************************************

    public List<Delivery> dvselect(String dname) {
        List<Delivery> dvselect = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select * from delivery where dname like ? ";

        try {
            conn = super.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + dname + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                Delivery bean = new Delivery();
                bean.setDname(rs.getString("dname"));
                bean.setMenu(rs.getString("menu"));
                bean.setPrice(rs.getInt("price"));
                bean.setFee(rs.getInt("fee"));

                dvselect.add(bean);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
                if (rs != null) {
                    rs.close();
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return dvselect;
    } //주문할 가게찾기

    public List<Delivery> dvselect2(String dname2) {//2차 추가하기

        List<Delivery> bean2 = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select * from delivery where dname like ? ";

        try {
            conn = super.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + dname2 + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                Delivery one = new Delivery();
                one.setDname(rs.getString("dname"));
                one.setMenu(rs.getString("menu"));
                one.setPrice(rs.getInt("price"));
                one.setFee(rs.getInt("fee"));

                bean2.add(one);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
                if (rs != null) {
                    rs.close();
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return bean2;
    } //추가주문할 가게찾기

    public int insetorder(String findid, String dname3,String menu1) {
        Connection conn = null;
        PreparedStatement ps = null;
        int cnt = -1;

        String sql = "INSERT INTO orders (no, oid, odname,  omenu)\n" +
                "VALUES (orderno.nextval, ? , ? , ?)";

        try {
            conn = super.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,findid);
            ps.setString(2,dname3);
            ps.setString(3,menu1);

            cnt = ps.executeUpdate();

            conn.commit();

        }catch (Exception e){
            try {
                conn.rollback();
            }catch (Exception ex){
                e.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try{
                if (ps != null){ps.close();}
                if (conn != null){conn.close();}

            }catch (Exception ex){
                ex.printStackTrace();
            }
        }

        return cnt;
    } // 주문넣기

    public List<Delivery> deletdname(String deletdname) {

        List<Delivery> bean3 = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;


        String sql = "select * from delivery where dname like ? ";

        try {
            conn = super.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + deletdname + "%");
            rs = ps.executeQuery();


            while (rs.next()) {
                Delivery bean = new Delivery();
                bean.setDname(rs.getString("dname"));
                bean.setMenu(rs.getString("menu"));
                bean.setPrice(rs.getInt("price"));
                bean.setFee(rs.getInt("fee"));

                bean3.add(bean);
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
                if (rs != null) {
                    rs.close();
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return bean3;
    } //주문할 목록 삭제하기


    public Person coupon(String findid) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Person bean = new Person();

        String sql = "select coupon from person where id = ?";

        try {
            conn = super.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, findid);
            rs = ps.executeQuery();

            if (rs.next()) {
                bean.setCoupon(rs.getInt("coupon"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return bean;

    } // 총 주문금액 및 쿠폰사용 결제금액 보기
}
