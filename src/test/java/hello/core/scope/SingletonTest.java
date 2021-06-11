package hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SingletonTest {

    @Test
    void singletonBeanFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBean.class);

        SingletonBean singtonBean1 = ac.getBean(SingletonBean.class);
        SingletonBean singtonBean2 = ac.getBean(SingletonBean.class);
        System.out.println("singtonBean1 = " + singtonBean1);
        System.out.println("singtonBean2 = " + singtonBean2);
        Assertions.assertThat(singtonBean1).isSameAs(singtonBean2);

        ac.close();
    }

    @Scope("singleton")
    static class SingletonBean {
        @PostConstruct
        void init() {
            System.out.println("SingletonBean.init");
        }

        @PreDestroy
        void destroy() {
            System.out.println("SingletonBean.destroy");
        }
    }
}
