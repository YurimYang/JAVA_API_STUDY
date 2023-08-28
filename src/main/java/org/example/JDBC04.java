package org.example;

import org.example.model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**DB 데이터 가져오기**/
public class JDBC04 {
    public static void main(String[] args) {
        //별도의 클래스로 만들어서 하기
        String url = "jdbc:mysql://localhost:601/fcampus";//접속 프로토콜 (데이터베이스의 포트번호)
        String username = "root";
        String password = "root";
        String SQL = "select * from tblbook";
        //책 전체 리스트를 출력하세요(List<Book>)
        List<Book> blist = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url,username,password);
            Statement st = conn.createStatement();

            //st.execteUpdate(SQL) : insert, update, delete
            ResultSet rs = st.executeQuery(SQL);
            while(rs.next()){ //next하면 커서가 이동하면서 t/f를 반환해줌
                int num = rs.getInt("num");
                String title = rs.getString("title");
                String company = rs.getString("company");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                //묶고(VO) -> 담고 (List)
                Book book = new Book(num, title, company, name,price);
                blist.add(book);
            }

            for(Book book : blist){
                System.out.println(book);
                System.out.println(book.getNum());
                System.out.println(book.getTitle());
                System.out.println(book.getCompany());
                System.out.println(book.getName());
                System.out.println(book.getPrice());
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
