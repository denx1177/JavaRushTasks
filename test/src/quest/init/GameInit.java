package quest.init;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;
import quest.entities.Answer;
import quest.entities.Game;
import quest.entities.Question;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@UtilityClass
public class GameInit {
    public static Game loadGame(String filePath) throws IOException {

        System.out.println("Download configuration ...");

        String jsonString = Files.readString(Path.of(filePath));
        return new ObjectMapper().readValue(jsonString, Game.class);

    }

    public static Game generateGame() {
        return Game.builder()
                .name("Game First")
                .description("Game description bla-bla-bla")
                .currentQuestionId(Integer.valueOf(0))
                .question(0, Question.builder().text("Start")
                        .answers(Arrays.asList(
                                new Answer(1,"Init 0 --> 1")))
                        .build())
                .question(1, Question.builder().text("Question 1")
                        .answers(Arrays.asList(
                                new Answer(2,"Answer 1 --> 2"),
                                new Answer(-1, "Answer 1 --> -1")))
                        .build())
                .question(2, Question.builder().text("Question 2")
                        .answers(Arrays.asList(
                                new Answer(3,"Answer 2 --> 3"),
                                new Answer(-1, "Answer 2 --> -1")))
                        .build())
                .question(3, Question.builder().text("Question 3")
                        .answers(Arrays.asList(
                                new Answer(4,"Answer 3 --> 4"),
                                new Answer(-1, "Answer 3 --> -1")))
                        .build())
                .question(4, Question.builder().text("Question 4")
                        .answers(Arrays.asList(
                                new Answer(5,"Answer 4 --> 5"),
                                new Answer(-1, "Answer 4 --> -1")))
                        .build())
                .question(5, Question.builder().text("Question 5")
                        .answers(Arrays.asList(
                                new Answer(-1, "Answer END 5 --> -1")))
                        .build())
                .build();

    }

    public static void saveGame(Game game, String filePath) throws IOException {
//        if (Files.notExists(Path.of(filePath))) {

            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(game);
            System.out.println(json);

            try (FileWriter writer = new FileWriter(filePath)) {
                writer.write(json);
            }
//        }
    }
}