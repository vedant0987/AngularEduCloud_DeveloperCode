package in.codetech.angulareducloud.portal.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import in.codetech.angulareducloud.portal.module.exam.Question;
import in.codetech.angulareducloud.portal.module.exam.Quizz;
import in.codetech.angulareducloud.portal.service.QuestionService;

@RestController
@RequestMapping("/api/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping("/")
    public Question addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }

    @PutMapping("/")
    public Question updateQuestion(@RequestBody Question question) {
        return questionService.updateQuestion(question);
    }

    @GetMapping("/")
    public Set<Question> getQuestions() {
        return questionService.getQuestions();
    }

    @GetMapping("/{id}")
    public Question getQuestion(@PathVariable("id") Long id) {
        return questionService.getQuestion(id);
    }

    @DeleteMapping("/{id}")
    public void deleteQuestion(@PathVariable("id") Long id) {
        questionService.deleteQuestion(id);
    }

    @GetMapping("/quiz/{quizId}")
    public Set<Question> getQuestionsOfQuiz(@PathVariable("quizId") Long quizId) {
        Quizz quiz = new Quizz();
        quiz.setQid(quizId);
        return questionService.getQuestionsOfQuiz(quiz);
    }
}
