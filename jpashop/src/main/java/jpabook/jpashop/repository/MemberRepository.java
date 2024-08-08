package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//스프링 데이터 JPA로 코드량을 줄일 수 있다 - repository의 거의 모든 기능을 주고 구현체를 만들어야 할 경우 이름으로 자동으로 만들어 줌
public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByName(String name);
}
