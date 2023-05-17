package com.dorukt;

import java.util.Scanner;

public class Database {

	static Scanner sc = new Scanner(System.in);

	private Musteri[] musteriler = new Musteri[0];
	private Araba[] araclar = new Araba[0];

	public Database() {

	}

	public Database(int arabaOlustur, int musteriOlustur) {
		araclar = new Araba[3];
		Araba arb1 = new Araba("34 ADC 312", "Mercedes", "E200", "Siyah", "Sedan", "4", 10000);
		Araba arb2 = new Araba("34 SUP 324", "Volvo", "S90", "Gri", "Sedan", "4", 11000);
		Araba arb3 = new Araba("34 TOP 542", "AUDI", "TT", "Turuncu", "Sport", "2", 7000);
		araclar[0] = arb1;
		araclar[1] = arb2;
		araclar[2] = arb3;

		musteriler = new Musteri[3];
		Musteri mst1 = new Musteri("Doruk Tokinan", "05253234", "123123", "Batıkent/Ankara");
		Musteri mst2 = new Musteri("Barış Demirci", "05517932", "321321", "Bahçeşehir/İstanbul");
		Musteri mst3 = new Musteri("Levent Tarık Koyuncu", "05497889", "666666", "Gölbaşı/Ankara");
		musteriler[0] = mst1;
		musteriler[1] = mst2;
		musteriler[2] = mst3;
	}

	public int getMusteriSayisi() {
		return musteriler.length;
	}

	public int getAracSayisi() {
		return araclar.length;
	}

	// ===========================================================================
	// Müşteri Kısmı
	// ===========================================================================

	// Müşterileri Listeliyor.
	public void musterileriListele() {
		if (musteriler.length == 0) {
			System.out.println("Hiç müşteriniz yok.");
		} else {
			System.out.println("Müşteri Listesi: ");
			for (int i = 0; i < musteriler.length; i++) {
				System.out.print((i + 1) + "- Müşteri Adı Soyad: " + musteriler[i].getAdSoyad());
				System.out.print(" / Müşteri Kimlik No: " + musteriler[i].getKimlikNo());
				System.out.print(" / Müşteri Tel No: " + musteriler[i].getTelefonNo());
				System.out.println(" / Müşteri Adres: " + musteriler[i].getAdres());

				if (musteriler[i].getMyAraba() != null)
					System.out.println("   Kiracısı olduğu aracın plakası: " + musteriler[i].getMyAraba().getPlaka());
				else {
					System.out.println("   Kiracısı olduğu aracın plakası: Kiralanan araç yoktur.");
				}

			}
		}

	}

	public void musteriBilgileriniDuzenle() {
		if (musteriler.length == 0) {
			System.out.println("Müşteriniz olmadan düzenleme yapamazsınız.");
		} else {
			int mustIndex = musteriGetir();
			if (mustIndex == -1)
				System.out.println("İşlem iptal edildi.");
			else {
				int secim = 0;
				do {
					System.out.println("Degistirmek istediğiniz bilgiyi seçin:");
					System.out.println("1- Ad soyad: " + musteriler[mustIndex].getAdSoyad());
					System.out.println("2- Telefon No: " + musteriler[mustIndex].getTelefonNo());
					System.out.println("3- Adres: " + musteriler[mustIndex].getAdres());
					System.out.println("4- Ana menüye dön.");
					secim = sc.nextInt();
					sc.nextLine();
					switch (secim) {
					case 1:
						System.out.println("Yeni Ad Soyadı girin.");
						musteriler[mustIndex].setAdSoyad(sc.nextLine());
						System.out.println("Değişiklik kaydedildi.");
						break;
					case 2:
						System.out.println("Yeni telefon numarasını girin.");
						musteriler[mustIndex].setTelefonNo(sc.nextLine());
						System.out.println("Değişiklik kaydedildi.");
						break;

					case 3:
						System.out.println("Yeni Adres bilgisini girin.");
						musteriler[mustIndex].setAdres(sc.nextLine());
						System.out.println("Değişiklik kaydedildi.");
						break;
					case 4:

						break;
					default:
						System.out.println("Hatali giris");
						break;
					}

				} while (secim != 4);

			}
		}

	}

	// Müşteri Kapasitesini arttırıyor.
	private void musteriKapasiteArttir() {

		Musteri[] must = new Musteri[musteriler.length + 1];
		for (int i = 0; i < musteriler.length; i++) {
			must[i] = musteriler[i];
		}
		musteriler = must;
	}

