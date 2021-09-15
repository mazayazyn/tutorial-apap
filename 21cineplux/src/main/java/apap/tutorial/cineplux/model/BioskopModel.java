package apap.tutorial.cineplux.model;

public class BioskopModel {
    private String idBioskop;
    private String namaBioskop;
    private String alamat;
    private String noTelepon;
    private int jumlahStudio;

    //Constructor
    public BioskopModel(String idBioskop, String namaBioskop, String alamat, String noTelepon, int jumlahStudio) {
        this.idBioskop = idBioskop;
        this.namaBioskop = namaBioskop;
        this.alamat = alamat;
        this.noTelepon = noTelepon;
        this.jumlahStudio = jumlahStudio;
    }

    //Getter untuk Id Bioskop
    public String getIdBioskop() {
        return idBioskop;
    }

    //Setter untuk Id Bioskop
    public void setIdBioskop(String idBioskop) {
        this.idBioskop = idBioskop;
    }

    //Getter untuk Nama Bioskop
    public String getNamaBioskop() {
        return namaBioskop;
    }

    //Setter untuk Nama Bioskop
    public void setNamaBioskop(String namaBioskop) {
        this.namaBioskop = namaBioskop;
    }

    //Getter untuk Alamat
    public String getAlamat() {
        return alamat;
    }

    //Setter untuk Alamat
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    //Getter untuk No Telepon
    public String getNoTelepon() {
        return noTelepon;
    }

    //Setter untuk No Telepon
    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }

    //Getter untuk Jumlah Studio
    public int getJumlahStudio() {
        return jumlahStudio;
    }

    //Setter untuk Jumlah Studio
    public void setJumlahStudio(int jumlahStudio) {
        this.jumlahStudio = jumlahStudio;
    }

}
