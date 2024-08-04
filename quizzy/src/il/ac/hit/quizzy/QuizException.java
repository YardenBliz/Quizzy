package il.ac.hit.quizzy;

/**
 * Custom exception class for quiz-related errors.
 */
public class QuizException extends Exception {
    /**
     * Constructs a new QuizException with the specified detail message.
     *
     * @param message the detail message
     */
    public QuizException(String message) {
        super(message);
    }

    /**
     * Constructs a new QuizException with the specified detail message and cause.
     *
     * @param message the detail message
     * @param cause the cause of the exception
     */
    public QuizException(String message, Throwable cause) {
        super(message, cause);
    }
}
