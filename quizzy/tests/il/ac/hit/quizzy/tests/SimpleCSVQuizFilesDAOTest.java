package il.ac.hit.quizzy.tests;

import il.ac.hit.quizzy.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class SimpleCSVQuizFilesDAOTest {

    private IQuizFilesDAO dao;
    private IQuiz quiz;
    private String fileName = "testQuiz.data";

    @Before
    public void setUp() throws Exception {
        dao = SimpleCSVQuizFilesDAO.getInstance();

        IQuizQuestionBuilder builder = new QuizQuestion.Builder();
        IQuizQuestion question = builder.setTitle("Test Correct Title")
                .setQuestion("Test Question?")
                .addAnswer("Answer A", false)
                .addAnswer("Answer B", true)
                .addAnswer("Answer C", false)
                .addAnswer("Answer D", false)
                .addAnswer("Answer E", false)
                .create();

        quiz = new TerminalQuiz();
        quiz.setName("Test Quiz");
        quiz.addQuestion(question);
    }

    @After
    public void tearDown() throws Exception {
        File file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    public void getInstance() {
        assertNotNull(dao);
    }

    @Test
    public void saveQuizToFile() throws QuizException {
        dao.saveQuizToFile(quiz, fileName);
        File file = new File(fileName);
        assertTrue(file.exists());
    }

    @Test
    public void loadQuizFromFile() throws QuizException {
        dao.saveQuizToFile(quiz, fileName);
        IQuiz loadedQuiz = dao.loadQuizFromFile(fileName);

        assertEquals(quiz.getName(), loadedQuiz.getName());
        assertEquals(quiz.getQuestions().size(), loadedQuiz.getQuestions().size());
        assertEquals(quiz.getQuestions().get(0).getTitle(), loadedQuiz.getQuestions().get(0).getTitle());
        assertEquals(quiz.getQuestions().get(0).getQuestion(), loadedQuiz.getQuestions().get(0).getQuestion());
        assertEquals(quiz.getQuestions().get(0).getAnswers().size(), loadedQuiz.getQuestions().get(0).getAnswers().size());
        assertEquals(quiz.getQuestions().get(0).getCorrectAnswerIndex(), loadedQuiz.getQuestions().get(0).getCorrectAnswerIndex());
    }
}
