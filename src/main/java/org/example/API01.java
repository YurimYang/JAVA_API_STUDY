package org.example;

import org.example.model.Book;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class API01 {
    public static void main(String[] args) {
        List<Book> list = new ArrayList<Book>();
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
            list.add(book);
        }
        sc.close(); //읽는 과정이 끝났으므로 scanner는 닫아준다.
        //List -> JSONArray <- JSONObject({    })
        //JSON API를 쓸 수 있어야함 ! > org.json dependency 주입


        JSONArray booksArray = new JSONArray();
        for(Book book : list){
            JSONObject booksObject = new JSONObject();
            booksObject.put("title", book.getTitle());
            booksObject.put("company", book.getCompany());
            booksObject.put("name", book.getName());
            booksObject.put("price", book.getPrice());
            booksArray.put(booksObject);
//            {"title" : "C언어", "company" : "영진출판사", "name" : "양유림", "price" : 35000},
//            {"title" : "JAVA", "company" : "성현출판사", "name" : "배성현", "price" : 24000},
//            {"title" : "스프링", "company" : "체리출판사", "name" : "김체리", "price" : 54000},
        }
        JSONObject root = new JSONObject();
        root.put("books", booksArray);
//        {"books" : [
//            {"title" : "C언어", "company" : "영진출판사", "name" : "양유림", "price" : 35000},
//            {"title" : "JAVA", "company" : "성현출판사", "name" : "배성현", "price" : 24000},
//            {"title" : "스프링", "company" : "체리출판사", "name" : "김체리", "price" : 54000},
//    ] }

        try {
            FileWriter fw = new FileWriter("books.json");
            fw.write(root.toString(4));
            fw.close();
            System.out.println("생성완료!");

        } catch (Exception e){
            e.printStackTrace();
        }


    }

}
/*
    <객체(Object)를 문자열의 형태(=text) 로 표현하는 방법>
    └ 네트워크를 통해서 보내기가 쉬워짐
    = 책 : VO,DTO - classes
    = 책 : 문자열의 형태로 표현 (json or xml)
        C언어,영진출판사,양유림,35000 -> 이런식으로 데이터를 정리하면
        네트워크를 통해 보내기가 어려워짐 => json형태로 만들어서 보내기 !!

 */
