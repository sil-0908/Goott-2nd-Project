package com.test.test1.video.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.test1.video.dao.InteractionDao;
import com.test.test1.video.dto.InteractionDto;

@Service
public class InteractionServiceImpl implements InteractionService {
	
	@Autowired
	InteractionDao interactionDao;

	@Override
	public void video_like(InteractionDto i_dto) {
		interactionDao.video_like(i_dto);
	}

	@Override
	public List<InteractionDto> video_check_list(Map<String, Object> map2) {
		return interactionDao.video_check_list(map2);
	}

	
	
	

}
