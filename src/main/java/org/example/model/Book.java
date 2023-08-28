package org.example.model;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class Book {
    private int num;
    private String title;
    private String company;
    private String name;
    private int price;

    /**
     * @Data
     *      getter&setter
     *      => @Data란 lombok을 사용하면, getter setter 가 자동적으로 생성됨
     *
     * @NoArgsConstructor
     *      public Book(){}
     *
     * @AllArgsConstructor
     *      public Book(String title, String company, String name, int price){
     *         this.title = title;
     *         this.company = company;
     *         this.name = name;
     *         this.price = price;
     *     }
     */


}
