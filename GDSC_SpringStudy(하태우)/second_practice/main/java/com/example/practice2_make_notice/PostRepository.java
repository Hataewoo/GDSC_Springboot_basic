package com.example.practice2_make_notice;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    // 게시물 작성자로 게시물 찾기
    List<Post> findByAuthor(User author);

    // 게시판으로 게시물 찾기
    List<Post> findByBoard(Board board);
}

