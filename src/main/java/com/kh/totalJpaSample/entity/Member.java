package com.kh.totalJpaSample.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "member")
@Getter @Setter @ToString
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // AUTO => 스프링부트에서 생성전략 관여(유리) / IDENTITY => DB에 있는 생성전략
    @Column(name ="member_id")
    private Long id; // 생성하는게 관례

    private String userId;

    @Column(nullable = false) // NULL을 허용하지 않음
    private String name;
    private String password;
    @Column(unique = true) // 유일한 값이어야 함
    private String email;
    private LocalDateTime regDate;
    @PrePersist
    public void prePersist() {
        regDate = LocalDateTime.now();
    }
}
