package com.youcode.visionarycrofting.entity;
import com.youcode.visionarycrofting.classes.Message;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data

public class Stock extends User{

    private String phone;
    private String address;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Product> productList = new ArrayList<>();
    @OneToMany(mappedBy = "stock")
    private List<Invoice> invoiceList = new ArrayList<>();

    public Stock(String name, String email, String password, Collection<Role> roles, String phone, String address) {
        super(name, email, password, roles);
        this.phone = phone;
        this.address = address;
    }

    @Transient
    private Message message;

    public Stock() {

    }
    @Override
    public String toString() {
        return "Stock{" +
                "phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", productList=" + productList +
                ", invoiceList=" + invoiceList +
                ", message=" + message +
                '}';
    }

    public Message getMessage ( ) {
        return message;
    }

    public void setMessage ( Message message ) {
        this.message = message;
    }
}
