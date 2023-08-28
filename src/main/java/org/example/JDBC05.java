package org.example;

import org.example.model.Book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**DB 데이터 가져오기 ver 2**/
public class JDBC05 {
    public static void main(String[] args) {
        //별도의 클래스로 만들어서 하기
        String url = "jdbc:mysql://localhost:601/fcampus";//접속 프로토콜 (데이터베이스의 포트번호)
        String username = "root";
        String password = "root";
        //num이 1인 책 한권(VO 개념) 출력하세요.
        String SQL = "select * from tblbook where num = 1";
        List<Book> blist = new ArrayList<>();
        Book book = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url,username,password);
            Statement st = conn.createStatement();

            //st.execteUpdate(SQL) : insert, update, delete
            ResultSet rs = st.executeQuery(SQL);
            if(rs.next()){ //next하면 커서가 이동하면서 t/f를 반환해줌
                int num = rs.getInt("num");
                String title = rs.getString("title");
                String company = rs.getString("company");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                //묶고(VO) -> 담고 (List)
                book = new Book(num, title, company, name,price);
            }

            if(book != null){
                System.out.println(book);
            } else {
                System.out.println("데이터가 없습니다.");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
