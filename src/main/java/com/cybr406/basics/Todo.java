package com.cybr406.basics;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class Todo {

    @NotNull(message = "Topic is required.")
    @Length(max = 30)
    private String topic;

    @NotNull(message = "Message is required.")
    private String message;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
