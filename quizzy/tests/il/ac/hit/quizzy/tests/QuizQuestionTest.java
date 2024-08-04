package il.ac.hit.quizzy.tests;

import il.ac.hit.quizzy.QuizQuestion;
import il.ac.hit.quizzy.IQuizQuestionBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuizQuestionTest {

    private QuizQuestion question;

    @Before
    public void setUp() throws Exception {
        IQuizQuestionBuilder builder = new QuizQuestion.Builder();
        question = (QuizQuestion) builder.setTitle("Test Correct Title")
                .setQuestion("Test Question?")
                .addAnswer("Answer A", false)
                .addAnswer("Answer B", true)
                .addAnswer("Answer C", false)
                .addAnswer("Answer D", false)
                .addAnswer("Answer E", false)
                .create();
    }

    @After
    public void tearDown() throws Exception {
        question = null;
    }

    @Test
    public void getTitle() {
        assertEquals("Test Correct Title", question.getTitle());
    }

    @Test
    public void getQuestion() {
        assertEquals("Test Question?", question.getQuestion());
    }

    @Test
    public void getAnswers() {
        assertEquals(5, question.getAnswers().size());
    }

    @Test
    public void getCorrectAnswerIndex() {
        assertEquals(1, question.getCorrectAnswerIndex());
    }
}
