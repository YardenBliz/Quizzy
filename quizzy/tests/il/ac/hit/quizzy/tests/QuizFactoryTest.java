package il.ac.hit.quizzy.tests;

import il.ac.hit.quizzy.QuizFactory;
import il.ac.hit.quizzy.QuizFactoryInterface;
import il.ac.hit.quizzy.QuizType;
import il.ac.hit.quizzy.IQuiz;
import il.ac.hit.quizzy.TerminalQuiz;
import il.ac.hit.quizzy.GUIQuiz;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuizFactoryTest {

    private QuizFactoryInterface factory;

    @Before
    public void setUp() throws Exception {
        factory = new QuizFactory();
    }

    @After
    public void tearDown() throws Exception {
        factory = null;
    }

    @Test
    public void createQuiz() {
        IQuiz terminalQuiz = factory.createQuiz(QuizType.TERMINAL);
        assertTrue(terminalQuiz instanceof TerminalQuiz);

        IQuiz guiQuiz = factory.createQuiz(QuizType.GUI);
        assertTrue(guiQuiz instanceof GUIQuiz);
    }
}
