package com.test.test1.video.service;

import java.util.List;
import java.util.Map;

public interface VideoService {
	
	String create(Map<String, Object> map);

	Map<String, Object> detail(Map<String, Object> map);
	
	List<Map<String, Object>> list(Map<String, Object> map);

}
