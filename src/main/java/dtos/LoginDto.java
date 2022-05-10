package dtos;

import lombok.*;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {
    private String nickname;
    private String password;
}
