package ro.ubb.gunshop.model;

import javax.persistence.*;

@Entity
public class Client extends BaseEntity<Long> {
    String name;
    Integer years;

    public Client() {
    }

    public Client(Long id, String name, Integer years) {
        this.setId(id);
        this.name = name;
        this.years = years;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", years=" + years +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Client && this.getId().equals(((Client) obj).getId());
    }
}
