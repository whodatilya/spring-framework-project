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
@Table(name = "likes")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "comment_id")
    private Long commentId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "numberOfLikes")
    private int numberOfLikes;

}
