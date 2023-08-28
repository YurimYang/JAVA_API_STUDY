package org.example;

import org.example.model.Book;
import org.example.model.BookDAO;

import java.util.List;

public class JDBC07 {
    public static void main(String[] args) {
        BookDAO dao = new BookDAO();
        List<Book> blist = dao.bookList();
        if(blist.size() != 0){
            for(Book book :blist){
                System.out.println(book);
            }
        } else {
            System.out.println("데이터가 존재하지 않습니다.");
        }
    }
}
