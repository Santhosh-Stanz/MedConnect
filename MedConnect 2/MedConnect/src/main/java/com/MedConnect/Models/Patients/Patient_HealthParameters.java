package com.MedConnect.Models.Patients;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Component
@Document(collection = "MedConnect_patient")
public class Patient_HealthParameters {

    private String Id="Patient_HealthParameters";
    private String name;
    private int bp;
    private int heartrate;
    private int spo2;
    private int cholestral;
    private int sugar;

    public int getBp(){
        return this.bp;
    }
    public int getHeartrate(){
        return this.heartrate;
    }
    public int getSpo2(){
        return this.spo2;
    }
    public int getCholestral(){
        return this.cholestral;
    }
    public int getSugar(){
        return this.sugar;
    }

    public void setBp(int bp) {
        this.bp = bp;
    }

    public void setCholestral(int cholestral) {
        this.cholestral = cholestral;
    }

    public void setHeartrate(int heartrate) {
        this.heartrate = heartrate;
    }

    public void setSpo2(int spo2) {
        this.spo2 = spo2;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
