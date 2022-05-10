package models;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Auth {
    private Long id;
    private User user;
    private String cookieValue;
}
