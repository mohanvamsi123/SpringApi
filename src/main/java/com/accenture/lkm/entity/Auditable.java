package com.accenture.lkm.entity;
import static javax.persistence.TemporalType.TIMESTAMP;
import java.util.Date;

import javax.persistence.*;
//import javax.persistence.MappedSuperclass;
//import javax.persistence.Temporal;
//import javax.persistence.Column;

import org.springframework.data.annotation.*;
//import org.springframework.data.annotation.CreatedDate;
//import org.springframework.data.annotation.LastModifiedBy;
//import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable<U>  {
    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false,insertable=false)
    @Temporal(TIMESTAMP)
    protected Date createdAt;

    @LastModifiedDate
    @Column(name = "updated_at",insertable=false)
    @Temporal(TIMESTAMP)
    protected Date updatedAt;

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    


   
}