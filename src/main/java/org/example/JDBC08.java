package org.example;

import org.example.model.Book;
import org.example.model.BookDAO;

import java.util.List;

public class JDBC08 {
    public static void main(String[] args) {
        //수정기능
        //클라이언트로부터 넘어온 데이터(폼파라미터)
        int num = 5;
        String company = "대림출판사";
        String name = "나길동";
        int price = 42000;
        //묶어서(VO, DTO) -> DAO
        //어려운 작업은 아니지만, 굳이?싶은 작업이긴 하다
        //스프링에서는 파라미터 수집이 자동으로 진행된다.
        //파라미터이름과, Book의 멤버변수 이름이 같으면 자동으로 진행됨(스프링)
        Book book = new Book();
        book.setNum(num);
        book.setCompany(company);
        book.setName(name);
        book.setPrice(price);
        BookDAO dao = new BookDAO();
        int cnt = dao.bookUpdate(book);
        if(cnt > 0){
            System.out.println("수정성공");
            List<Book> list = dao.bookList();
            for(Book vo : list){
                System.out.println(vo);
            }
        } else {
            System.out.println("수정실패");
        }

    }
}
