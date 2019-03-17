package com.operantic.ote.user.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "o_user_role")
public class UserRole {
    private int id;
    private int oUserId;
    private int oRoleId;
    private int addBy;
    private LocalDateTime dateCreated;
    private LocalDateTime dateModified;
    private boolean isDeleted;

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
    @Column(name = "o_role_id", nullable = false)
    public int getoRoleId() {
        return oRoleId;
    }

    public void setoRoleId(int oRoleId) {
        this.oRoleId = oRoleId;
    }

    @Basic
    @Column(name = "add_by", nullable = false)
    public int getAddBy() {
        return addBy;
    }

    public void setAddBy(int addBy) {
        this.addBy = addBy;
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

    @Basic
    @Column(name = "is_deleted", nullable = false)
    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRole userRole = (UserRole) o;
        return id == userRole.id &&
                oUserId == userRole.oUserId &&
                oRoleId == userRole.oRoleId &&
                addBy == userRole.addBy &&
                isDeleted == userRole.isDeleted &&
                Objects.equals(dateCreated, userRole.dateCreated) &&
                Objects.equals(dateModified, userRole.dateModified);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, oUserId, oRoleId, addBy, dateCreated, dateModified, isDeleted);
    }
}
