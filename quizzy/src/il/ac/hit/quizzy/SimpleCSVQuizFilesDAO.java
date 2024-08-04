package il.ac.hit.quizzy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Singleton class for saving and loading quizzes to and from a CSV file.
 */
public class SimpleCSVQuizFilesDAO implements IQuizFilesDAO {
    private static SimpleCSVQuizFilesDAO instance;

    /**
     * Private constructor for Singleton.
     */
    private SimpleCSVQuizFilesDAO() {}

    /**
     * Returns the singleton instance of SimpleCSVQuizFilesDAO.
     *
     * @return the singleton instance
     */
    public static SimpleCSVQuizFilesDAO getInstance() {
        if (SimpleCSVQuizFilesDAO.instance == null) {
            SimpleCSVQuizFilesDAO.instance = new SimpleCSVQuizFilesDAO();
        }
        return SimpleCSVQuizFilesDAO.instance;
    }

    /**
     * Saves the quiz to a CSV file.
     *
     * @param quiz the quiz to save
     * @param fileName the name of the file to save the quiz to
     * @throws QuizException if an error occurs while saving the quiz
     */
    @Override
    public void saveQuizToFile(IQuiz quiz, String fileName) throws QuizException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            // Write the type of the quiz (TERMINAL or GUI)
            writer.write("Quiz Type," + (quiz instanceof TerminalQuiz ? "TERMINAL" : "GUI"));
            writer.newLine();

            // Write the name of the quiz
            writer.write("Quiz Name," + quiz.getName());
            writer.newLine();

            // Write each question and its answers
            for (IQuizQuestion question : quiz.getQuestions()) {
                QuizQuestion q = (QuizQuestion) question;
                writer.write("Question Title," + q.getTitle());
                writer.newLine();
                writer.write("Question Text," + q.getQuestion());
                writer.newLine();
                for (QuizQuestion.Answer answer : q.getAnswers()) {
                    StringBuilder answerLine = new StringBuilder();
                    answerLine.append("Answer,")
                            .append(answer.getText())
                            .append(",")
                            .append(answer.isCorrect());
                    writer.write(answerLine.toString());
                    writer.newLine();
                }
                writer.write("End of Question");
                writer.newLine();
            }
        } catch (IOException e) {
            throw new QuizException("Error saving quiz to file: " + e.getMessage());
        }
    }

    /**
     * Loads a quiz from a CSV file.
     *
     * @param fileName the name of the file to load the quiz from
     * @return the loaded quiz
     * @throws QuizException if an error occurs while loading the quiz
     */
    @Override
    public IQuiz loadQuizFromFile(String fileName) throws QuizException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            IQuiz quiz = null;
            IQuizQuestionBuilder builder = null;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", 3); // Split into up to 3 parts to handle answers correctly
                switch (parts[0]) {
                    case "Quiz Type":
                        QuizFactory factory = new QuizFactory();
                        if (parts.length >= 2) {
                            quiz = factory.createQuiz(QuizType.valueOf(parts[1]));
                        }
                        break;
                    case "Quiz Name":
                        if (parts.length >= 2 && quiz != null) {
                            quiz.setName(parts[1]);
                        }
                        break;
                    case "Question Title":
                        if (parts.length >= 2) {
                            builder = new QuizQuestion.Builder();
                            builder.setTitle(parts[1]);
                        }
                        break;
                    case "Question Text":
                        if (parts.length >= 2 && builder != null) {
                            builder.setQuestion(parts[1]);
                        }
                        break;
                    case "Answer":
                        if (parts.length >= 3 && builder != null) {
                            builder.addAnswer(parts[1], Boolean.parseBoolean(parts[2]));
                        }
                        break;
                    case "End of Question":
                        if (builder != null && quiz != null) {
                            quiz.addQuestion(builder.create());
                        }
                        break;
                }
            }
            return quiz;
        } catch (IOException e) {
            throw new QuizException("Error loading quiz from file: " + e.getMessage());
        }
    }
}
