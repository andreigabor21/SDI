package ro.ubb.gunshop.model;

import javax.persistence.*;

@Entity(name = "guntype")
public class GunType extends BaseEntity<Long> {
    String name;
    String category;

    public GunType() {
    }

    public GunType(Long id, String name, String category) {
        this.setId(id);
        this.name = name;
        this.category = category;
    }

    public GunType(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof GunType && this.getId().equals(((GunType) obj).getId());
    }
}
