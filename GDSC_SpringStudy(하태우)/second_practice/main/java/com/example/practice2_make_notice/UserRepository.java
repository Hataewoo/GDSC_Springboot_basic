package com.example.practice2_make_notice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // 사용자 아이디로 사용자 찾기
    User findByUsername(String username);
}
