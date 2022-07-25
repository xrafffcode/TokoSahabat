package com.example.tokosahabat.model.keranjang;

public class Keranjang{
	private String pesan;
	private KeranjangData keranjangData;
	private int kode;

	public void setPesan(String pesan){
		this.pesan = pesan;
	}

	public String getPesan(){
		return pesan;
	}

	public void setData(KeranjangData keranjangData){
		this.keranjangData = keranjangData;
	}

	public KeranjangData getData(){
		return keranjangData;
	}

	public void setKode(int kode){
		this.kode = kode;
	}

	public int getKode(){
		return kode;
	}
}
