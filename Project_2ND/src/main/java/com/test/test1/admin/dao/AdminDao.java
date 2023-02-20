package com.test.test1.admin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.test1.admin.dto.AdminETCDto;
import com.test.test1.video.dto.VideoDto;

@Repository
public class AdminDao {

	@Autowired
	SqlSession ss;
	
	public int getTotalSales() {
		if(ss.selectOne("admin.getTotalSales") == null) {
			return 0;
		}
		else return ss.selectOne("admin.getTotalSales");
	}

	public void deletes(List<Integer> delArr) {
		ss.delete("admin.deletes", delArr);		
	}

	public int getDailySales() {
		if(ss.selectOne("admin.getDailySales") == null) {
			return 0;
		}
		else return ss.selectOne("admin.getDailySales");
	}

	public int getTodayVisit() {
		if(ss.selectOne("admin.getTodayVisit") == null) {
			return 0;
		}
		else return ss.selectOne("admin.getTodayVisit");
	}

	public int getTotalVisit() {
		if(ss.selectOne("admin.getTotalVisit") == null) {
			return 0;
		}
		else return ss.selectOne("admin.getTotalVisit");
	}

	public void videoDel(int video_id) {
		ss.delete("admin.videoDel", video_id);
	}
	
	public void videoDels(List<Integer> delArr) {
		ss.delete("admin.videoDels", delArr);
	}

	public void videoDataModify(VideoDto dto) {
		ss.update("admin.videoDataModify", dto);
	}

	public List<AdminETCDto> getCategory() {
		return ss.selectList("admin.getCategory");
	}

	public List<AdminETCDto> getGenre() {
		return ss.selectList("admin.getGenre");
	}

	public void addCategory(String category_name) {
		ss.insert("admin.addCategory", category_name);
	}

	public void addGenre(String genre_name) {
		ss.insert("admin.addGenre", genre_name);
	}

	public void delCategory(String category_name) {
		ss.delete("admin.delCategory", category_name);
	}

	public void delGenre(String genre_name) {
		ss.delete("admin.delGenre", genre_name);
	}

}
