package domain;

public class DigitalGame extends VideoGame {
    private float downloadSize;
    private int availableLicenses;

    // constructor de la clase
    public DigitalGame(int gameFormat, String title, String developer, int releaseYear, float basePrice,
            Plataform plataform, boolean activate, float downloadSize, int availableLicenses) {
        super(gameFormat, title, developer, releaseYear, basePrice, plataform, activate);
        setDownloadSize(downloadSize);
        setDownloadSize(downloadSize);

    }

    // getters y setters
    public float getDownloadSize() {
        return downloadSize;
    }

    public void setDownloadSize(float downloadSize) {
        this.downloadSize = downloadSize;
    }

    public int getAvailableLicenses() {
        return availableLicenses;
    }

    public void setAvailableLicenses(int availableLicenses) {
        this.availableLicenses = availableLicenses;
    }
    //metodos

    public void increaseLicenses() {
    };

    public void decreaseLicenses() {
    };
}
