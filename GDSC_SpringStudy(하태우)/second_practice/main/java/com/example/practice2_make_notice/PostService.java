package com.example.practice2_make_notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    public  PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    // 게시물 저장
    public void savePost(Post post) {
        postRepository.save(post);
    }

    // 게시물 조회
    public List<Post> getPostsByAuthor(User author) {
        return postRepository.findByAuthor(author);
    }

    // 게시물 삭제
    public void hardDeletePost(Long postId) {
        postRepository.deleteById(postId);
    }

    @Transactional
    public  void softDeleteUser(Long postId){
        Post post = postRepository.findById(postId).orElse(null);
        if(post != null){
            post.setDeleted(true);
            postRepository.save(post);
        }
    }

    // 특정 게시판의 모든 게시물 조회
    public List<Post> getPostsByBoard(Board board) {
        return postRepository.findByBoard(board);
    }

    // 모든 게시물 조회
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }
}

