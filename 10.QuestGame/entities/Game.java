package quest.entities;

import lombok.*;

import java.util.Map;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Game {
    @NonNull
    private String name;
    @NonNull
    private String description;
    @NonNull
    private Integer currentQuestionId;
    @Singular
    private Map <Integer, Question> questions;

    public void play(Integer nextQuestionId){
        currentQuestionId = nextQuestionId;
    }


//    public Tuple<Integer, Question> getNextIdAndQuestion(){
//        Tuple<Integer, Question> tuple = new Tuple<>(questionId, questions.get(questionId));
////    return new Tuple<>(questionId, questions.get(questionId));
//        return tuple;
//    }
//
//    @Value
//    public static class Tuple<F, S>{
//        @NonNull
//        F first;
//        @NonNull
//        S second;
//    }

}
