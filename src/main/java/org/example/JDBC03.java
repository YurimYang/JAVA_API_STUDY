package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**DB 데이터 삭제하기**/
public class JDBC03 {
    public static void main(String[] args) {
        //별도의 클래스로 만들어서 하기
        String url = "jdbc:mysql://localhost:601/fcampus";//접속 프로토콜 (데이터베이스의 포트번호)
        String username = "root";
        String password = "root";
        //DAO (Data Access Object)
        int num = 4;


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url,username,password);

            //수정 : num이 1인 책의 저자와 가격을 수정하시오.(Update SQL문장)
            String SQL = "delete from tblbook where num =" + num;

            Statement st = conn.createStatement();
            int cnt = st.executeUpdate(SQL);
            if(cnt > 0) {
                System.out.println("삭제성공:" + cnt);
            } else {
                System.out.println("삭제실패");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
