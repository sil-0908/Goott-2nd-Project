package com.test.test1.video.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class VideoDao {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public int insert(Map<String, Object> map) {
		
		return this.sqlSessionTemplate.insert("video.insert", map);
		  
	}
	
	//상세조회 -02.07 배철우
	public Map<String, Object> selectDetail(Map<String,Object> map) {
		// selectOne:데이터를 한개만 가져올때 사용 
		return this.sqlSessionTemplate.selectOne("video.select_detail",map);
		
	}
    //전체조희 -02.07 배철우
	public List<Map<String, Object>> selectList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectList("video.select_list", map);
	}
}
