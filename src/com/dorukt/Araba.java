package com.dorukt;

import java.util.Scanner;

public class Araba {

	static Scanner sc = new Scanner(System.in);
	private String plaka;
	private String marka;
	private String model;
	private String renk;
	private String kasa;
	private String kapasite;
	private int haftalikKira;

	private Musteri kiraci;

	public Araba(String plaka, String marka, String model, String renk, String kasa, String kapasite,
			int haftalikKira) {

		this.plaka = plaka;
		this.marka = marka;
		this.model = model;
		this.renk = renk;
		this.kasa = kasa;
		this.kapasite = kapasite;
		this.haftalikKira = haftalikKira;

	}

	public Araba() {

		System.out.println("Aracın plakası:");
		setPlaka(sc.nextLine());
		System.out.println("Aracın markası:");
		setMarka(sc.nextLine());
		System.out.println("Aracın Modeli: ");
		setModel(sc.nextLine());
		System.out.println("Aracın Rengi: ");
		setRenk(sc.nextLine());
		System.out.println("Aracın Kasası: ");
		setKasa(sc.nextLine());
		System.out.println("Aracın Maximum yolcu sayısı:");
		setKapasite(sc.nextLine());
		System.out.println("Aracın planlanan haftalık kirası: ");
		setHaftalikKira(sc.nextInt());
		sc.nextLine();
	}

	public int getHaftalikKira() {
		return haftalikKira;
	}

	public void setHaftalikKira(int haftalikKira) {
		this.haftalikKira = haftalikKira;
	}

	public String getPlaka() {
		return plaka;
	}

	public void setPlaka(String plaka) {
		this.plaka = plaka;
	}

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getRenk() {
		return renk;
	}

	public void setRenk(String renk) {
		this.renk = renk;
	}

	public String getKasa() {
		return kasa;
	}

	public void setKasa(String kasa) {
		this.kasa = kasa;
	}

	public String getKapasite() {
		return kapasite;
	}

	public void setKapasite(String kapasite) {
		this.kapasite = kapasite;
	}

	public Musteri getKiraci() {
		return kiraci;
	}

	public void setKiraci(Musteri kiraci) {
		this.kiraci = kiraci;
	}

}
