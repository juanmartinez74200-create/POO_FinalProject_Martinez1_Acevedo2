package domain;

public class Category {
    private int categoryId;
    private String description;
    private Gender gender;

    // metodos
    public Category(int categoryId, Gender gender, String description) {
        setCategoryId(categoryId);
        setGender(gender);
        setDescription(description);
    }

    // getters y setters
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        if (gender != null) {
            this.gender = gender;
        } else {
            throw new IllegalArgumentException("debe de seleccionar un genero");
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description != null && !description.trim().isEmpty()) {
            this.description = description;
        } else {
            throw new IllegalArgumentException("la descripcion es obligatoria");
        }
    }
}
// preguntar si se quiere tener una lista fija de generos o se quieren manejar
// libremente