	// Müşteri kapasitesini azaltıyor.
	private void musteriKapasiteAzalt() {
		Musteri[] must = new Musteri[musteriler.length - 1];
		for (int i = 0, j = 0; i < musteriler.length;) {
			if (musteriler[i] == null) {
				i++;
			} else {
				must[j] = musteriler[i];
				i++;
				j++;
			}

		}
		musteriler = must;
	}

	// Yeni müşteri oluşturmayı sağlıyor.
	public void musteriEkle() {
		boolean varMi = false;
		Musteri mus = new Musteri();
		if (mus.getKimlikNo().equalsIgnoreCase(null)) {
			System.out.println("Kimlik numarası olmadan kayıt işlemi gerçekleştiremezsiniz.");
		} else {
			for (int i = 0; i < musteriler.length; i++) {
				if (musteriler[i].getKimlikNo().equalsIgnoreCase(mus.getKimlikNo()))
					varMi = true;
			}
			if (varMi)
				System.out.println("İşlem başarısız (Kimlik Numarasını kontrol edin.)");
			else {
				musteriKapasiteArttir();
				musteriler[musteriler.length - 1] = mus;
			}
		}

	}

	// Müşteriyi kimlik numarasından bulup siliyor.
	public void musteriSil() {
		if (musteriler.length == 0) {
			System.out.println("Zaten müşteriniz bulunmamaktadır.");
		} else {
			int sil = -1;
			boolean devamEdilsinMi = false;
			System.out.println("Lütfen silmek istediğiniz müşterinin kimlik numarasını girin.");
			String temp = sc.nextLine();
			while (sil < 0 && !temp.equalsIgnoreCase("exit")) {
				for (int i = 0; i < musteriler.length; i++) {
					if (musteriler[i].getKimlikNo().equalsIgnoreCase(temp)) {
						sil = i;
						devamEdilsinMi = true;
					}
				}
				if (sil == -1) {
					System.out.println(
							"Hatalı kimlik numarası girdiniz. Lütfen tekrar giriş yapın veya çıkmak için 'Exit' yazın.");
					temp = sc.nextLine();
				}
			}

			if (devamEdilsinMi) {
				if (musteriler[sil].getMyAraba() != null)
					System.out.println(
							"Müşterinin kaydının silinmesi için önce kiralanan aracın iade etmesi gerekmektedir.");
				else {
					musteriler[sil] = null;
					musteriKapasiteAzalt();
					System.out.println("Silme işlemi tamamlandı.");
				}
			} else {

				System.out.println("Silme işlemi iptal edildi.");
			}
		}
	}

	// Yardımcı metod müşterinin indexini döndürüyor. eğer başarılı gerçekleşmezse
	// -1 dönüyor.

	private int musteriGetir() {
		int mustIndex = -1;

		System.out.println("Lütfen müşterinin kimlik numarasını girin.");
		String temp = sc.nextLine();
		while (mustIndex < 0 && !temp.equalsIgnoreCase("exit")) {
			for (int i = 0; i < musteriler.length; i++) {
				if (musteriler[i].getKimlikNo().equalsIgnoreCase(temp)) {
					mustIndex = i;
				}
			}
			if (mustIndex == -1) {
				System.out.println(
						"Hatalı kimlik numarası girdiniz. Lütfen tekrar giriş yapın veya çıkmak için 'Exit' yazın.");
				temp = sc.nextLine();
			}
		}
		return mustIndex;
	}

	/*
	 * ===========================================================================
	 * ==== Araba Kısmı
	 * ===========================================================================
	 */

	public boolean aracBul() {
		int sayac = 1;
		boolean varMi = false;
		if (araclar.length == 0) {
			System.out.println("Şu an hiç aracınız bulunmamaktadır.");
		} else {
			System.out.println("1-Markaya göre ara");
			System.out.println("2-Yolcu sayısına göre ara");
			System.out.println("3-Renge göre ara");
			int secim = sc.nextInt();
			sc.nextLine();
			switch (secim) {
			case 1:
				System.out.println("Lütfen aracın markasını girin.");
				String istenenMarka = sc.nextLine();
				for (int i = 0; i < araclar.length; i++) {
					if (araclar[i].getMarka().equalsIgnoreCase(istenenMarka)) {
						varMi = true;
						System.out.println(sayac + "-" + araclar[i].getPlaka() + " plakalı araç. Araç rengi: "
								+ araclar[i].getRenk() + ", Haftalık kira: " + araclar[i].getHaftalikKira());
						sayac++;
					}

				}
				if (sayac == 1) {
					System.out.println("Araç Bulunamadı.");
				}

				sayac = 1;
				break;
			case 2:
				System.out.println("Lütfen aracın yolcu sayısını girin.");
				String istenenYolcuSayisi = sc.nextLine();
				for (int i = 0; i < araclar.length; i++) {
					if (araclar[i].getKapasite().equalsIgnoreCase(istenenYolcuSayisi)) {
						varMi = true;
						System.out.println(sayac + "-" + araclar[i].getPlaka() + " plakalı araç. Araç Markası: "
								+ araclar[i].getMarka() + ", Haftalık kira: " + araclar[i].getHaftalikKira());
						sayac++;
					}
				}
				if (sayac == 1) {
					System.out.println("Araç Bulunamadı.");
				}

				sayac = 1;
				break;
			case 3:
				System.out.println("Lütfen aracın rengini girin.");
				String istenenRenk = sc.nextLine();
				for (int i = 0; i < araclar.length; i++) {
					if (araclar[i].getRenk().equalsIgnoreCase(istenenRenk)) {
						varMi = true;
						System.out.println(sayac + "-" + araclar[i].getPlaka() + " plakalı araç. Araç Yolcu Sayısı: "
								+ araclar[i].getKapasite() + ", Haftalık kira: " + araclar[i].getHaftalikKira());
						sayac++;
					}
				}
				if (sayac == 1) {
					System.out.println("Araç Bulunamadı.");

				}

				sayac = 1;
				break;

			default:
				System.out.println("Hatalı giriş yaptınız.");
				break;
			}
		}

		return varMi;
	}

