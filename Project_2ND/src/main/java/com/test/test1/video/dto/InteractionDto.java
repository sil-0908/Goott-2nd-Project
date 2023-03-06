package com.test.test1.video.dto;

public class InteractionDto {
	
	int user_id, video_id, comment_id, like, unlike;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getVideo_id() {
		return video_id;
	}

	public void setVideo_id(int video_id) {
		this.video_id = video_id;
	}

	public int getComment_id() {
		return comment_id;
	}

	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}

	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}

	public int getUnlike() {
		return unlike;
	}

	public void setUnlike(int unlike) {
		this.unlike = unlike;
	}
	
	@Override
	public String toString() {
	return "InteractionDto [user_id = " + user_id
			+ ", video_id = " + video_id
			+ ", comment_id = " + comment_id
			+ ", like = " + like
			+ ", unlike = " + unlike + "]";
	}
	
	

}
