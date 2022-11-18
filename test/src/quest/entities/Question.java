package quest.entities;

import lombok.*;
import quest.entities.Answer;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Question {
    @NonNull
    private String text;
    @NonNull
    private List<Answer> answers;
}
