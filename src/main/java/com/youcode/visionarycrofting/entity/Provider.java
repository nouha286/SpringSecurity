package com.youcode.visionarycrofting.entity;

import com.youcode.visionarycrofting.classes.Message;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.Member;
import java.util.Collection;


@Entity
@Table
@Data

public class Provider extends User implements Serializable {
    private String phone;
    private String address;

    public Provider() {
    }

    @Override
    public String toString() {
        return "Provider{" +
                "phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", message=" + message +
                '}';
    }

    public Provider(String name, String email, String password, Collection<Role> roles, String phone, String address) {
        super(name, email, password, roles);
        this.phone = phone;
        this.address = address;

    }

    @Transient
    private Message message;

    public Message getMessage ( ) {
        return message;
    }

    public void setMessage ( Message message ) {
        this.message = message;
    }
}
