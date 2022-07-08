package com.example.tokosahabat.model.login;

import com.google.gson.annotations.SerializedName;

public class LoginData {
	@SerializedName("id_user")
	private String userId;

	@SerializedName("email")
	private String email;



	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getUserId(){
		return userId;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

}
