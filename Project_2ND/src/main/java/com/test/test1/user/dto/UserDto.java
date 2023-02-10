package com.test.test1.user.dto;

public class UserDto {
	private int user_id;
	private String id, email, password, nickname, phone_num, subscribe_yn, delete_yn, create_date;
	private String create_type; //apiLogin때문에 추가 - 02.10 장재호	
	
		
	public String getCreate_type() {
		return create_type;
	}

	public void setCreate_type(String create_type) {
		this.create_type = create_type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public UserDto() {
		
	}
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPhone_num() {
		return phone_num;
	}

	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}

	public String getSubscribe_yn() {
		return subscribe_yn;
	}

	public void setSubscribe_yn(String subscribe_yn) {
		this.subscribe_yn = subscribe_yn;
	}

	public String getDelete_yn() {
		return delete_yn;
	}

	public void setDelete_yn(String delete_yn) {
		this.delete_yn = delete_yn;
	}

	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	
	@Override
	public String toString() {
		return "UserDto : [id=" + id + ", email=" + email + ", passwd="+ password+
				", nickname=" + nickname + ", phone_num=" + phone_num + ", create_type=" + create_type + "]";
	}
	
}

