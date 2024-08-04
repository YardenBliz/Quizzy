package il.ac.hit.quizzy;

/**
 * Interface for quiz file Data Access Object (DAO).
 */
public interface IQuizFilesDAO {

    /**
     * Saves a quiz to a file.
     *
     * @param quiz the quiz to save
     * @param fileName the name of the file
     * @throws QuizException if an error occurs while saving the quiz
     */
    public abstract void saveQuizToFile(IQuiz quiz, String fileName) throws QuizException;

    /**
     * Loads a quiz from a file.
     *
     * @param fileName the name of the file
     * @return the loaded quiz
     * @throws QuizException if an error occurs while loading the quiz
     */
    public abstract IQuiz loadQuizFromFile(String fileName) throws QuizException;
}
