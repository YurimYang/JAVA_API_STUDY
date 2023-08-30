package org.example.model;

//DAO(Class) -> Mapper(Interface) : Mybatis -> Repository(Interface) : JPA

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO implements BookRepository{ //이후에는 DAO는 Interface로 변한 뒤, extends로 불러옴
    private Connection conn;
    private Statement st;
    private PreparedStatement ps; //SQL 문장에 파라미터가 있는 경우에 사용
    /**
     * 속도를 빠르게 하기 위함
     * ?로 params를 대체해놓기 위함
     */

    private ResultSet rs;

    public void getConnection(){
        String url = "jdbc:mysql://localhost:601/fcampus";//접속 프로토콜 (데이터베이스의 포트번호)
        String username = "root";
        String password = "root";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**저장기능**/
    public int bookRegister(Book book){
        String SQL="insert into tblbook(title,company,name,price) values(?,?,?,?)";
        getConnection();
        int cnt = 1;
        try{
            ps=conn.prepareStatement(SQL); //SQL을 미리 컴파일 시켜서 받는다.
            //미완성된 SQL을 완성시킴
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getCompany());
            ps.setString(3, book.getName());
            ps.setInt(4, book.getPrice());
            cnt = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbClose();
        }
        return cnt;
    }
    /**가져오기기능**/
    public List<Book> bookList(){
        String SQL = "select * from tblbook";
        getConnection();
        List<Book> books = new ArrayList<>();
        int cnt = 1;
        try{
            ps=conn.prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next()){ //next하면 커서가 이동하면서 t/f를 반환해줌
                int num = rs.getInt("num");
                String title = rs.getString("title");
                String company = rs.getString("company");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                //묶고(VO) -> 담고 (List)
                Book book = new Book(num, title, company, name,price);
                books.add(book);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbClose();
        }
        return books;
    }

    /**update기능**/
    public int bookUpdate(Book vo){
        String SQL = "update tblbook set title = ?, name=?, price=? where num=?";
        int cnt = -1;
        getConnection();
        try{
            ps = conn.prepareStatement(SQL);
            ps.setString(1, vo.getTitle());
            ps.setString(2, vo.getName());
            ps.setInt(3, vo.getPrice());
            ps.setInt(4, vo.getNum());
            cnt = ps.executeUpdate(); //1이 넘어옴

        } catch (Exception e) {
            e.printStackTrace();
        }
        return cnt;
    }


    /**특정 레코드 1개만 가져오는 기능 **/
    public Book getByNum(int num){
        Book book = null;
        String SQL = "select * from tblbook where num = ? ";
        getConnection();
        try {
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, num);
            rs = ps.executeQuery();
            if(rs.next()){
                num = rs.getInt("num");
                String title = rs.getString("title");
                String company = rs.getString("company");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                //묶고(VO) -> 담고 (List)
                book = new Book(num, title, company, name,price);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }



    /**close기능**/
    public void dbClose(){
        try {
            if(rs != null){
                rs.close();
            }
            if(ps != null){
                ps.close();
            }
            if(conn != null){
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public int bookDelete(int num) {
        String SQL = "delete * from tblbook";

        return 0;
    }

    @Override
    public List<Book> getLikeBooks(String search) {
        String SQL = "select * from tblbook where title like ?";
        getConnection();
        List<Book> books = new ArrayList<>();
        int cnt = 1;
        try{
            ps=conn.prepareStatement(SQL);
            ps.setString(1,"%"+search+"%");//1번째 물음표에 search가 들어간다. '%search%'꼴로 들어가야함
            rs = ps.executeQuery();
            while(rs.next()){ //next하면 커서가 이동하면서 t/f를 반환해줌
                int num = rs.getInt("num");
                String title = rs.getString("title");
                String company = rs.getString("company");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                //묶고(VO) -> 담고 (List)
                Book book = new Book(num, title, company, name,price);
                books.add(book);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbClose();
        }
        return books;
    }
}
