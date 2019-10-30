package com.anatoliapark.nursinghome.model.auth;

import com.anatoliapark.nursinghome.model.UserComponentContent;
import com.anatoliapark.nursinghome.model.base.BaseEntityAudit;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

import static javax.persistence.InheritanceType.JOINED;


@Entity
@Inheritance(strategy = JOINED)
@Table(name = "user")
public class User extends BaseEntityAudit {

    @Column(name = "name")
    @NotEmpty(message = "{user.name.NotEmpty}")
    private String name;

    @Column(name = "last_name")
    @NotEmpty(message = "{user.lastname.NotEmpty}")
    private String lastName;

    @Column(name = "username")
    @NotEmpty(message = "{user.username.NotEmpty}")
    @Length(min = 5, max = 15, message = "{user.username.Length}")
    private String username;

    @Column(name = "password")
    @NotEmpty(message = "{user.password.NotEmpty}")
    @Length(min = 5, max = 60, message = "{user.password.Length}")
    private String password;

    @Column(name = "active", nullable = false)
    private boolean active = true;

    @Column(name = "last_activation_date")
    private Date lastActivationDate;

    @ManyToMany
    @JoinTable(
            name = "user_usertype",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "type_id", referencedColumnName = "id")}
    )
    @NotEmpty
    private Collection<UserType> userTypes;

    @OneToMany(
            mappedBy = "user",
            orphanRemoval = true,
            cascade=CascadeType.ALL
    )
    private Collection<UserComponentContent> userComponentContents;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getLastActivationDate() {
        return lastActivationDate;
    }

    public void setLastActivationDate(Date lastActivationDate) {
        this.lastActivationDate = lastActivationDate;
    }

    public Collection<UserType> getUserTypes() {
        return userTypes;
    }

    public void setUserTypes(Collection<UserType> userTypes) {
        this.userTypes = userTypes;
    }

    public Collection<UserComponentContent> getUserComponentContents() {
        return userComponentContents;
    }

    public void setUserComponentContents(Collection<UserComponentContent> userComponentContents) {
        this.userComponentContents = userComponentContents;
    }
}