package dtos;

import lombok.*;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String lastName;
    private String firstName;
}
