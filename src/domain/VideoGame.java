package domain;

public abstract class VideoGame {
    private int gameId;
    private String title;
    private String developer;
    private int releaseYear;
    private float basePrice;
    private boolean activate;

    // getters y setters
    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
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

    public void setDeveloper(String ddeveloper) {
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
    public abstract float calculateSellingPrice();
    public abstract String gameFormat();
    

}
