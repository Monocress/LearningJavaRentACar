package com.dorukt;

import java.util.Scanner;

public class Musteri {
	Scanner sc = new Scanner(System.in);
	private String adSoyad;
	private String telefonNo;
	private String kimlikNo;
	private String adres;
	private Araba myAraba;

	public Musteri(String adSoyad, String telefonNo, String kimlikNo, String adres) {

		this.adSoyad = adSoyad;
		this.telefonNo = telefonNo;
		this.kimlikNo = kimlikNo;
		this.adres = adres;

	}

	public Musteri() {

		System.out.println("Müşterinin Adı ve Soyadı: ");
		setAdSoyad(sc.nextLine());
		System.out.println("Müşteri telefon numarası: ");
		setTelefonNo(sc.nextLine());
		System.out.println("Müşteri kimlik no: ");
		setKimlikNo(sc.nextLine());
		System.out.println("Müştenin Adresi: ");
		setAdres(sc.nextLine());

	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public String getAdSoyad() {
		return adSoyad;
	}

	public void setAdSoyad(String adSoyad) {
		this.adSoyad = adSoyad;
	}

	public String getTelefonNo() {
		return telefonNo;
	}

	public void setTelefonNo(String telefonNo) {
		this.telefonNo = telefonNo;
	}

	public String getKimlikNo() {
		return kimlikNo;
	}

	public void setKimlikNo(String kimlikNo) {
		this.kimlikNo = kimlikNo;
	}

	public Araba getMyAraba() {
		return myAraba;
	}

	public void setMyAraba(Araba myAraba) {
		this.myAraba = myAraba;
	}

}
