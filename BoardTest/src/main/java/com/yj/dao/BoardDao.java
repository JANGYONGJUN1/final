package com.yj.dao;

import java.util.ArrayList;

import com.yj.dto.BoardDto;

public interface BoardDao {
	ArrayList<BoardDto> getBoardListPageNum(int pageNum); //해당페이지의 게시글 목록을 리턴
	int getLastPageNumber();
	BoardDto getBoardDetail(int bno);
	public void boardWrite(BoardDto dto);
	public void boardUpdate(BoardDto dto);
	public void boardDelete(int bno);
}
