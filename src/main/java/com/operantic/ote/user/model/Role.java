package com.operantic.ote.user.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "o_role")
public class Role extends ModelEntity {
    private String name;

    @Basic
    @Column(name = "name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return id == role.id &&
                isDeleted == role.isDeleted &&
                Objects.equals(name, role.name) &&
                Objects.equals(dateCreated, role.dateCreated) &&
                Objects.equals(dateModified, role.dateModified);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, dateCreated, dateModified, isDeleted);
    }
}
