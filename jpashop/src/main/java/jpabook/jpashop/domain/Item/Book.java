package jpabook.jpashop.domain.Item;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("B") //싱글 테이블이기 때문에 구분할 수 있는 게 필요함
@Getter @Setter
public class Book extends Item {

    private String author;
    private String isbn;
}
