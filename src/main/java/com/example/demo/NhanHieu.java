package com.example.demo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "nhanhieu")
public class NhanHieu {
    private int id;
    private String ten;
    private int trangthai;
    private String mota;

    public NhanHieu() {

    }

    public NhanHieu(String ten, int trangthai, String mota) {
        super();
        this.ten = ten;
        this.trangthai = trangthai;
        this.mota = mota;
    }

    public NhanHieu(int id, String ten, int trangthai, String mota) {
        super();
        this.id = id;
        this.ten = ten;
        this.trangthai = trangthai;
        this.mota = mota;
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ten", nullable = false, length = 50)
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    @Basic
    @Column(name = "trangthai", nullable = false)
    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    @Basic
    @Column(name = "mota", nullable = true, length = 255)
    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NhanHieu nhanHieu = (NhanHieu) o;
        return id == nhanHieu.id && trangthai == nhanHieu.trangthai && Objects.equals(ten, nhanHieu.ten) && Objects.equals(mota, nhanHieu.mota);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ten, trangthai, mota);
    }
}
