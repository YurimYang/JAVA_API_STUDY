package org.example;

import org.example.model.BookDAO;
import org.example.model.BookRepository;

public class JDBC10 {
    public static void main(String[] args) {
        int num = 5;
        BookRepository repository = new BookDAO();
        int cnt = repository.bookDelete(num);
        if (cnt > 0) {
            System.out.println("삭제성공");
        } else {
            System.out.println("삭제실패");
        }
    }
}
