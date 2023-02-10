package com.test.test1.video.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.test1.video.dao.VideoDao;
import com.test.test1.video.dto.VideoDto;

@Service
public class VideoServiceImpl implements VideoService {
	
	@Autowired
	VideoDao videoDao;
	
	@Override
	public String create(Map<String, Object> map) {
		int cnt = this.videoDao.insert(map);
		if (cnt == 1) {
			return map.get("VIDEO_ID").toString();
		}
		return null;
	}
	
//	video_list 전체조회 - 02.10 장민실
	@Override
	public List<VideoDto> list() {
		return videoDao.list();
	}
	
	@Override
	public Map<String, Object> detail(Map<String, Object> map){
	  
		return this.videoDao.selectDetail(map);
	}
	


}
