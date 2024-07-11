package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Delivery {

    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING) //EnumType.STRING -> 이거 꼭 사용하자, 기본값은 ODINAL?인데 이건 숫자로 enum 매핑해줌. 중간에 값 들어오면 망함
    private DeliveryStatus status; //READY, CAMP
}
