package com.example.practice2_make_notice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
    // 게시판 이름으로 게시판 찾기
    Board findByName(String name);
}

