import java.time.LocalDate;
import java.util.ArrayList;

public class Hotel {
    protected ArrayList<Kamar> daftarKamar;
    protected ArrayList<Tamu> daftarTamu;
    protected ArrayList<Reservasi> daftarReservasi;

    public Hotel() {
        this.daftarKamar = new ArrayList<>();
        this.daftarTamu = new ArrayList<>();
        this.daftarReservasi = new ArrayList<>();
    }

    public void tambahKamar(Kamar kamar) {
        daftarKamar.add(kamar);
    }

    public void tambahTamu(Tamu tamu) {
        daftarTamu.add(tamu);
    }

    public Kamar cariKamar(int nomorKamar) {
        for (Kamar kamar : daftarKamar) {
            if (kamar.getNomorKamar() == nomorKamar && kamar.isTersedia()) {
                return kamar;
            }
        }
        return null;
    }

    public void buatReservasi(Tamu tamu, int nomorKamar, LocalDate checkIn, LocalDate checkOut) {
        Kamar kamar = cariKamar(nomorKamar);
        if (kamar != null) {
            Reservasi reservasi = new Reservasi(tamu, kamar, checkIn, checkOut);
            tamu.tambahReservasi(reservasi);
            kamar.setTersedia(false); // Menandakan kamar sudah dipesan
            daftarReservasi.add(reservasi);
            System.out.println("Reservasi berhasil untuk tamu: " + tamu.nama);
        } else {
            System.out.println("Kamar dengan nomor " + nomorKamar + " tidak tersedia.");
        }
    }

    public void batalkanReservasi(Reservasi reservasi) {
        if (reservasi.isAktif()) {
            reservasi.batalReservasi();
            System.out.println("Reservasi dibatalkan.");
        } else {
            System.out.println("Reservasi sudah dibatalkan sebelumnya.");
        }
    }

    public void daftarKamarTersedia() {
        System.out.println("Daftar Kamar Tersedia:");
        for (Kamar kamar : daftarKamar) {
            if (kamar.isTersedia()) {
                kamar.tampilkanInfoKamar();
            }
        }
    }

    public void tampilkanInfoTamu(Tamu tamu) {
        tamu.tampilkanInfoTamu();
    }
}
