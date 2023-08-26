package org.example;

//이 클래스는 Thread라는 객체가 작동을 하는 클래스이다. = implements Runnable
public class AlphaData implements Runnable{
    //pulbic class AlphaData extends Thread
    @Override //Thread가 해야하는 단위 작업 클래스
    public void run() {
        for(char j = 'A'; j<= 'Z'; j++){
            System.out.print(j);
        }
    }
}
