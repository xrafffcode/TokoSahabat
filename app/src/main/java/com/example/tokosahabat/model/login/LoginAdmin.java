package com.example.tokosahabat.model.login;

import com.google.gson.annotations.SerializedName;

public class LoginAdmin{
	@SerializedName("data")
	private LoginAdminData loginAdminData;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public void setLoginAdminData(LoginAdminData loginAdminData){
		this.loginAdminData = loginAdminData;
	}

	public LoginAdminData getLoginAdminData(){
		return loginAdminData;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}
}
