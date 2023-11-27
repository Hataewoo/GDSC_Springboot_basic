package com.example.practice2_make_notice;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private LocalDateTime createdAt;

    private  boolean deleted = false;

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    // 관계 매핑
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    // Getters and setters
}

