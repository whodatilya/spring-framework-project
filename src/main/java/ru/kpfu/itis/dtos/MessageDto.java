package ru.kpfu.itis.dtos;

import lombok.Data;

@Data
public class MessageDto {
    private String messageType;
    private String firstName;
    private String body;
}