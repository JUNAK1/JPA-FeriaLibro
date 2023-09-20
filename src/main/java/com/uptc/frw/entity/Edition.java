package com.uptc.frw.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "EDICIONES")
public class Edition {
    @Id
    @Column(name = "ID_LIBRO")
    private Long id;
    @Column(name = "ANIO_PUBLICACION")
    private int year;
    @Column(name = "NUMERO")
    private int number;
    @Column(name = "DESCRIPCION")
    private String description;
    @OneToOne
    @MapsId
    @JoinColumn(name = "ID_LIBRO", nullable = false)
    private Book book;




    public Edition() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Edition{" +
                "id=" + id +
                ", year=" + year +
                ", number=" + number +
                ", description='" + description + '\'' +
                '}';
    }
}
