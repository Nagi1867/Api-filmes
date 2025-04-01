package com.example.ApiFilmes.enums;

public enum FilmeStatus {
    ASSISTIDO(1),
    NAO_ASSISTIDO(2);

    private int code;

    private FilmeStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static FilmeStatus valueOf(int code) {
        for (FilmeStatus value : FilmeStatus.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid Status code");
    }
}
