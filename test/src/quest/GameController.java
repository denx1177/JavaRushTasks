package quest;

import lombok.NonNull;
import lombok.Value;
import quest.entities.Game;
import quest.entities.Question;
import quest.init.GameInit;

import java.io.IOException;

public class GameController {
    private static final String CONFIG_FILE_PATH = "configs/game-config.json";

    public static void main(String[] args) throws IOException {
//        Game game = GameInit.generateGame();
//        GameInit.saveGame(game,CONFIG_FILE_PATH);
        Game game = GameInit.loadGame(CONFIG_FILE_PATH);
        int i = 0;
        Tuple<Integer, Question> idAndQuestion;
        while (i >= 0) {
            idAndQuestion = getCurrentIdAndQuestion(game);
            System.out.println(idAndQuestion);
            System.out.println();
            i = idAndQuestion.getSecond().getAnswers().get(0).getNextQuestionId();
            game.play(i);
        }
    }

    public static Tuple<Integer, Question> getCurrentIdAndQuestion(Game game) {
        Integer questionId = game.getCurrentQuestionId();

        return new Tuple<>(questionId, game.getQuestions().get(questionId));
    }

    @Value
    public static class Tuple<F, S> {
        @NonNull
        F first;
        @NonNull
        S second;
    }
}
