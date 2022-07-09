package com.example.tokosahabat.model.login;

public class LoginData {
	private String password;
	private String nama;
	private String telepon;
	private String id_user;
	private String email;
	private String username;

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setTelepon(String telepon){
		this.telepon = telepon;
	}

	public String getTelepon(){
		return telepon;
	}

	public void setIdUser(String id_user){
		this.id_user = id_user;
	}

	public String getIdUser(){
		return id_user;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}
}
