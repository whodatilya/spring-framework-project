package forms;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class PostForm {

    private String article;
    private String description;
    private String phoneNumber;


}
