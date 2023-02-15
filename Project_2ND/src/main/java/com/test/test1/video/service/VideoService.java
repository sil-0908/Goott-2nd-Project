package com.test.test1.video.service;

import java.util.List;
import java.util.Map;

import com.test.test1.video.dto.VideoDto;

public interface VideoService {
	
	String create(Map<String, Object> map);
	
//	video_list 전체조회 - 02.10 장민실
	List<VideoDto> list();

//	video_detail 02.10 장민실
	VideoDto detail(int video_id);

//	vodeo_detail_actorName 02.10 장민실 
	List<VideoDto> actor(int video_id);
	
	

}
