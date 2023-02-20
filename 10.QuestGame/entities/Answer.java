package quest.entities;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Answer {
    @NonNull
    private Integer nextQuestionId;
    @NonNull
    private String text;
}
