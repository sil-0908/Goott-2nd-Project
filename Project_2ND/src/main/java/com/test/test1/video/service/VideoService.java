package com.test.test1.video.service;

import java.util.List;
import java.util.Map;

import com.test.test1.video.dto.VideoDto;

public interface VideoService {
	
	String create(Map<String, Object> map);
	
//	video_list 전체조회 - 02.10 장민실
	List<VideoDto> list();

	Map<String, Object> detail(Map<String, Object> map);
	
	

}
