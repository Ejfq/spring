package com.yedam.app.board.service;

import java.util.List;
import java.util.Map;

public interface BoardService {
	// 전체 게시판정보 조회
	public List<BoardVO> boardList();
	
	//게시판정보 조회
	public BoardVO boardInfo(BoardVO boardVO);
	
	//게시판정보 등록
	public int boardInsert(BoardVO boardVO);
	
	//게시판정보 수정
	public Map<String, Object> boardUpdate(BoardVO boardVO);
	
	//게시판정보 삭제
	public Map<String, Object> boardDelete(BoardVO boardVO);
}
