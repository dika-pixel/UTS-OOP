public class Kamar {
    protected int nomorKamar;
    protected String tipeKamar;
    protected double hargaPerMalam;
    protected boolean tersedia;

    public Kamar(int nomorKamar, String tipeKamar, double hargaPerMalam) {
        this.nomorKamar = nomorKamar;
        this.tipeKamar = tipeKamar;
        this.hargaPerMalam = hargaPerMalam;
        this.tersedia = true;
    }

    public void tampilkanInfoKamar() {
        System.out.println("Nomor Kamar: " + nomorKamar);
        System.out.println("Tipe Kamar: " + tipeKamar);
        System.out.println("Harga per Malam: " + hargaPerMalam);
        System.out.println("Status: " + (tersedia ? "Tersedia" : "Dipesan"));
    }

    public int getNomorKamar() {
        return nomorKamar;
    }

    public boolean isTersedia() {
        return tersedia;
    }

    public void setTersedia(boolean tersedia) {
        this.tersedia = tersedia;
    }
}
