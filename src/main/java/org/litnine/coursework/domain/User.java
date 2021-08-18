package org.litnine.coursework.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "usr")
@Data
@NoArgsConstructor
public class User{
    @Id
    private String id;
    private Boolean active;
    private String name;
    private Boolean isDarkThemeEnabled;
    private String language;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "usr_role", joinColumns = @JoinColumn(name = "usr_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;
}
