package com.kh.totalJpaSample.entity;

import com.kh.totalJpaSample.constant.ItemSellStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Entity // 클래스를 엔티티로 선언
@Table(name="item") // 엔티티와 매핑할 테이블을 지정
public class Item {
    @Id // 테이블의 기본키 지정
    @Column(name="item_id") // 필드와 컬럼을 매핑
    @GeneratedValue(strategy = GenerationType.AUTO) // JPA 자동으로 생성 전략을 결정
    private Long id; // 상품 코드
    
    @Column(nullable = false, length = 50) // null을 허용하지 않고 길이를 50자로 제한
    private String itemName; // 상품명 item_name

    @Column(name ="price", nullable = false)
    private int price; // 가격

    @Column(nullable = false)
    private int stockNumber; // 재고 수량

    @Lob // 문자형 대용량 파일을 저장하는데 사용하는 데이터 타입
    @Column(nullable = false)
    private String itemDetail; //상품 상세 설명

    @Enumerated(EnumType.STRING)// enum으로 정의된 값을 문자열로 DB에 저장/ ORDINAL => 일련번호 저장
    private ItemSellStatus itemSellStatus; // 상품 판매 상태

    private LocalDateTime regTime; // 등록 시간
    private LocalDateTime updateTime; // 수정 시간
}
