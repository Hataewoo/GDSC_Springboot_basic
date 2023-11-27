package com.example.practice2_make_notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public  BoardService(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

    // 게시판 저장
    public void saveBoard(Board board) {
        boardRepository.save(board);
    }

    // 게시판 조회
    public Board findBoardByName(String name) {
        return boardRepository.findByName(name);
    }

    // 게시판 삭제
    public void hardDeleteBoard(Long boardId) {
        boardRepository.deleteById(boardId);
    }

    @Transactional
    public void softDeleteUser(Long boardId){
        Board board = boardRepository.findById(boardId).orElse(null);
        if(board != null){
            board.setDeleted(true);
            boardRepository.save(board);
        }
    }

    // 모든 게시판 조회
    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }
}

