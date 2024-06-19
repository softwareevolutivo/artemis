package com.se.model.event;

import lombok.Data;

import java.io.Serializable;

public @Data class EventDto implements Serializable {
    private String type;

    private int bedId;

    public EventDto() {
    }

}
