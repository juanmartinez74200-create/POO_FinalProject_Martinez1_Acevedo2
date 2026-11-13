package domain;

public abstract class VideoGame {
    private int gameId;
    private String title;
    private String developer;
    private int releaseYear;
    private float basePrice;
    private boolean activate;

    protected enum Plataform {
        NINTENDO,
        PC,
        XBOX,
        PLAYSTATION
    }

    private Plataform plataform;

    // constructor
    public VideoGame(int gameId, String title, String developer, int releaseYear, float basePrice, Plataform plataform,
            boolean activate) {
        setGameId(gameId);
        setGameId(gameId);
        setTitle(title);
        setDeveloper(developer);
        setReleaseYear(releaseYear);
        setBasePrice(basePrice);
        setPlataform(plataform);
        setActivate(activate);
    }

    // getters y setters
    public Plataform getPlataform() {
        return plataform;
    }

    public void setPlataform(Plataform plataform) {
        this.plataform = plataform;
    }

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

    public abstract String gameFormat();

}
