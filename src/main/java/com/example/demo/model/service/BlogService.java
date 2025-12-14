package com.example.demo.model.service;

import com.example.demo.model.domain.Board;
import com.example.demo.model.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final BoardRepository boardRepository;

    public Page<Board> findAll(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }

    public Page<Board> searchByKeyword(String keyword, Pageable pageable) {
        return boardRepository.findByTitleContainingIgnoreCase(keyword, pageable);
    }

    public Board save(AddArticleRequest request) {
        return boardRepository.save(request.toEntity());
    }

    public Optional<Board> findById(Long id) {
        return boardRepository.findById(id);
    }

    @Transactional
    public Board update(Long id, AddArticleRequest request) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found : " + id));

        board.update(request.getTitle(), request.getContent());

        return board;
    }
}