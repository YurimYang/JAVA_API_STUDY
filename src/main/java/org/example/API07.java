package org.example;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.client.HttpClient;

//JVM -> main Thread
public class API07 {
    public static void main(String[] args) {
        String imageUrl = "https://sum.su.or.kr:8888/Themes/main/images/sub/audio_defaultimg.jpg";
        String imageName = "audio_defaultimg.jpg";
        HttpClient httpClient = HttpClients.createDefault();

        //이미지 다운로드 -> 별도의 Thread를 만들어서 처리
//        DownloadBroker db = new DownloadBroker(imageUrl,imageName,httpClient);
//        db.start();


        //1. 스레드가 해야할 일을 만들어 놓았다.
        Runnable job = new DownloadBroker(imageUrl, imageName, httpClient);

        //2. 알바생을 채용해야한다.
        Thread t1 = new Thread(job);

        //3. 일을 시작한다.
        t1.start();


        //main Thread !!
        System.out.println("main Thread 종료");
    }
}