	private void aracStockArttir() {
		Araba[] must = new Araba[araclar.length + 1];
		for (int i = 0; i < araclar.length; i++) {
			must[i] = araclar[i];
		}
		araclar = must;
	}

	private void aracStockAzalt() {

		Araba[] must = new Araba[araclar.length - 1];
		for (int i = 0, j = 0; i < araclar.length;) {
			if (araclar[i] == null) {
				i++;
			} else {
				must[j] = araclar[i];
				i++;
				j++;
			}

		}
		araclar = must;

	}

	public void aracEkle() {
		boolean aynisiVarMi = false;
		Araba araba1 = new Araba();
		if (araba1.getPlaka().equalsIgnoreCase(null))
			System.out.println("Aracın plakası girilmelidir.");
		else {
			for (int i = 0; i < araclar.length; i++) {
				if (araba1.getPlaka() == araclar[i].getPlaka()) {
					aynisiVarMi = true;
					break;
				}
			}
			if (aynisiVarMi) {
				System.out.println("Belirtilen araç zaten firmamıza aittir.");
			} else {
				aracStockArttir();
				araclar[araclar.length - 1] = araba1;

			}

		}

	}

	public void aracSil() {
		if (araclar.length == 0) {
			System.out.println("Zaten aracımız bulunmamaktadır.");
		} else {
			mevcutAraclariListele();
			int sil = -1;
			boolean devamEdilsinMi = false;
			System.out.println("Lütfen silmek istediğiniz aracın plakasını girin.");
			String temp = sc.nextLine();
			while (sil < 0 && !temp.equalsIgnoreCase("exit")) {
				for (int i = 0; i < araclar.length; i++) {
					if (araclar[i].getPlaka().equalsIgnoreCase(temp)) {
						sil = i;
						devamEdilsinMi = true;
					}
				}
				if (sil == -1) {
					System.out.println(
							"Hatalı bir plaka girdiniz. Lütfen tekrar giriş yapın veya çıkmak için 'Exit' yazın.");
					temp = sc.nextLine();
				}
			}

			if (devamEdilsinMi) {
				if (araclar[sil].getKiraci() != null)
					System.out.println("Silme işleminden önce aracın iade edilmesi gerekmektedir.");
				else {
					araclar[sil] = null;
					aracStockAzalt();
					System.out.println("Silme işlemi tamamlandı.");
				}

			} else {
				System.out.println("Silme işlemi iptal edildi.");
			}
		}
	}

	public void aracKirala() {
		if (musteriler.length == 0 || araclar.length == 0) {
			System.out.println("Araç ya da Müşteriniz olmadığı için kiralama işlemi başarısız.");
		} else {
			int musteriIndex = musteriGetir();
			if (musteriIndex == -1)
				System.out.println("Kiralama işlemi başarısız. (Geçersiz kimlik No)");
			else {
				mevcutAraclariListele();
				boolean varMi = aracBul();
				if (varMi) {
					int kiralanacakAracIndex = 0;
					System.out.println(
							"Lütfen araç kiralamak istediginiz aracın plakasını girin veya ana menüye dönmek için Exit yazın.");
					String kiralanacakAracPlaka = sc.nextLine();
					if (kiralanacakAracPlaka.equalsIgnoreCase("exit")) {
						System.out.println("İşlem iptal edilmiştir.");
					} else {
						for (int i = 0; i < araclar.length; i++) {
							if (araclar[i].getPlaka().equalsIgnoreCase(kiralanacakAracPlaka))
								kiralanacakAracIndex = i;
						}
						if (musteriler[musteriIndex].getMyAraba() == null
								&& araclar[kiralanacakAracIndex].getKiraci() == null) {
							musteriler[musteriIndex].setMyAraba(araclar[kiralanacakAracIndex]);
							araclar[kiralanacakAracIndex].setKiraci(musteriler[musteriIndex]);
							System.out.println("Kiralama işlemi başarılı.");
						} else {
							System.out.println(
									"İşlem başarısız. Kullanıcı başka bir araca sahip ya da araç zaten kirada.");
						}
					}

				} else {
					System.out.println("Araç bulunamadığı için işlem iptal edildi.");
				}
			}

		}

	}

