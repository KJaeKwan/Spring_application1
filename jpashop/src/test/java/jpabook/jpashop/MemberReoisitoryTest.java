package jpabook.jpashop;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class) //스프링과 관련된 것으로 테스트를 하겠다
@SpringBootTest
public class MemberReoisitoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @Transactional //테스트에 있으면 테스트 끝난 후 롤백
    public void MemberRepositoryTest(){
        //given
        Member member = new Member();
        member.setUsername("memberA");

        //when
        Long saveId = memberReoisitory.save(member);
        Member findMember = memberReoisitory.find(saveId);

        //then
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
        Assertions.assertThat(findMember).isEqualTo(member);
    }
}