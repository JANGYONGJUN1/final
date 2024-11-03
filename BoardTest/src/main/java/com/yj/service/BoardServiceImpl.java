package com.yj.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yj.dao.BoardDao;
import com.yj.dto.BoardDto;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardDao dao;
	
	@Override
	public ArrayList<BoardDto> getList(int pageNUm) {
		return dao.getBoardListPageNum(pageNUm);
	}

	@Override
	public int getLastPageNumber() {
		return dao.getLastPageNumber();
	}

	@Override
	public BoardDto getBoardDetail(int bno) {
		return dao.getBoardDetail(bno);
	}

	@Override
	public void boardWrite(BoardDto dto) {
		dao.boardWrite(dto);
		
	}

	@Override
	public void boardUpdate(BoardDto dto) {
		dao.boardUpdate(dto);
	}
	
	@Override
	public void boardDelete(int bno) {
		dao.boardDelete(bno);
	}

}
