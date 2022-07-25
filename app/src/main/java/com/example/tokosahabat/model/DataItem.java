package com.example.tokosahabat.model;

public class DataItem{
	private String delivered;
	private String idTransaksi;
	private String namaUser;
	private String waktuOrder;

	public void setDelivered(String delivered){
		this.delivered = delivered;
	}

	public String getDelivered(){
		return delivered;
	}

	public void setIdTransaksi(String idTransaksi){
		this.idTransaksi = idTransaksi;
	}

	public String getIdTransaksi(){
		return idTransaksi;
	}

	public void setNamaUser(String namaUser){
		this.namaUser = namaUser;
	}

	public String getNamaUser(){
		return namaUser;
	}

	public void setWaktuOrder(String waktuOrder){
		this.waktuOrder = waktuOrder;
	}

	public String getWaktuOrder(){
		return waktuOrder;
	}
}
