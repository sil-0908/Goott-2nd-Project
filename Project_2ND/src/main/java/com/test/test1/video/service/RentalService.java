package com.test.test1.video.service;

import java.util.List;

import com.test.test1.video.dto.RentalDTO;
import com.test.test1.video.dto.VideoDto;

public interface RentalService {

	void insert(RentalDTO dto);

	void delete(RentalDTO dto);
	
	String getid(RentalDTO dto);

//	미완성
	List<VideoDto> list(String id);
}
