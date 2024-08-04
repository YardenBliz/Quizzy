package il.ac.hit.quizzy;

/**
 * Factory class to create quiz instances.
 */
public class QuizFactory implements QuizFactoryInterface {

    /**
     * Creates a quiz instance based on the given quiz type.
     *
     * @param type the type of quiz (TERMINAL or GUI)
     * @return an instance of IQuiz
     */
    @Override
    public IQuiz createQuiz(QuizType type) {
        System.out.println("Creating quiz of type: " + type);
        switch (type) {
            case TERMINAL:
                return new TerminalQuiz();
            case GUI:
                return new GUIQuiz();
            default:
                throw new IllegalArgumentException("Unknown QuizType: " + type);
        }
    }
}
