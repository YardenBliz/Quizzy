package il.ac.hit.quizzy;

import java.util.List;

/**
 * Interface for a quiz question.
 */
public interface IQuizQuestion {

    /**
     * Gets the title of the question.
     *
     * @return the title of the question
     */
    String getTitle();

    /**
     * Gets the question text.
     *
     * @return the question text
     */
    String getQuestion();

    /**
     * Gets the list of answers for the question.
     *
     * @return the list of answers
     */
    List<QuizQuestion.Answer> getAnswers();

    /**
     * Gets the index of the correct answer.
     *
     * @return the index of the correct answer
     */
    int getCorrectAnswerIndex();
}
