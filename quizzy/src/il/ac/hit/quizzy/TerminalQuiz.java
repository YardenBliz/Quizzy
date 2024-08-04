package il.ac.hit.quizzy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * A quiz implementation for the terminal.
 */
public class TerminalQuiz implements IQuiz {
    private String name;
    private List<IQuizQuestion> questions = new ArrayList<>();

    /**
     * Starts the quiz in the terminal.
     */
    @Override
    public void start() {
        if (questions.isEmpty()) {
            System.out.println("No questions in the quiz.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        int score = 0;

        // Iterate through all questions and display them in the terminal
        for (IQuizQuestion question : questions) {
            QuizQuestion q = (QuizQuestion) question;
            System.out.println(q.getTitle());
            System.out.println(q.getQuestion());
            List<QuizQuestion.Answer> answers = q.getAnswers();
            for (int i = 0; i < answers.size(); i++) {
                System.out.println((i + 1) + ". " + answers.get(i).getText());
            }

            int userAnswer = -1;
            while (true) {
                System.out.print("Your answer: ");
                if (scanner.hasNextInt()) {
                    userAnswer = scanner.nextInt();
                    if (userAnswer > 0 && userAnswer <= answers.size()) {
                        break;
                    }
                } else {
                    scanner.next(); // Consume the invalid input
                }
                System.out.println("Invalid input. Please enter a valid number between 1 and " + answers.size() + ".");
            }

            if (answers.get(userAnswer - 1).isCorrect()) {
                score++;
            }
        }

        System.out.println("Your score: " + score + "/" + questions.size());
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
