package com.study.demo.mapper;

import com.kh.demo.domain.dto.FileDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FileMapper {
	int insertFile(FileDTO file);
	
	List<FileDTO> getFiles(Long boardnum);
	
	int deleteBySystemname(String systemname);
	
	int deleteByBoardnum(Long boardnum);
}
