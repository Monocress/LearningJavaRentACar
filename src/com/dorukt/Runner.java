package com.dorukt;

import java.util.Scanner;

public class Runner {
	static Scanner sc = new Scanner(System.in);

	public static void menu(String... icerik) {

		for (int i = 0; i < icerik.length; i++) {
			System.out.println((i + 1) + " - " + icerik[i]);
		}
	}

	public static void holder() {
		System.out.println("Ana menüye dönmek için Enter'a basın");
		sc.nextLine();

	}

	public static void main(String[] args) {

		Database data = new Database(3, 3);// Tester database
		// Database data = new Database(); //Normal database Proje tesliminde default
		// olacak
		int kontrol = 0;
		System.out.println("		Hoşgeldiniz.");

		do {
			System.out.println("     * * * * * * * * * * * * * * * * * *");
			menu(" * Kayıtlı Tüm Müşterileri Listele *", " * Müşteri Bilgilerini Düzenle     *",
					" * Müşteri Ekle                    *", " * Müşteri Sil                     *",
					" * Araç Sorgula                    *", " * Araç Ekle                       *",
					" * Araç Sil                        *", " * Araç Kirala                     *",
					" * Kirayı Sonlandır                *", "* Kiralanan araçları listele      *",
					"* Mevcut Araçları Listele         *", "* Tüm araçları listele            *");
			System.out.println("0 -  * Çıkış                           *");
			System.out.println("     * * * * * * * * * * * * * * * * * *");
			kontrol = sc.nextInt();
			sc.nextLine();
			switch (kontrol) {
			case 1:
				data.musterileriListele();
				holder();
				break;
			case 2:
				data.musteriBilgileriniDuzenle();
				holder();
				break;
			case 3:
				data.musteriEkle();
				holder();
				break;
			case 4:
				data.musteriSil();
				holder();
				break;
			case 5:
				data.aracBul();
				holder();
				break;
			case 6:
				data.aracEkle();
				holder();
				break;
			case 7:
				data.aracSil();
				holder();
				break;
			case 8:
				data.aracKirala();
				holder();
				break;
			case 9:
				data.kirayiSonlandir();
				holder();
				break;
			case 10:
				data.kiralananAraclariListele();
				holder();
				break;
			case 11:
				data.mevcutAraclariListele();
				holder();
				break;
			case 12:
				data.tumAraclariListele();

				holder();
				break;
			case 0:
				System.out.println("Yine bekleriz!");
				break;

			default:
				System.out.println("Hatalı giriş yaptınız.");
				break;
			}

		} while (kontrol != 0);

	}
}
