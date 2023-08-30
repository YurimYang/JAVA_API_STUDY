package org.example;

import org.example.model.Book;
import org.example.model.BookDAO;

public class JDBC09 {
    public static void main(String[] args) {
        //특정 레코드 1개만 검색
        int num = 1; //(num에 해당하는 책1권만 db에서 검색해서 가져오기)
        BookDAO dao = new BookDAO();
        Book book = dao.getByNum(num);
        if(book!=null){
            System.out.println(book);
        }else{
            System.out.println("검색실패");
        }
    }
}
