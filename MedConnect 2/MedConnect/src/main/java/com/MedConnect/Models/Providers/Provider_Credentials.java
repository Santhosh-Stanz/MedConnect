package com.MedConnect.Models.Providers;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Document(collection = "MedConnect_Providers")
public class Provider_Credentials {

    private String Id="Provider_Credentials";
    private String name;
    private String password;
    private String role;
    private String location;
    private List<String> domainlist;
    private int number;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String domain) {
        this.role = domain;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<String> getDomainlist() {
        return domainlist;
    }

    public void setDomainlist(List<String> domainlist) {
        this.domainlist = domainlist;
    }
}
