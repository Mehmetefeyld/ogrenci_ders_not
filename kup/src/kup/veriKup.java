
package kup;
import java.util.HashMap;

public class veriKup{
    private HashMap<String, HashMap<String, HashMap<String, Double>>> kup;

    public veriKup() {
        this.kup = new HashMap<>();
    }

    // Veri eklemek için metot
    public void veriEkle(String ogrenci, String ders, String akademikYil, double not) {
        // Eğer öğrenci henüz eklenmediyse, yeni bir öğrenci ekleyin
        kup.computeIfAbsent(ogrenci, k -> new HashMap<>());

        // Eğer ders henüz eklenmediyse, yeni bir ders ekleyin
        kup.get(ogrenci).computeIfAbsent(ders, k -> new HashMap<>());

        // Akademik yıl ve notu ekleyin
        kup.get(ogrenci).get(ders).put(akademikYil, not);
    }

    // Belirli bir öğrencinin aldığı dersleri ve notları getirmek için metot
    public HashMap<String, HashMap<String, Double>> ogrenciDersNotlari(String ogrenci) {
        return kup.get(ogrenci);
    }

    // Belirli bir öğrencinin belirli bir dersten aldığı notları ve akademik yılları getirmek için metot
    public HashMap<String, Double> ogrenciDersAkademikYilNotlari(String ogrenci, String ders) {
        return kup.get(ogrenci).get(ders);
    }

    // Belirli bir öğrencinin belirli bir dersten belirli bir akademik yılda aldığı notu getirmek için metot
    public Double ogrenciDersAkademikYilNotu(String ogrenci, String ders, String akademikYil) {
        return kup.get(ogrenci).get(ders).get(akademikYil);
    }

    public static void main(String[] args) {
        // Örnek kullanım
        VeriKupu veriKupu = new VeriKupu();
        veriKupu.veriEkle("Ogrenci1", "Matematik", "2022-2023", 85.0);
        veriKupu.veriEkle("Ogrenci1", "Fizik", "2022-2023", 78.5);

        // Öğrencinin aldığı dersleri ve notları getirme örneği
        HashMap<String, HashMap<String, Double>> ogrenci1Dersleri = veriKupu.ogrenciDersNotlari("Ogrenci1");
        System.out.println("Ogrenci1'in aldığı dersler ve notları: " + ogrenci1Dersleri);

        // Öğrencinin belirli bir dersten aldığı notları ve akademik yılları getirme örneği
        HashMap<String, Double> matematikNotlari = veriKupu.ogrenciDersAkademikYilNotlari("Ogrenci1", "Matematik");
        System.out.println("Ogrenci1'in Matematik dersinden aldığı notlar: " + matematikNotlari);

        // Öğrencinin belirli bir dersten belirli bir akademik yılda aldığı notu getirme örneği
        Double matematikNotu = veriKupu.ogrenciDersAkademikYilNotu("Ogrenci1", "Matematik", "2022-2023");
        System.out.println("Ogrenci1'in Matematik dersinden 2022-2023 akademik yılında aldığı not: " + matematikNotu);
    }
}