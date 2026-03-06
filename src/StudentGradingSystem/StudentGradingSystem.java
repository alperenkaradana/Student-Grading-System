/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StudentGradingSystem;
import java.util.Scanner;   
        
/**
 *
 * @author alperen
 */
public class StudentGradingSystem 
{
    // Ogrenci bilgilerinin sisteme girilmesi saglanir.
    public static double[] bilgiKayit(int[] ogrenciNumaralari, String[] ogrenciIsimleri, double[] ogrenciVizeleri, double[] ogrenciFinalleri)
    {
        Scanner scn = new Scanner(System.in);
        System.out.println("\nLutfen ogrencinin sirasiyla ogrenci numarasini, isim_soyisim bilgisini, nesneye yonelik programlama dersinin vize ve final notlarini giriniz.");
        double[] sinavSonuclari = new double[ogrenciNumaralari.length];
        for(int i=0; i<ogrenciNumaralari.length; i++)
        {
            System.out.println((i+1)+". Ogrencinin bilgilerini girin. ");
            System.out.print("Numarasi: ");
            ogrenciNumaralari[i] = scn.nextInt();
            System.out.print("Ismi: ");
            ogrenciIsimleri[i] = scn.next();
            System.out.print("Vize Sonucu: ");
            ogrenciVizeleri[i] = scn.nextDouble();
            System.out.print("Final Sonucu: ");
            ogrenciFinalleri[i] = scn.nextDouble();
        }
        sinavSonuclari = sinavSonuc(ogrenciVizeleri, ogrenciFinalleri);
            return sinavSonuclari;
    }
    
    // Sisteme girilen ogrenci bilgilerini giris sirasiyla ekrana yazdirir.
    public static void bilgileriGoruntule(int ogrenciNumaralari[], String ogrenciIsimleri[], double ogrenciVizeleri[], double ogrenciFinalleri[])
    {
        System.out.println("---------Girilen Ogrenci Bilgileri---------\n");
        for (int i = 0; i < ogrenciNumaralari.length; i++) 
        {
            System.out.println((i+1) + ".   " + ogrenciNumaralari[i] + "  " + ogrenciIsimleri[i] + "  " + ogrenciVizeleri[i] + "  " + ogrenciFinalleri[i]);
        }
        System.out.println("\n");
    }
    
    // Ogrencilerin vize ve final notlarini hesaplayarak sonuclari yeni bir dizide dondurur.
    public static double[] sinavSonuc(double[] ogrenciVizeleri, double[] ogrenciFinalleri)
    {
        double[] sinavSonuclari = new double[ogrenciVizeleri.length];
        for (int i = 0; i < ogrenciVizeleri.length; i++) 
        {
            sinavSonuclari[i] = (ogrenciVizeleri[i] * 40 / 100) + (ogrenciFinalleri[i] * 60 / 100);
        }
        return sinavSonuclari;
    }
    
    // Sonucu 60'in altinda kalan ogrencileri ve bilgilerini tespit edip yazdirir.
    public static void altmisdanDusukler(double[] sinavSonuclari, int[] ogrenciNumaralari, String[] ogrenciIsimleri)
    {
        System.out.println("-----Ortalamasi 60'dan Dusuk Olan Ogrenciler-----\n");
        for (int i = 0; i < sinavSonuclari.length; i++) 
        {
            if(sinavSonuclari[i]<60.0)
            {
                System.out.println("Sinav Sonucu: " + sinavSonuclari[i] + "\nNumarasi: " + ogrenciNumaralari[i] + "\nOgrenci Ismi: " + ogrenciIsimleri[i] + "\n");
            }
        }
        System.out.println();
    }
    
