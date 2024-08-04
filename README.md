# Quizzy


**The Quizzy Library in Java: Final Project in Design Patterns**

**Project Description:**

The Quizzy library is a comprehensive Java library designed to create, manage, and execute quizzes, developed as a final project for a course on Design Patterns. The project emphasizes the practical application of multiple design patterns including Singleton, Factory, Prototype, Data Access Object (DAO), and Builder patterns. The library is packaged as a single JAR file named `quizzy.jar` and supports English language only.

Key Components:

1. **il.ac.hit.quizzy Package**: This package includes all the necessary classes and interfaces to build and run quizzes.

2. **IQuiz Interface**:
 - Methods: `start()`, `setName(String text)`, `getName()`, and `addQuestion(IQuizQuestion question)`.
 - Functionality: Manages the quiz lifecycle, including starting the quiz and adding questions.

3. **IQuizFilesDAO Interface**:
 - Methods: `saveQuizToFile(IQuiz quiz, String fileName)` and `loadQuizFromFile(String fileName)`.
 - Purpose: Handles the saving and loading of quizzes to and from files, encapsulating file operations.

4. **SimpleCSVQuizFilesDAO Class**:
 - Implements Singleton and DAO patterns.
 - Manages CSV file operations for quizzes.

5. **QuizFactory Class**:
 - Implements the Factory pattern.
 - Creates quiz objects based on the type specified (TERMINAL or GUI).

6. **QuizType Enum**:
 - Defines quiz types: TERMINAL and GUI.

7. **IQuizQuestion Interface**:
 - Describes the structure of a multiple-choice quiz question.

8. **QuizQuestion Class**:
 - Implements the Builder pattern.
 - Contains a nested `Builder` class to facilitate the creation of quiz questions.

9. **IQuizQuestionBuilder Interface**:
 - Methods: `setTitle(String text)`, `setQuestion(String text)`, `addAnswer(String text, boolean correct)`, and `create()`.
 - Facilitates the construction of quiz questions.

**Unit Tests**:
- Includes JUnit tests for the functionalities mentioned, ensuring robustness and reliability of the library.

This project aims to deliver a fully functional, pattern-rich library for quiz management, encapsulating best practices in software design and implementation.
