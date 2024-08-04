package il.ac.hit.quizzy;

import java.util.ArrayList;
import java.util.List;

/**
 * A class representing a quiz question.
 */
public class QuizQuestion implements IQuizQuestion {
    private String title;
    private String question;
    private List<Answer> answers;

    /**
     * Constructor using the Builder class.
     *
     * @param builder the builder instance
     */
    protected QuizQuestion(Builder builder) {
        this.title = builder.title;
        this.question = builder.question;
        this.answers = builder.answers;
    }

    /**
     * Gets the title of the question.
     *
     * @return the title of the question
     */
    @Override
    public String getTitle() {
        return title;
    }

    /**
     * Gets the question text.
     *
     * @return the question text
     */
    @Override
    public String getQuestion() {
        return question;
    }

    /**
     * Gets the list of answers for the question.
     *
     * @return the list of answers
     */
    @Override
    public List<Answer> getAnswers() {
        return answers;
    }

    /**
     * Gets the index of the correct answer.
     *
     * @return the index of the correct answer
     */
    @Override
    public int getCorrectAnswerIndex() {
        for (int i = 0; i < answers.size(); i++) {
            if (answers.get(i).isCorrect()) {
                return i;
            }
        }
        return -1; // if no correct answer is found
    }

    /**
     * Builder class for QuizQuestion.
     */
    public static class Builder implements IQuizQuestionBuilder {
        private String title;
        private String question;
        private List<Answer> answers = new ArrayList<>();

        /**
         * Sets the title of the question.
         *
         * @param text the title text
         * @return the builder instance
         */
        @Override
        public IQuizQuestionBuilder setTitle(String text) {
            this.title = text;
            return this;
        }

        /**
         * Sets the question text.
         *
         * @param text the question text
         * @return the builder instance
         */
        @Override
        public IQuizQuestionBuilder setQuestion(String text) {
            this.question = text;
            return this;
        }

        /**
         * Adds an answer to the question.
         *
         * @param text the answer text
         * @param correct whether the answer is correct
         * @return the builder instance
         */
        @Override
        public IQuizQuestionBuilder addAnswer(String text, boolean correct) {
            this.answers.add(new Answer(text, correct));
            return this;
        }

        /**
         * Creates the QuizQuestion instance.
         *
         * @return the QuizQuestion instance
         */
        @Override
        public IQuizQuestion create() {
            return new QuizQuestion(this);
        }
    }

    /**
     * Class representing an answer to a quiz question.
     */
    public static class Answer {
        private String text;
        private boolean isCorrect;

        /**
         * Constructor for Answer.
         *
         * @param text the answer text
         * @param isCorrect whether the answer is correct
         */
        public Answer(String text, boolean isCorrect) {
            this.text = text;
            this.isCorrect = isCorrect;
        }

        /**
         * Gets the answer text.
         *
         * @return the answer text
         */
        public String getText() {
            return text;
        }

        /**
         * Checks if the answer is correct.
         *
         * @return true if the answer is correct, false otherwise
         */
        public boolean isCorrect() {
            return isCorrect;
        }
    }
}
