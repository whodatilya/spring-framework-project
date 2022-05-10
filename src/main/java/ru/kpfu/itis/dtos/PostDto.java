package ru.kpfu.itis.dtos;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostDto implements Serializable {
    private String title;
    private String description;
    private String phone_number;
}
