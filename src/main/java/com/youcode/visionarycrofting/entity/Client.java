package com.youcode.visionarycrofting.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.youcode.visionarycrofting.classes.Message;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
@Table

@Data
public class Client extends User implements Serializable {


    private String phone;
    private String address;


    @OneToMany (mappedBy = "client")
    @JsonIgnore
    private List<Command> commandList;


    @Override
    public String toString() {
        return "Client{" +
                "phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", commandList=" + commandList +
                ", message=" + message +
                '}';
    }

    public void setCommandList(List<Command> commandList) {
        this.commandList = commandList;
    }

    public void setCommand(Command command) {
        this.commandList.add(command) ;
    }
    public Client() {
    }




    public Client(String name, String email, String password, Collection<Role> roles, String phone, String address) {
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
