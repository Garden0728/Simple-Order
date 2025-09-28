package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

     private final MemberRepository memberRepository ;
     private final DiscountPolicy discountPolicy;

/*    @Autowired(required = false)
    public void setMemberRepository(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @Autowired
    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }*/
/*    @Autowired
    public void init(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }*/

/*     @Autowired
     public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
         this.memberRepository = memberRepository;
         this.discountPolicy = discountPolicy;
    }*/
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); /추상에도 의존을 헸지만 구현체에도 의존을 했으므로 DIP 위반
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();// 위에 상황으로 정책이 변경되는순간 OrderServiceImpl OCP 위반
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice); //할인정책을 분리해서 단일책임원칙을 잘 지킴
        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
    //테스트용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
