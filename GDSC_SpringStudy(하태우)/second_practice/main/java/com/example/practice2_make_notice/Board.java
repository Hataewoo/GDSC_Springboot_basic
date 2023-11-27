package com.example.practice2_make_notice;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

//기본 생성자를 만들어 줍니다.
//@NoAtrgsConstructor(access = AccessLevel.PROTECTED)
//@Builder //선언한 클래스의 빌더 패턴을 가지는 클래스를 생성합니다.
//@AllArgsContructor //???
@Entity //Board라는 객체와 DB 테이블을 매핑합니다. JPA가 관리합니다.
@Getter //모든 변수에 대해 getter 생성
public class Board {
    @Id //해당 변수가 PK가 됩니다.
    //값이 없어도 자동으로 할당 합니다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private LocalDateTime createdAt;

    private  boolean deleted = false;
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    // Getters and setters
}
