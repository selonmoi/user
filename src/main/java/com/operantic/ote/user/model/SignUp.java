package com.operantic.ote.user.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "sign_up")
public class SignUp {
    private int id;
    private int oUserId;
    private String username;
    private String password;
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;
    private boolean isEnabled;
    private LocalDateTime dateCreated;
    private LocalDateTime dateModified;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "o_user_id", nullable = false)
    public int getoUserId() {
        return oUserId;
    }

    public void setoUserId(int oUserId) {
        this.oUserId = oUserId;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 25)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "is_account_non_expired", nullable = false)
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        isAccountNonExpired = accountNonExpired;
    }

    @Basic
    @Column(name = "is_account_non_locked", nullable = false)
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        isAccountNonLocked = accountNonLocked;
    }

    @Basic
    @Column(name = "is_credentials_non_expired", nullable = false)
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        isCredentialsNonExpired = credentialsNonExpired;
    }

    @Basic
    @Column(name = "is_enabled", nullable = false)
    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    @Basic
    @Column(name = "date_created", nullable = false)
    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Basic
    @Column(name = "date_modified", nullable = true)
    public LocalDateTime getDateModified() {
        return dateModified;
    }

    public void setDateModified(LocalDateTime dateModified) {
        this.dateModified = dateModified;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SignUp signUp = (SignUp) o;
        return id == signUp.id &&
                oUserId == signUp.oUserId &&
                isAccountNonExpired == signUp.isAccountNonExpired &&
                isAccountNonLocked == signUp.isAccountNonLocked &&
                isCredentialsNonExpired == signUp.isCredentialsNonExpired &&
                isEnabled == signUp.isEnabled &&
                Objects.equals(username, signUp.username) &&
                Objects.equals(password, signUp.password) &&
                Objects.equals(dateCreated, signUp.dateCreated) &&
                Objects.equals(dateModified, signUp.dateModified);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, oUserId, username, password, isAccountNonExpired, isAccountNonLocked, isCredentialsNonExpired, isEnabled, dateCreated, dateModified);
    }
}
