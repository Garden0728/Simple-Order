package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

//찾는 패키지를 지정 하지 않으면 package hello.core; 이 클래스의 패키지부터 하위 패키지 까지 다 찾는다. 그러므로 제일 좋은 방법은 설정 정보 config 클래스를 프로젝트 상단에 둘것
//ComponentScan이 @Component가 어노테이션이 붙은 클래스를 스프링 빈으로 등록 시켜줌 그래서 @Configuration또한 @Component가 붙어있기 때문에 자동 등록된다.
@Configuration
@ComponentScan(
        basePackages = "hello.core", //어디서부터 찾는지 지정 가능
        excludeFilters = @ComponentScan.Filter(type =  FilterType.ANNOTATION, classes = Configuration.class) //ComponentScan으로 Spring Bean을 등록 해주는데 뺼걸 지정
                                                                                                            // Componentscan을 사용하면 @Configuration 이 붙은 설정 정보도 자동으로 등록하기 때문에 Configuration 제외 시
)
public class AutoAppConfig {

    @Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

}
