package com.kh.totalJpaSample.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name ="cart" )
public class Cart {
    @Id
    @Column(name ="cart_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String cartName;

    @OneToOne // 회원 엔티티와 일대일 매핑
    @JoinColumn(name = "member_id")
    private Member member;
}
