package com.test.test1.video.dto;

public class VideoDto {
	
	private String title, video_url, image_url, summary, country, grade;
	private int video_id, year, recommand;
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getVideo_url() {
		return video_url;
	}
	
	public void setVideo_url(String video_url) {
		this.video_url = video_url;
	}
	
	public String getImage_url() {
		return image_url;
	}
	
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	
	public String getSummary() {
		return summary;
	}
	
	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getGrade() {
		return grade;
	}
	
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public int getVideo_id() {
		return video_id;
	}

	public void setVideo_id(int video_id) {
		this.video_id = video_id;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public int getRecommand() {
		return recommand;
	}
	
	public void setRecommand(int recommand) {
		this.recommand = recommand;
	}	

	@Override
	public String toString() {
	return "VideoDto [title = " + title
			+ ", video_url = " + video_url
			+ ", image_url = " + image_url
			+ ", summary = " + summary
			+ ", country = " + country
			+ ", grade = " + grade
			+ ", video_id = " + video_id
			+ ", year = " + year
			+ ", recommand = " + recommand + "]";
	}
	
	
	
	
	
	

}