    // Siniftaki tum notlari toplayip toplam sonucu kisi sayisina bolerek sinif ortalamasini bulur. Daha sonra bu ortalamanin ustunde not alanlari yazdirir.
    public static void ortalamadanYuksekler(double[] sinavSonuclari, int[] ogrenciNumaralari, String[] ogrenciIsimleri)
    {
        System.out.println("------Sinif Ortalamasindan Yuksek Olan Ogrenciler Ve Notlari------\n");
        double toplam = 0.0;
        double ortalama = 0.0;
        for (int i = 0; i < sinavSonuclari.length; i++) 
        {
            toplam += sinavSonuclari[i];
        }
        ortalama = toplam / sinavSonuclari.length;
        for (int i = 0; i < sinavSonuclari.length; i++) 
        {
            if(ortalama < sinavSonuclari[i])
            {
                System.out.println("Ogrenci no: " + ogrenciNumaralari[i] + "\nOgrenci Ismi: " + ogrenciIsimleri[i] +"\nSonucu: " + sinavSonuclari[i] + "\n");
            }
        }
        System.out.println();
    }
    
    // 60'in altinda sonucu olan ogrencilerin sayac ile kac kisi oldugunu hesaplar.
    public static void altmisdanDusukSayisi(double[] sinavSonuclari)
    {
        int sayac = 0;
        for (int i = 0; i < sinavSonuclari.length; i++) 
        {
            if(sinavSonuclari[i] < 60)
            {
                sayac++;
            }
        }
        System.out.println("60'dan Kucuk Sinav Sonuc Adeti: " + sayac + "\n\n");
    }
    
    // Sinav sonuclarini iceren dizinin icindeki degerleri birbirleriyle karsilastirarak en yuksek sonuclu ogrenciyi bulur ve bilgileriyle birlikte yazdirir.
    public static void enYuksekSonuc(double[] sinavSonuclari, int[] ogrenciNumaralari, String[] ogrenciIsimleri)
    {
        double enYuksekSonuc = 0.0;
        int indeks = 0;
        for (int i = 0; i < sinavSonuclari.length; i++) 
        {
            if(enYuksekSonuc < sinavSonuclari[i])
            {
                enYuksekSonuc = sinavSonuclari[i];
                indeks = i;   
            }
        }
        System.out.println("En yuksek alan ogrenci: " + ogrenciNumaralari[indeks] + " " + ogrenciIsimleri[indeks] + " " + sinavSonuclari[indeks] + "\n\n");
    }
    
    // Sinav sonuclarini iceren dizinin icindeki degerleri birbirleriyle karsilastirarak en dusuk sonuclu ogrenciyi bulur ve bilgileriyle birlikte yazdirir.
    public static void enDusukSonuc(double[] sinavSonuclari, int[] ogrenciNumaralari, String[] ogrenciIsimleri)
    {
        double enDusukSonuc = 100.0;
        int indeks = 0;
        for (int i = 0; i < sinavSonuclari.length; i++) 
        {
            if(sinavSonuclari[i] < enDusukSonuc)
            {
                enDusukSonuc = sinavSonuclari[i];
                indeks = i;
            }
        }
        System.out.println("En dusuk alan ogrenci: " + ogrenciNumaralari[indeks] + " " + ogrenciIsimleri[indeks] + " " + sinavSonuclari[indeks] + "\n\n");
    }
    
    // Ic ice iki dongu ile sinav sonuclarini kucukten buyuge siralar. 
    // Bilgilerin karismamasi icin numara ve isim dizileri de ayni sekilde yer degistirilir.
    public static void sonuclariSirala(double[] sinavSonuclari, int[] ogrenciNumaralari, String[] ogrenciIsimleri)
    {
        double geciciSonuc = 0.0;
        int geciciNo = 0;
        String geciciIsim;
        for (int i = 0; i < sinavSonuclari.length; i++) 
        {
            for (int j = i+1; j < sinavSonuclari.length; j++) 
            {
                if(sinavSonuclari[i] > sinavSonuclari[j])
                {
                    geciciSonuc = sinavSonuclari[i];
                    sinavSonuclari[i] = sinavSonuclari[j];
                    sinavSonuclari[j] = geciciSonuc;
                    
                    geciciNo = ogrenciNumaralari[i];
                    ogrenciNumaralari[i] = ogrenciNumaralari[j];
                    ogrenciNumaralari[j] = geciciNo;
                    
                    geciciIsim = ogrenciIsimleri[i];
                    ogrenciIsimleri[i] = ogrenciIsimleri[j];
                    ogrenciIsimleri[j] = geciciIsim;
                }
            }
        }
        System.out.println("-----Kucukten Buyuge Sinav Sonuclari-----\n");
        for (int i = 0; i < sinavSonuclari.length; i++) 
        {
            System.out.println((i+1) + ".  " + ogrenciNumaralari[i] + " " + ogrenciIsimleri[i] + " " + sinavSonuclari[i]);
        }
    }

