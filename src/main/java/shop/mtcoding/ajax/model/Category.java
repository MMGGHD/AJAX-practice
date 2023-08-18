package shop.mtcoding.ajax.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// DB에서 조회시 영속화를 위해 PC에 Category객체가 만들어 져야함
// 이때 new() 를 하기 떄문에 빈 생성자가 없으면 터진다.
@NoArgsConstructor
@Entity
@Table(name = "category_tb")
@Getter
@Setter
public class Category { // 기술자들 카테고리 테이블

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private String name; // 백엔드, 프론트엔드, DBA 카테고리 3가지 종류

    @Builder
    public Category(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
