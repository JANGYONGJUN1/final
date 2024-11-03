package com.yj.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yj.dto.BoardDto;
import com.yj.service.BoardService;

@Controller
public class HomeController {
	@Autowired
	BoardService bSvc;
	
	@RequestMapping("/하핳 오태시기~ 꼭.. 그렇게 했어야만 후련했냐..!!!! ")
	public String home() {

		return "home";
	}

	@RequestMapping("/board/list")
	public String list(Integer page, Model model) {
		int pageNum = 1;  // �쁽�젣�럹�씠吏� : 珥덇린媛�1
		if(page != null) {
			pageNum = page;
		}
		
		int startNum, endNum;
		int lastPageNum = bSvc.getLastPageNumber();
		ArrayList<BoardDto> listBoard = bSvc.getList(pageNum);
		
		startNum = (pageNum/5*5+1) - (pageNum%5==0 ? 5 : 0);
		endNum = startNum + 4;
		if(endNum > lastPageNum) {
			endNum = lastPageNum;
		}
		
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("startNum", startNum);
		model.addAttribute("endNum", endNum);
		model.addAttribute("lastPageNum", lastPageNum);
		model.addAttribute("listBoard",listBoard);
		return "Board_list";
	}
	
	@RequestMapping("/board/detail")
	public String detail(Integer bno, Model model) {
		System.out.println("�뱾�뼱�샂");
		
		BoardDto dto = bSvc.getBoardDetail(bno);
			model.addAttribute("bno",bno);
			model.addAttribute("dto", dto);
		
		return "Board_detail";
	}
	
	//寃뚯떆湲� �옉�꽦�뤌
	@RequestMapping("/board/write/form")
	public String insertForm() {
		return "Board_write";
	}
	
	// 寃뚯떆湲� �옉�꽦
	@RequestMapping("/board/write")	
	public String insert(BoardDto dto) {
//		BoardDto dto = new BoardDto(0,title,content,writer,"2024-04-04");
		bSvc.boardWrite(dto);
		return "redirect:/board/list";
	}
	
	@RequestMapping("/board/update/form")
	public String updateForm(int bno, Model model) {
		BoardDto dto = bSvc.getBoardDetail(bno);
		model.addAttribute("dto", dto);
		return "Board_update";
	}
	
	@RequestMapping("/board/update")
	public String update(BoardDto dto, Model model) {
		bSvc.boardUpdate(dto);
		
		return "redirect:/board/list";
	}
	
	@RequestMapping("/board/delete")
	public String delete(Integer bno) {
		bSvc.boardDelete(bno);
		
		return "redirect:/board/list";
	}
	
}
