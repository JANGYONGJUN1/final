package com.yj.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yj.dto.BoardDto;

@Repository
public class BoardDaoImpl implements BoardDao {
	@Autowired
	SqlSession sqlSession;

	// 현재 게시글 페이저 번호 리턴
	@Override
	public ArrayList<BoardDto> getBoardListPageNum(int pageNum) {
		int endNum = pageNum * 10;
		int startNum = endNum -9;
		
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		hmap.put("start", startNum);
		hmap.put("end",endNum);
		List<BoardDto> list1 = sqlSession.selectList("BoardMapper.listByPage",hmap);
		
		ArrayList<BoardDto> listRet = new ArrayList<BoardDto>();
		listRet.addAll(list1);
		return listRet;
	}

	//마지막페이지번호 리턴
	@Override
	public int getLastPageNumber() {
		int cnt = sqlSession.selectOne("BoardMapper.allCount");
		
		return cnt/10 + (cnt%10>0 ? 1 : 0);
	}

	//상세게시글 조회 
	@Override
	public BoardDto getBoardDetail(int bno) {
		return sqlSession.selectOne("BoardMapper.boardDetail", bno);
	}
	
	//게시글 작성
	@Override
	public void boardWrite(BoardDto dto) {
		sqlSession.insert("BoardMapper.boardWrite", dto);
	}
	
	//게시글 수정
	@Override
	public void boardUpdate(BoardDto dto) {
		sqlSession.update("BoardMapper.boardUpdate",dto);
	}
	
	//게시글 삭제
	@Override
	public void boardDelete(int bno) {
		sqlSession.delete("BoardMapper.boardDelete",bno);
	}

}
