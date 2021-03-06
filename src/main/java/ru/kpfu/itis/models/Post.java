package ru.kpfu.itis.models;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "posts")
public class Post  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "article")
    private String article;

    @Column(name = "description")
    private String description;

    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToOne
    private Market market;

    @ManyToMany
    @JoinTable(
            name = "bucket",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )

    private List<User> usersWhoAddedToBucket;

    // TODO: 10-05-2022 Если что, удалить таблицу...
    @ManyToMany
    @JoinTable(
            name = "favourites",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )

    private List<User> usersWhoAddedToFavourite;
}
