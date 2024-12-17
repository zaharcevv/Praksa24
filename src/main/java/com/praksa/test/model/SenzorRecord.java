package com.praksa.test.model;

public class SenzorRecord {
    int id;
    String timestamp;
    String temperature;
    String humidity;

    public SenzorRecord() {
    }

    public SenzorRecord(String temperature, String humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public SenzorRecord(int id, String timestamp, String temperature, String humidity) {
        this.id = id;
        this.timestamp = timestamp;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }
}
