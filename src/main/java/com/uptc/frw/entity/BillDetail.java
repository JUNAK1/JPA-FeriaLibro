package com.uptc.frw.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "DETALLES_COMPRA")
public class BillDetail {
    @Id
    @Column(name = "ID_DETALLE")
    private Long id;
    @Column(name = "ID_COMPRA")
    private Long billId;
    @Column(name = "ID_LIBRO")
    private Long bookId;
    @Column(name = "CANTIDAD")
    private int quantity;


    public BillDetail() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "BillDetail{" +
                "id=" + id +
                ", billId=" + billId +
                ", bookId=" + bookId +
                ", quantity=" + quantity +
                '}';
    }
}

