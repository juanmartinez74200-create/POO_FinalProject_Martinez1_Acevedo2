package domain;

public class Category {
    private int categoryId;
    private String description;
    public enum TipeGender {
        ACCION,
        COMBATE,
        CARRERAS,
        DEPORTE
    }
    protected TipeGender tipeGender;

    // metodos
    public Category(int categoryId,TipeGender tipeGender, String decription) {
        setCategoryId(categoryId);
        setTipeGender(tipeGender);
        setDescription(decription);
    }

    // getters y setters
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public TipeGender getTipeGender(){
        return tipeGender;
    }

    public void setTipeGender(TipeGender tipeGender) {
        this.tipeGender = tipeGender;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    

}
