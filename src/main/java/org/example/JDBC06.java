package org.example;

import org.example.model.Book;
import org.example.model.BookDAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JDBC06 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //키보드로부터 책 데이터를 받아서 DB에 저장하시오.
        String title = br.readLine();
        String company = br.readLine();
        String name = br.readLine();
        int price = Integer.parseInt(br.readLine());

        Book book = new Book();
        book.setTitle(title);
        book.setCompany(company);
        book.setName(name);
        book.setPrice(price);

        //DAO객체
        BookDAO dao = new BookDAO();
        int cnt = dao.bookRegister(book);
        if (cnt > 0) {
            System.out.println("저장성공");
        } else {
            System.out.println("저장실패");
        }


    }
}
