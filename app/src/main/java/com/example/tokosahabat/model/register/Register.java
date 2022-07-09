package com.example.tokosahabat.model.register;

public class Register{
	private RegisterData registerData;
	private String message;
	private boolean status;

	public void setData(RegisterData registerData){
		this.registerData = registerData;
	}

	public RegisterData getData(){
		return registerData;
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
