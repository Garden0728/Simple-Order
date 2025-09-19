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

import java.lang.reflect.Member;
//DI Container
public class AppConfig { //기획자 같은 역할 동작 전체 구성 책임
        //생성자 주입 //역학을 세우고 구현이 들어가는 설계
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private static MemberRepository memberRepository() { //중복제거 하기 위해서 따로 추출
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(),discountPolicy());
    }
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
