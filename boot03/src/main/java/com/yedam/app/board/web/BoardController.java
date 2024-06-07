package com.yedam.app.board.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	// 전체조회 : URI -boardList / RETURN -board/boardList
	@GetMapping("boardList")
	public String boardList(Model model) {
		List<BoardVO> list = boardService.boardList();
		
		model.addAttribute("boardList" , list);
		
		return "board/boardList";
		//classpath:/templates/ + board/boardList + .html
	}
	
	// 단건조회 : URI - boardInfo / PARAMETER - BoardVO(QueryString)
	//		  RETURN - board/boardInfo
	@GetMapping("boardInfo")
	public String boardInfo(BoardVO boardVO, Model model) {
		BoardVO bVO = boardService.boardInfo(boardVO);
		
		model.addAttribute("board", bVO);
		
		return "board/boardInfo";
	}
	
	// 등록 - 페이지 : URI - boardInsert / RETURn - board/boardInsert
	@GetMapping("boardInsert")
	public String boardInsertForm() { //일반적인 <form/>활용 => Submit 을 통한 통신은 JSON은 못보냄
											// 커맨드객체로 해야함 QueryString, mulipart/

		return "board/boardInsert";
	}
	
	// 등록 - 처리 : URI - boardInsert / PARAMETER - BoardVO(QueryString)
	//			  RETURN - 전체조회 다시 호출
	@PostMapping("boardInsert")
	public String BoardInsertProcess(BoardVO boardVO) {
		int bno = boardService.boardInsert(boardVO);

		return "redirect:boardList" ; //redirect는 GetMapping 들중 하나 재호출 >> body로는 값 전달못해서 postmapping은 안됨
	}
	
	// 수정 - 페이지 : URI - boardUpdate / PARAMETER - BoardVO(QueryString)
	//             RETURN - board/boardUpdate
	@GetMapping("boardUpdate")
	public String boardUpdateForm(Integer bno, Model model) {
		BoardVO boardVO = new BoardVO();
		boardVO.setBno(bno);
		
		BoardVO findVO = boardService.boardInfo(boardVO);
		model.addAttribute("boardInfo", findVO);
		return "board/boardUpdate";
	}
	
	// 수정 - 처리 : URI - boardUpdate /  PARAMETER - BoardVO(JSON)
	//			  RETRUN - 수정결과 데이터 (MAP)
	@PostMapping("boardUpdate")	
	@ResponseBody
	public Map<String, Object> boardUpdate(@RequestBody BoardVO boardVO) {
		return boardService.boardUpdate(boardVO);
	}
	
	// 삭제 - 페이지 : URI - boardDelete / PARAMETER - Integer
	//			  RETURN - 전체조회 다시 호출
	
	@GetMapping("boardDelete")
	public String boardDelete(BoardVO boardVO) {
		boardService.boardDelete(boardVO);
		return "board/boardList";
	}
	
	
}
