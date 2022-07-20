package com.revature.models;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data //for developing purposes
@NoArgsConstructor
@AllArgsConstructor
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
}
