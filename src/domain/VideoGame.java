package domain;

public abstract class VideoGame {
    private int id;
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
    public VideoGame(int id, String title, String developer, int releaseYear, float basePrice, Plataform plataform,
            boolean activate) {
        setId(id);
        setTitle(title);
        setDeveloper(developer);
        setReleaseYear(releaseYear);
        setBasePrice(calculateBasePrice());
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

    public int calculateBasePrice() {
        if (plataform == Plataform.NINTENDO) {
            return 165000;
        } else if (plataform == Plataform.PC) {
            return 172000;
        } else if (plataform == Plataform.PLAYSTATION) {
            return 135000;
        } else if (plataform == Plataform.XBOX) {
            return 150000;
        }
        throw new IllegalArgumentException("plataforma de videojuego no registrada");

    }
    public abstract String gameFormat();
}
