package com.yj.service;

import java.util.ArrayList;

import com.yj.dto.BoardDto;

public interface BoardService {
	ArrayList<BoardDto> getList(int pageNUm);
	int getLastPageNumber();
	BoardDto getBoardDetail(int bno);
	public void boardWrite(BoardDto dto);
	public void boardUpdate(BoardDto dto);
	public void boardDelete(int bno);
}
