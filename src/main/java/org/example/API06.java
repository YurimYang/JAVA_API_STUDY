package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;


public class API06 {
    public static void main(String[] args) {
        //특정 서버에 있는 자원을 네트워킹을 이용해서 획득하기(크롤링)
        String url = "https://sum.su.or.kr:8888/bible/today";
        //요청(request) ---> 응답(response) : HTML(tag) API
        //get, post
        //Jsoup API(Connection + Parsing)
        //└ HTML 파싱 JAVA 라이브러리 (데이터 추출하고 조작)
        //Class 이름(css)과 id(class의 고유한값)을 통해 데이터를 찾아갈 수 있음


        try {
            Document docs = Jsoup.connect(url).get();
            //System.out.println(docs.toString());
            Element dailybible_info = docs.selectFirst("div.dailybible_info");//div 중에서 bible_text를 찾아가고 싶다.
            Element bible_text = docs.selectFirst("div.bible_text");//div 중에서 bible_text를 찾아가고 싶다.
            Element bibleinfo_box = docs.selectFirst("div.bibleinfo_box");//div 중에서 bible_text를 찾아가고 싶다.

            //System.out.println(dailybible_info.text());
            //System.out.println(bible_text.text());
            //System.out.println(bibleinfo_box.text());

            Elements body_list = docs.select("ul.body_list > li");

            for(Element list : body_list){
                System.out.println(list.select(".num").text()+":");
                System.out.println(list.select(".info").text());
            }
            /**
             * <ul class="body_list" id="body_list">
             *   <li> (= ul.book_list > li)
             *     <div class="num">
             */


            /**
             * element
             * <div class="bible_text" id="bible_text">
             *    무화과 두 광주리 (=element.text())
             * </div>
             */
//            if(element!=null){
//                System.out.println(element.text()); //element 내부에 있는 text값을 꺼내오기
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
