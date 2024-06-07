package in.codetech.angulareducloud.portal.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import in.codetech.angulareducloud.portal.module.exam.Category;
import in.codetech.angulareducloud.portal.module.exam.Quizz;
import in.codetech.angulareducloud.portal.service.QuizService;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/")
    public Quizz addQuiz(@RequestBody Quizz quiz) {
        return quizService.addQuiz(quiz);
    }

    @PutMapping("/")
    public Quizz updateQuiz(@RequestBody Quizz quiz) {
        return quizService.updateQuiz(quiz);
    }

    @GetMapping("/")
    public Set<Quizz> getQuizzes() {
        return quizService.getQuizzes();
    }

    @GetMapping("/{id}")
    public Quizz getQuiz(@PathVariable("id") Long id) {
        return quizService.getQuiz(id);
    }

    @DeleteMapping("/{id}")
    public void deleteQuiz(@PathVariable("id") Long id) {
        quizService.deleteQuiz(id);
    }

    @GetMapping("/category/{categoryId}")
    public List<Quizz> getQuizzesOfCategory(@PathVariable("categoryId") Long categoryId) {
        Category category = new Category();
        category.setCid(categoryId);
        return quizService.getQuizzesOfCategory(category);
    }

    @GetMapping("/active")
    public List<Quizz> getActiveQuizzes() {
        return quizService.getActiveQuizzes();
    }

    @GetMapping("/category/active/{categoryId}")
    public List<Quizz> getActiveQuizzesOfCategory(@PathVariable("categoryId") Long categoryId) {
        Category category = new Category();
        category.setCid(categoryId);
        return quizService.getActiveQuizzesOfCategory(category);
    }
}
