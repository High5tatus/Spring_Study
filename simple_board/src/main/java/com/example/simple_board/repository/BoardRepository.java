package com.example.simple_board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.simple_board.model.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{

	public List<Board> findByTitleContaining(String title);
}
