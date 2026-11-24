package domain;

import java.io.Serializable;

public class Platform implements Serializable{
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
        if (surchargePercentage >= 0) {
        this.surchargePercentage = surchargePercentage;
    } else{
        throw new IllegalArgumentException("El porcentaje adicional no puede ser negativo");
        }
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

    public int getPlatformId() {
        return platformId;
    }

}
