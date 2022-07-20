package com.revature.models;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String displayName;
//    @OneToMany(mappedBy = "trainer")
//    private Set<Pokemon> party;
//    @Column(nullable=true)
//	private List<Pokemon> storage;
//	@Column(nullable=true)
//	private List<Item> inventory;
    @Column(nullable = false)
    private int money;

    @Enumerated(EnumType.STRING)
    private Role role;

    public Trainer() {
        super();
    }

    public Trainer(int id, String username, String password, String displayName, int money, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.displayName = displayName;
        this.money = money;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trainer trainer = (Trainer) o;
        return id == trainer.id && money == trainer.money && Objects.equals(username, trainer.username) && Objects.equals(password, trainer.password) && Objects.equals(displayName, trainer.displayName) && role == trainer.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, displayName, money, role);
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", displayName='" + displayName + '\'' +
                ", money=" + money +
                ", role=" + role +
                '}';
    }
}
