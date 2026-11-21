package domain;

public class Platform {
    private final int platformId;
    private String name;
    private float surchargePercentage;

    public Platform(int platformId, String name, float surchargePercentage) {
        this.platformId = platformId;
        setName(name);
        setSurchargePercentage(surchargePercentage);
    }

    public float getSurchargePercentage() {
        return surchargePercentage;
    }

    public void setSurchargePercentage(float surchargePercentage) {
        this.surchargePercentage = surchargePercentage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("el nombre de la plataforma es obligatorio");
        }
    }

    public int getplatformId() {
        return platformId;
    }

}
