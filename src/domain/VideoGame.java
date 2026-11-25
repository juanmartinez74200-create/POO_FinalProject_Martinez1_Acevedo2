package domain;

import java.io.Serializable;

public abstract class VideoGame implements Serializable {
    private int id;
    private String title;
    private String developer;
    private int releaseYear;
    private float basePrice;
    private boolean activate;

    private Platform platform;
    private Gender gender;

    // constructor
    public VideoGame(int id, String title, String developer, int releaseYear, float basePrice, Platform platform,
            Gender gender,boolean activate) {
        setId(id);
        setTitle(title);
        setDeveloper(developer);
        setReleaseYear(releaseYear);
        setBasePrice(basePrice);
        setPlatform(platform);
        setGender(gender);
        setActivate(activate);

    }

    // getters y setters
    public Platform getPlatform() {
        return platform;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        if (gender != null) {
        this.gender = gender;
        }else{
            throw new IllegalArgumentException("Debe seleccionar un genero");
        }
    }

    public void setPlatform(Platform platform) {
       if (platform != null) {
        this.platform = platform; 
        }else{
            throw new IllegalArgumentException("Debe seleccionar una plataforma");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
       if (id >= 0) {
        this.id = id;
       } else{
        throw new IllegalArgumentException("el id no puede ser negativo");
       }
    }

   public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title != null && !title.trim().isEmpty()) {
            this.title = title;
        } else {
            throw new IllegalArgumentException("El titulo es obligatorio");
        }
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        if (developer != null && !developer.trim().isEmpty()) {
            this.developer = developer;
        } else {
            throw new IllegalArgumentException("El desarrollador es obligatorio");
        }
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        if (releaseYear > 0) {
            this.releaseYear = releaseYear;
        } else {
            throw new IllegalArgumentException("El año debe ser mayor a cero");
        }
    }

    public float getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(float basePrice) {
        if (basePrice >= 0) {
            this.basePrice = basePrice;
        } else {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
    }

    public boolean getActivate() {
        return activate;
    }

    public void setActivate(boolean activate) {
        this.activate = activate;
    }

    // Métodos

    public abstract float calculateSellingPrice();
    public float calculatePriceAdjusted() {

        float chargePlataform = basePrice * platform.getSurchargePercentage() / 100;
        float chargeGender = basePrice * gender.getSurchargePercentage() / 100;
        return basePrice + chargePlataform + chargeGender;
    }

}