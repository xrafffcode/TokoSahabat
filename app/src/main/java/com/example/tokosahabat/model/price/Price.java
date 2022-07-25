package com.example.tokosahabat.model.price;

import com.example.tokosahabat.model.MyCartListModel;

import java.util.List;

public class Price{
	private int kode;
	private String pesan;
	private List<PriceData> data;

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

	public List<PriceData> getData() {
		return data;
	}

	public void setData(List<PriceData> data) {
		this.data = data;
	}
}