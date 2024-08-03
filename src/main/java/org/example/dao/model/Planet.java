package org.example.dao.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "planet")
public class Planet {
    @Id
    @Column(name = "id")
    @Pattern(regexp = "^[A-Z0-9]+$")
    private String id;

    @Column(name = "name")
    @Size(min = 1, max = 500)
    private String name;

    @OneToMany(mappedBy = "fromPlanet", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Ticket> departureTickets;

    @OneToMany(mappedBy = "toPlanet", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Ticket> arrivalTickets;

    @Override
    public String toString() {
        return "Planet{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
