package org.example;

import java.sql.*;

/**DB 데이터 업데이트 하기**/
public class JDBC02 {
    public static void main(String[] args) {
        //별도의 클래스로 만들어서 하기
        String url = "jdbc:mysql://localhost:601/fcampus";//접속 프로토콜 (데이터베이스의 포트번호)
        String username = "root";
        String password = "root";
        //DAO (Data Access Object)
        int num = 1;
        String name = "박매일";
        int price = 50000;
        //JDBC -> Mybatis -> ORM(Hibernate) -> JPA

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url,username,password);

            //수정 : num이 1인 책의 저자와 가격을 수정하시오.(Update SQL문장)
            String SQL = "update tblbook set name = '"+name+"', price = "+price+" where num =" +num;

            Statement st = conn.createStatement();
            int cnt = st.executeUpdate(SQL);
            if(cnt > 0) {
                System.out.println("업뎃성공");
            } else {
                System.out.println("업뎃실패");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
