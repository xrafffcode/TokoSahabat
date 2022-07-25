package com.example.tokosahabat.model;

import java.util.List;

public class Order{
	private int kode;
	private String pesan;
	private List<OrderData> data;

	public int getKode() {
		return kode;
	}

	public void setKode(int kode) {
		this.kode = kode;
	}

	public String getPesan() {
		return pesan;
	}

	public void setPesan(String pesan) {
		this.pesan = pesan;
	}

	public List<OrderData> getData() {
		return data;
	}

	public void setData(List<OrderData> data) {
		this.data = data;
	}
}
