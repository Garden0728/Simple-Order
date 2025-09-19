package hello.core.member;

import hello.core.AppConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;
    @BeforeEach  //테스트 실행하기전에 돌아가는것
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }
    //의존 관계ㅇ
    @Test
    void join(){

        //given 이런 환경이 주어 졌을 때
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when  이렇게 했을 때
        memberService.join(member);

        Member findmember = memberService.findMember(1L);


        //then  이렇게 된다.
        Assertions.assertEquals(member, findmember);
    }
}
