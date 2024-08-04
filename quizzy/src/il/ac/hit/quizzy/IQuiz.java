package il.ac.hit.quizzy;

import java.util.List;

/**
 * Interface for a quiz.
 */
public interface IQuiz {

    /**
     * Starts the quiz.
     */
    public abstract void start();

    /**
     * Sets the name of the quiz.
     *
     * @param text the name of the quiz
     */
    public abstract void setName(String text);

    /**
     * Gets the name of the quiz.
     *
     * @return the name of the quiz
     */
    public abstract String getName();

    /**
     * Adds a question to the quiz.
     *
     * @param question the question to add
     */
    public abstract void addQuestion(IQuizQuestion question);

    /**
     * Gets the list of questions in the quiz.
     *
     * @return the list of questions
     */
    public abstract List<IQuizQuestion> getQuestions();
}
