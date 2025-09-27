package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Member;

//Spring Container를 쓰면 기본적으로 객체를 싱글톤으로 만들어서 관리해줌
//DI Container //Bean 등록 방법 팩토리 빈을 통하여 등록하는 방식임.
@Configuration
public class AppConfig { //기획자 같은 역할 동작 전체 구성 책임
    //생성자 주입 //역학을 세우고 구현이 들어가는 설계

    //call AppConfig.memberService
    //call AppConfig.memberRepository
    //call AppConfig.memberRepository
    //call AppConfig.orderService
    //call AppConfig.memberRepository


    /*call AppConfig.memberService
    call AppConfig.memberRepository
    call AppConfig.orderService*/

    @Bean

    public MemberService memberService() { // key : memberService, value : MemberServiceImpl 객체 인스턴스로 Container에 등록
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() { //중복제거 하기 위해서 따로 추출
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        //return new OrderServiceImpl(memberRepository(), discountPolicy());
        return null;
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
