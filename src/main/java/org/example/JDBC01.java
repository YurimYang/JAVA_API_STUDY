package org.example;
//JDBC Programming
import java.net.URLConnection;
import java.sql.*;//interface가 많이 담겨있다 (규약) ---> Driver


/**DB 데이터 추가하기 **/
public class JDBC01 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //1.JDBC Driver 설치 (API)
        Statement st = null;
        Connection con = null;
        try{
            //2. 접속 URL (http://www.naver.com (:80 웹서버 포트 80은 주로 생략)
            String url = "jdbc:mysql://localhost:601/fcampus";//접속 프로토콜 (데이터베이스의 포트번호)
            String username = "root";
            String password = "root";

            String title = "C언어";
            String company = "이지스퍼브리싱";
            String name = "김길동";
            int price = 2100;

            //3. 드라이버 로딩(mysql 드라이버 클래스를 메모리에 로딩) : 객체생성
            //정적로딩 (컴파일할 때 어떤 드라이버 클래스를 쓸지 정함) -> 하지만, 이젠, 동적로딩을 함
            // DriverManager driver = new com.mysql.cj.jdbc.Driver();
            //동적로딩 -> 컴파일 당시에는 문자열로 인식하고 이후에 Driver에 넣어짐

            Class.forName("com.mysql.cj.jdbc.Driver");
            //└ 자바에서 제공해주는 DriverManger과 연동된다.
            //연결객체를 생성해야한다.
            con = DriverManager.getConnection(url,username,password);
            System.out.println("연결성공");
            //2. SQL 문장 만들기(변수->"+변수+"로 분리해야함)
            String SQL = "insert into tblbook(title,company,name,price) values('"+title+"','"+company+"','"+name+"',"+price+")";
//        String SQL = "insert into tblbook(title,company,name,price) values('title','company','name+',price)";
            //3. SQL 문장을 정송객체를 생성
            st = con.createStatement();
            int cnt = st.executeUpdate(SQL);
            if(cnt > 0) {
                System.out.println("입력성공");
            } else {
                System.out.println("입력실패");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally { //catch 에서 오류를 출력한뒤, finally 구문이 사용됨
            //예외와 상관없이 무조건 실행되는 block
            //주로, rs(ResultSet), st, conn의 close를 담당
            try{
                st.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
