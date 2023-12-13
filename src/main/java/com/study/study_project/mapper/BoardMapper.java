package com.study.study_project.mapper;

import com.study.study_project.domain.dto.BoardDTO;
import com.study.study_project.domain.dto.Criteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
	//insert
	int insertBoard(BoardDTO board);

	//update
	int updateBoard(BoardDTO board);
	int updateReadCount(Long boardnum);

	//delete
	int deleteBoard(Long boardnum);

	//select
	List<BoardDTO> getList(Criteria cri);
	Long getTotal(Criteria cri);
	Long getLastNum(String userid);
	BoardDTO findByNum(Long boardnum);
}



