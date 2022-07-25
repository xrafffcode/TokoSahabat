package com.example.tokosahabat.model;

public class OrderData {
	private int id_transaksi, id_user;
	private String nama_user, delivered;
	private String waktu_order;



	private void setId_transaksi(int id_transaksi) {
		this.id_transaksi = id_transaksi;
	}

	public int getId_transaksi() {
		return id_transaksi;
	}

	private void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public int getId_user() {
		return id_user;
	}

	public void setDelivered(String delivered){
		this.delivered = delivered;
	}

	public String getDelivered(){
		return delivered;
	}

	public void setNamaUser(String nama_user){
		this. nama_user =  nama_user;
	}

	public String getNamaUser(){
		return nama_user;
	}

	public void setWaktuOrder(String wwaktu_order){
		this.waktu_order = waktu_order;
	}

	public String getWaktuOrder(){
		return waktu_order;
	}
}
