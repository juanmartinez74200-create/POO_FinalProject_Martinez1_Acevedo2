package domain;

public abstract class VideoGame {
    private int id;
    private String title;
    private String developer;
    private int releaseYear;
    private float basePrice;
    private boolean activate;

    private Platform platform;

    // constructor
    public VideoGame(int id, String title, String developer, int releaseYear, float basePrice, Platform platform,
            boolean activate) {
        setId(id);
        setTitle(title);
        setDeveloper(developer);
        setReleaseYear(releaseYear);
        setBasePrice(basePrice);
        setPlatform(platform);
        setActivate(activate);
    
    }

    // getters y setters
    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public float getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(float basePrice) {
        this.basePrice = basePrice;
    }

    public boolean getActivate() {
        return activate;
    }

    public void setActivate(boolean activate) {
        this.activate = activate;
    }
    // metodos

    public abstract float calculateSellingPrice();

    public float calculateBasePrice() {
       return platform.getPrice();
    }

    public abstract String gameFormat();
}