    public static void main(String[] args)
    {
        Scanner scn = new Scanner(System.in);
        System.out.print("Ogrenci Sayisini Giriniz: ");
        int ogrenciSayisi = scn.nextInt();
        
        // Gerekli degiskenler ve diziler tanımlanır.
        int[] ogrenciNumaralari = new int[ogrenciSayisi];
        String[] ogrenciIsimleri = new String[ogrenciSayisi];  
        double[] ogrenciVizeleri = new double[ogrenciSayisi];
        double[] ogrenciFinalleri = new double[ogrenciSayisi];
        double[] sinavSonuclari = new double[ogrenciSayisi];
        int secim = 0;
     
        // Kullanici -1 yazana kadar menuyu donguye sokar.
        while(secim != -1)
        {
            System.out.print("---------------MENU---------------\n\n"
                             + "1-Ogrenci Bilgileri Kayit Etme veya Duzenleme.\n"
                             + "2-Kayit Edilen Bilgileri Goruntule.\n"
                             + "3-Sonuclari 60'dan Dusuk Olanlari Goster.\n"
                             + "4-Sinif Ortalamasindan Yuksek Sonucu Olanlari Goster.\n"
                             + "5-Sonucu 60'dan Dusuk Kisi Sayisini Goster.\n"
                             + "6-Alinan En Yuksek Sonucu Goster.\n"
                             + "7-Alinan En Dusuk Sonucu Goster.\n"
                             + "8-Butun Sonuclari Kucukten Buyuge Sirala.\n"
                             + "Programdan Cikis Yapmak Icin -1 Yaziniz.\n\n"
                             + "Lutfen yapmak istediginiz islemin numarasini giriniz: ");
            secim = scn.nextInt();
            
            // Kullanicinin menude yaptigi secime gore metodlari calistirir.
            switch(secim)
            {
                case 1:
                    sinavSonuclari = bilgiKayit(ogrenciNumaralari, ogrenciIsimleri, ogrenciVizeleri, ogrenciFinalleri);
                    break;
                
                case 2:
                    bilgileriGoruntule(ogrenciNumaralari, ogrenciIsimleri, ogrenciVizeleri, ogrenciFinalleri);
                    break;
                
                case 3:    
                    altmisdanDusukler(sinavSonuclari, ogrenciNumaralari, ogrenciIsimleri);
                    break;
                
                case 4:
                    ortalamadanYuksekler(sinavSonuclari, ogrenciNumaralari, ogrenciIsimleri);
                    break;
                
                case 5:
                    altmisdanDusukSayisi(sinavSonuclari);
                    break;
                
                case 6:
                    enYuksekSonuc(sinavSonuclari, ogrenciNumaralari, ogrenciIsimleri);
                    break;
                
                case 7:
                    enDusukSonuc(sinavSonuclari, ogrenciNumaralari, ogrenciIsimleri);
                    break;
                
                case 8:
                    sonuclariSirala(sinavSonuclari, ogrenciNumaralari, ogrenciIsimleri);
                    break;
                    
                case -1:
                    System.out.println("Programdan Cikis Yapiliyor.");
                    return;
                    
                default:
                    System.out.println("Hatali bir secim yaptiniz. Menudeki numaralardan birini giriniz.");
                    break;    
            }
        }
    }
}