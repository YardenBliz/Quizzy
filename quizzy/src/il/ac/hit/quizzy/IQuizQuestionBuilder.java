package il.ac.hit.quizzy;

/**
 * Interface for building a quiz question.
 */
public interface IQuizQuestionBuilder {

    /**
     * Sets the title of the question.
     *
     * @param text the title text
     * @return the builder instance
     */
    public IQuizQuestionBuilder setTitle(String text);

    /**
     * Sets the question text.
     *
     * @param text the question text
     * @return the builder instance
     */
    public IQuizQuestionBuilder setQuestion(String text);

    /**
     * Adds an answer to the question.
     *
     * @param text the answer text
     * @param correct whether the answer is correct
     * @return the builder instance
     */
    public IQuizQuestionBuilder addAnswer(String text, boolean correct);

    /**
     * Creates the QuizQuestion instance.
     *
     * @return the QuizQuestion instance
     */
    public IQuizQuestion create();
}
