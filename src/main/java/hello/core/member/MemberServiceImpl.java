package hello.core.member;

public class MemberServiceImpl implements MemberService {
     private final MemberRepository memberRepository; //MemberRepository에 대한 직접적인 코드가 없으므로 DIP 위반 제거
    public MemberServiceImpl(MemberRepository memberRepository) { //다형성에 의해서 들어오기 떄문에 어떤 구현체가 올지 모른다 OCP 개방 폐쇠 원칙 지킴
        this.memberRepository = memberRepository;
    }
    //의존관계 역전 원칙 위반
    @Override
    public void join(Member member) {
            memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberID) {
        return memberRepository.findById(memberID);
    }
}
