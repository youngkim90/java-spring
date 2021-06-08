package hello.core.singleton;

//싱글톤 패턴 사용시 주의할 점
public class StatefulService {

//    private int price; //상태를 유지하는 필드

    int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
//        this.price = price; //여기가 문제!
        return price;
    }

//    int getPrice() {
////        return price;
//    }

}
