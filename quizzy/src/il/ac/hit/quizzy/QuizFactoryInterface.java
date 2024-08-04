package il.ac.hit.quizzy;

/**
 * Factory interface for creating quiz products.
 */
public interface QuizFactoryInterface {
    /**
     * Creates a quiz instance based on the given quiz type.
     *
     * @param type the type of quiz (TERMINAL or GUI)
     * @return an instance of IQuiz
     */
    public abstract IQuiz createQuiz(QuizType type);
}
