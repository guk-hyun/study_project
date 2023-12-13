package com.study.study_project.mapper;

import com.study.study_project.domain.dto.FileDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FileMapper {
	int insertFile(FileDTO file);
	
	List<FileDTO> getFiles(Long boardnum);
	
	int deleteBySystemname(String systemname);
	
	int deleteByBoardnum(Long boardnum);
}
