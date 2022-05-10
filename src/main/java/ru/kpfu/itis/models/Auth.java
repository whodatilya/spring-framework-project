package ru.kpfu.itis.models;

import lombok.*;
import javax.persistence.*;


@Setter
@Getter
@EqualsAndHashCode
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "auth")
public class Auth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cookie_value")
    private String cookieValue;

    @ManyToOne
    private User user;
}
