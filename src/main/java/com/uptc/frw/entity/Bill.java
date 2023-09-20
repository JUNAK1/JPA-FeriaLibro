package com.uptc.frw.entity;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "COMPRAS")
public class Bill {
    @Id
    @Column(name = "ID_COMPRA")
    private Long id;
    @Column(name = "ID_PERSONA",insertable = false,updatable = false)
    private Long personId;
    @Column(name = "FECHA")
    private Date date;
    @ManyToOne
    @JoinColumn(name = "ID_PERSONA")
    private Person person;
    public Bill() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Date getDate() {
        return date;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", personId=" + personId +
                ", date=" + date +
                '}';
    }
}
