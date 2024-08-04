package il.ac.hit.quizzy;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A quiz implementation for the GUI.
 */
public class GUIQuiz implements IQuiz {
    private String name;
    private List<IQuizQuestion> questions = new ArrayList<>();

    /**
     * Starts the quiz in a GUI.
     */
    @Override
    public void start() {
        if (questions.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No questions in the quiz.");
            return;
        }

        int score = 0;

        for (IQuizQuestion question : questions) {
            QuizQuestion q = (QuizQuestion) question;
            StringBuilder sb = new StringBuilder();
            sb.append(q.getTitle()).append("\n");
            sb.append(q.getQuestion()).append("\n");
            List<QuizQuestion.Answer> answers = q.getAnswers();
            String[] options = new String[answers.size()];
            for (int i = 0; i < answers.size(); i++) {
                sb.append((i + 1)).append(". ").append(answers.get(i).getText()).append("\n");
                options[i] = answers.get(i).getText();
            }

            int response = JOptionPane.showOptionDialog(null, sb.toString(), "Quiz",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            // Valid response?
            if (response >= 0 && response < answers.size()) {
                if (answers.get(response).isCorrect()) {
                    score++;
                }
            } else {
                JOptionPane.showMessageDialog(null, "You have exited the quiz.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Your score: " + score + "/" + questions.size());
    }

    /**
     * Sets the name of the quiz.
     *
     * @param text the name of the quiz
     */
    @Override
    public void setName(String text) {
        this.name = text;
    }

    /**
     * Gets the name of the quiz.
     *
     * @return the name of the quiz
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Adds a question to the quiz.
     *
     * @param question the question to add
     */
    @Override
    public void addQuestion(IQuizQuestion question) {
        questions.add(question);
    }

    /**
     * Gets the list of questions in the quiz.
     *
     * @return the list of questions
     */
    @Override
    public List<IQuizQuestion> getQuestions() {
        return questions;
    }
}
