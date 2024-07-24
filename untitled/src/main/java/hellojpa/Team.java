package hellojpa;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {

    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;
    private String name;

    /*
     * mappedBy를 쓰는 이유 -> 객체에선 양방향 연관관계를 단방향 연관관계 2개로 표현해야함 (테이블에서는 fk 하나로 양방향 연관관계를 표현 가능)
     * 그래서 mappedBy로 연관관계를 표현 하는 것
     * 둘 중의 하나를 <연관관계의 주인>으로.. mappedBy가 있는 쪽은 주인이 아니다(읽기만 가능)
     * 다쪽이 연관관계의 주인으로 하자
     * */
    @OneToMany(mappedBy = "team") //team과 연결되어있다
    private List<Member> members = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}
