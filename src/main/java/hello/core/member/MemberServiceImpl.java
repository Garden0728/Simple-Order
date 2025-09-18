package hello.core.member;

public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository = new MemoryMemberRepository(); //의존관계 역전 원칙 위반
    @Override
    public void join(Member member) {
            memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberID) {
        return memberRepository.findById(memberID);
    }
}
