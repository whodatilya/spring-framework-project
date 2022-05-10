package models;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class User
{
    private Long id;
    private String nickname;
    private String passwordHash;

}
