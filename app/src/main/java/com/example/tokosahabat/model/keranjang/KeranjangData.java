package com.example.tokosahabat.model.keranjang;

public class KeranjangData {
	private String idItem;
	private String namaItem;
	private String hargaPokok;
	private String idUser;
	private String gambarItem;

	public void setIdItem(String idItem){
		this.idItem = idItem;
	}

	public String getIdItem(){
		return idItem;
	}

	public void setNamaItem(String namaItem){
		this.namaItem = namaItem;
	}

	public String getNamaItem(){
		return namaItem;
	}

	public void setHargaPokok(String hargaPokok){
		this.hargaPokok = hargaPokok;
	}

	public String getHargaPokok(){
		return hargaPokok;
	}

	public void setIdUser(String idUser){
		this.idUser = idUser;
	}

	public String getIdUser(){
		return idUser;
	}

	public void setGambarItem(String gambarItem){
		this.gambarItem = gambarItem;
	}

	public String getGambarItem(){
		return gambarItem;
	}
}
