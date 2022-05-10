package ru.kpfu.itis.dtos;

import lombok.*;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationDto {
    private String firstName;
    private String lastName;
    private String nickname;
    private String password;
    private String confirmPassword;
    private Boolean consent;
}
