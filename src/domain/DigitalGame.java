package domain;

public class DigitalGame extends VideoGame {
    private float downloadSize;
    private int availableLicenses;

    // constructor de la clase
    public DigitalGame(int id, String title, String developer, int releaseYear, float basePrice,
            Platform platform, boolean activate, float downloadSize, int availableLicenses) {
        super(id, title, developer, releaseYear, basePrice, platform, activate);
        setDownloadSize(downloadSize);
        setAvailableLicenses(availableLicenses);

    }

    // getters y setters
    public float getDownloadSize() {
        return downloadSize;
    }

    public void setDownloadSize(float downloadSize) {
       if (downloadSize > 0) {
        this.downloadSize = downloadSize;
       }else {
        throw new IllegalArgumentException("el tamaño debe ser mayor que cero");
       }
    }

    public int getAvailableLicenses() {
        return availableLicenses;
    }

    public void setAvailableLicenses(int availableLicenses) {
        if (availableLicenses >= 0) {
        this.availableLicenses = availableLicenses;
        }else {
            throw new IllegalArgumentException("las licencias no pueden ser negativas");
        }
    }
    //metodos

    public void increaseLicenses() {
        availableLicenses++;
    };

    public void decreaseLicenses() {
        if (availableLicenses > 0) {
            availableLicenses--;
        }else {
            throw new IllegalArgumentException ("no hay licencias disponibles");
        }
    }

    @Override 
    public float calculateSellingPrice(){
        return getBasePrice()* calculateBasePrice();
    }
    public String gameFormat(){
        return "Digital";
    }
}
