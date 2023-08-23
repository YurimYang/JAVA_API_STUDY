package org.example;

import com.google.gson.Gson;
import org.example.model.Book;
import org.example.model.BookList;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class API04 {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<Book>();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("책제목 : (exit를 입력시, 종료)");
            String title = sc.nextLine();
            if(title.equals("exit")) break;

            System.out.print("출판사 : ");
            String company = sc.nextLine();

            System.out.print("저자 : ");
            String name = sc.nextLine();

            System.out.print("가격 : ");
            int price = Integer.parseInt(sc.nextLine());

            //VO에 묶고, LIST에 담기
            Book book = new Book(title,company, name, price); //@AllArgsConstructor때문에 생성자 존재
            books.add(book);
        }
        sc.close();

        BookList bookList = new BookList(books);

        Gson gson = new Gson();
        String json = gson.toJson(bookList);
        System.out.println(json);
        //ctrl + alt + shift + L : JSON 정렬

        try{
            FileWriter fw = new FileWriter("books2.json") ;
            fw.write(json);
            fw.close();
            System.out.println("books2.json 파일 생성");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
