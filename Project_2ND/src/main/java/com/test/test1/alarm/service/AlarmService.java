package com.test.test1.alarm.service;

import java.util.Map;

import com.test.test1.video.dto.CommentDto;

/* 02.24 장재호 */
public interface AlarmService {

	void alarmDel(int idx);

	void addComment(CommentDto dto);

}

/*******************************************/