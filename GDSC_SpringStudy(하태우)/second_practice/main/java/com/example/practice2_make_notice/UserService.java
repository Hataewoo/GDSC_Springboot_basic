package com.example.practice2_make_notice;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public  UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    // 사용자 저장
    public void saveUser(User user) {
        userRepository.save(user);
    }

    // 사용자 조회
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // 사용자 삭제
    public void hardDeleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Transactional//실패시 롤백해주는 어노테이션
    public  void softDeleteUser(Long userId){
        User user = userRepository.findById(userId).orElse(null);
        if(user != null){
            user.setDeleted(true);
            userRepository.save(user);
        }
    }

    // 사용자 목록 조회
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}

