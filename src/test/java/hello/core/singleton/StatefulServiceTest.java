package hello.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

//싱글톤 패턴의 주의할 점에 대한 테스트
public class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //ThreadA: A사용자가 10000원 주문
        int userAPrice = statefulService1.order("userA", 10000);
        //ThreadB: B사용자가 20000원 주문
        int userBPrice = statefulService2.order("userB", 20000);
        
        //ThreadA: 사용자A 주문금액 조회
//        int pirce = statefulService1.getPrice();
        System.out.println("pirce = " + userAPrice);
        System.out.println("pirce = " + userBPrice);

    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }

}
