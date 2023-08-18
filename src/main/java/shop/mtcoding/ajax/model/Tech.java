package shop.mtcoding.ajax.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Table(name = "tech_tb")
@Getter
@Setter
public class Tech { // 기술자별 스택 종류 테이블

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private String name; // Spring, Java, Javascript, React, HTML 등

    // @JsonIgnore << Json 직렬화를 막아서 Lazy로딩하지 않을수있다.
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;
}
