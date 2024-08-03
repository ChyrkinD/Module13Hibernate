package org.example.dao.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    @Size(min = 3, max = 200)
    private String name;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Ticket> tickets;

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
