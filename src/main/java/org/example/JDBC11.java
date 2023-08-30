package org.example;

import org.example.model.Book;
import org.example.model.BookDAO;
import org.example.model.BookRepository;

import java.util.List;

public class JDBC11 {
    public static void main(String[] args) {
        String search = "자바";
        BookRepository repository = new BookDAO();
        List<Book> blist = repository.getLikeBooks(search);
        if(blist.size()!=0){
            for(Book book : blist){
                System.out.println(book);
            }
        } else {
            System.out.println("존재하지 않습니다.");
        }
    }
}
