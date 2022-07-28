package com.spring.lofilive.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class LofiDocument {

    @Id
    private String id;
    private String lofiName;
    private String channelName;
    private String lofiLink;
    private LocalDateTime registrationDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLofiName() {
        return lofiName;
    }

    public void setLofiName(String lofiName) {
        this.lofiName = lofiName;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getLofiLink() {
        return lofiLink;
    }

    public void setLofiLink(String lofiLink) {
        this.lofiLink = lofiLink;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }
}