	/*
	 * ===========================================================================
	 * ==== Ortak Metod
	 * ===========================================================================
	 */
	public void kirayiSonlandir() {
		if (araclar.length == 0 || musteriler.length == 0) {
			System.out.println("Aracınız veya müşteriniz bulunmadığı için işlem iptal edilmiştir.");
		} else {
			boolean atamaVarMi = false;
			int musteriIndex = musteriGetir();
			if (musteriIndex == -1)
				System.out.println("Kiralama işlemi başarısız. (Geçersiz kimlik No)");
			else {
				int kiradaAracVarMi = kiralananAraclariListele();
				if (kiradaAracVarMi == 0) {
					System.out.println("Kirada hiç araç yok.");
				} else {
					int kiralanacakAracIndex = 0;
					System.out.println(
							"İadesi gerçekleştirilecek olan aracın plakasını girin veya ana menüye dönmek için Exit yazın.");
					String kiralanacakAracPlaka = sc.nextLine();
					if (kiralanacakAracPlaka.equalsIgnoreCase("exit")) {
						System.out.println("İşlem iptal edilmiştir.");
					} else {
						for (int i = 0; i < araclar.length; i++) {
							if (araclar[i].getPlaka().equalsIgnoreCase(kiralanacakAracPlaka)) {
								kiralanacakAracIndex = i;
								atamaVarMi = true;
							}
						}
						if (atamaVarMi == true && musteriler[musteriIndex].getMyAraba() == araclar[kiralanacakAracIndex]
								&& araclar[kiralanacakAracIndex].getKiraci() == musteriler[musteriIndex]) {
							musteriler[musteriIndex].setMyAraba(null);
							araclar[kiralanacakAracIndex].setKiraci(null);
							System.out.println("Kira sonlandırma işlemi başarılı");
						} else {
							System.out.println("İşlem başarısız. Kullanıcı veya araç bilgilerini kontrol edin.");
						}
					}

				}

			}

		}

	}

	public void tumAraclariListele() {
		System.out.println("Tüm araçlar ve Özellikleri: ");
		for (int i = 0; i < araclar.length; i++) {
			System.out.print("Aracın plakası: " + araclar[i].getPlaka());
			System.out.print(" / Aracın Markası: " + araclar[i].getMarka());
			System.out.print(" / Aracın Modeli: " + araclar[i].getModel());
			System.out.print(" / Aracın Rengi: " + araclar[i].getRenk());
			System.out.print(" / Aracın Kasası: " + araclar[i].getKasa());
			System.out.print(" / Aracın Kapasitesi: " + araclar[i].getKapasite());
			System.out.print(" / Aracın Markası: " + araclar[i].getHaftalikKira());
			if (araclar[i].getKiraci() == null)
				System.out.println(" / Aracın kiracısı: Yok");
			else {
				System.out.println(" / Aracın kiracısı: " + araclar[i].getKiraci().getAdSoyad());

			}
		}

	}

	public int kiralananAraclariListele() {
		int sayac = 0;
		for (int i = 0; i < araclar.length; i++) {
			if (araclar[i].getKiraci() != null) {
				sayac++;
				System.out.println((sayac) + "-" + araclar[i].getPlaka() + " plakalı araç "
						+ araclar[i].getKiraci().getAdSoyad() + " tarafından kiralanmıştır.");
			}
		}
		System.out.println("Totalde kirada olan araç sayısı: " + sayac);
		return sayac;
	}

	public void mevcutAraclariListele() {
		int sayac = 0;
		for (int i = 0; i < araclar.length; i++) {
			if (araclar[i].getKiraci() == null) {
				sayac++;
				System.out.println((sayac) + "-" + araclar[i].getPlaka() + " plakalı araç kiralamaya uygundur.");
			}
		}
		System.out.println("Kullanıma uygun toplam araç sayısı: " + sayac);
	}

}
