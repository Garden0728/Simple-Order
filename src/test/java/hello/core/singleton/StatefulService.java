package hello.core.singleton;

public class StatefulService {
   // private int price; //상태를 유지하는 필드
   //싱글톤에서 특정 클라이언트가 값을 변경 할 수 있는 필드가 있어선 안된다. 필드 대신에 자바에서 공유되지 않는, 지역변수, 파라미터, ThreadLocal 등을 사용해야 한다
    public int order(String name,int price){
        System.out.println("name = " + name+", price = " + price);
        return price; //여기가 문제!
    }
/*    public int getPrice() {
        return price;
    }*/

}
