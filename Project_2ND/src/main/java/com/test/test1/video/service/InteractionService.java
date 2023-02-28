package com.test.test1.video.service;

import java.util.List;
import java.util.Map;

import com.test.test1.video.dto.InteractionDto;

public interface InteractionService {

	void video_like(InteractionDto i_dto);

	List<InteractionDto> video_check_list(Map<String, Object> map2);

}
