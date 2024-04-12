package com.bori.project31.model;

import lombok.Data;

@Data
public class GameRequest {

    private boolean result;
    private String sent;
    private String writer;

    public GameRequest(boolean result, String sent, String writer) {
        this.result = result;
        this.sent = sent;
        this.writer = writer;
    }
}
