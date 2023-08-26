package org.example;

public class API08 {
    public static void main(String[] args) throws InterruptedException {
        //현재 수행중인 Thread 객체 얻어오기
        Thread t1 = Thread.currentThread();
        System.out.println(t1.getName());
        //└ main Thread가 기본적으로 만들어져서 Class를 실행시킴
        t1.setPriority(Thread.MAX_PRIORITY); // 10
        System.out.println(t1.getPriority());
        //└ 우선순위가 높을 수록 CPU의 시간을 더 많이 획득해서 사용함



        //(1번 Thread = main) 여기서는 1~100까지의 수를 출력하시오.
        for(int i = 1; i<=100; i++) {
            System.out.print(i);
            Thread.sleep(1000);
        }
        System.out.println();
        //(2번 Thread) A~Z까지 출력을 하세요.
        //1. 작업객체를 만든다(job)
        AlphaData ad = new AlphaData();
        //2. Thread를 만든다.(알바생)
        Thread alpha = new Thread(ad); //Thread와 작업을 연결
        //Thread alpha = new AlphaData(); =>extends Thread로 했을 경우
        //3. Thread를 시작한다
        alpha.start();
        //└ ad에 연결되어있는 클래스를 찾아감(new AlphaData()) -> run 메소드를 실행시킴
        // run()구동 -> ready상태(Queue) -> Running 상태(실행) -> Block(봉쇄) -> dead(소멸)
    }
}
