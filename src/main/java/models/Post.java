package models;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Post  {
    private Long id;
    User user;
    private String article;
    private String description;
    private String phoneNumber;

}
