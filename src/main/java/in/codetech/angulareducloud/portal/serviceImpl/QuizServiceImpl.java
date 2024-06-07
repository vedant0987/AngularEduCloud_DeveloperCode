package in.codetech.angulareducloud.portal.serviceImpl;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.codetech.angulareducloud.portal.module.exam.Category;
import in.codetech.angulareducloud.portal.module.exam.Quizz;
import in.codetech.angulareducloud.portal.repository.QuizRepository;
import in.codetech.angulareducloud.portal.service.QuizService;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Override
    public Quizz addQuiz(Quizz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public Quizz updateQuiz(Quizz quiz) {
        if (quiz.getQid() == 0) {
            throw new IllegalArgumentException("Quiz ID cannot be null");
        }
        Optional<Quizz> optionalQuiz = quizRepository.findById(quiz.getQid());
        if (optionalQuiz.isPresent()) {
            Quizz updateQuiz = optionalQuiz.get();
            updateQuiz.setCategory(quiz.getCategory());
            updateQuiz.setDescription(quiz.getDescription());
            updateQuiz.setMaxMarks(quiz.getMaxMarks());
            updateQuiz.setNoofQuestions(quiz.getNoofQuestions());
            updateQuiz.setTitle(quiz.getTitle());
            updateQuiz.setActive(quiz.isActive());
            return quizRepository.save(updateQuiz);
        }
        return null;
    }

    @Override
    public Set<Quizz> getQuizzes() {
        return new LinkedHashSet<>(quizRepository.findAll());
    }

    @Override
    public Quizz getQuiz(Long quizId) {
        return quizRepository.findById(quizId).orElseThrow();
    }

    @Override
    public void deleteQuiz(Long quizId) {
        quizRepository.deleteById(quizId);
    }

    @Override
    public List<Quizz> getQuizzesOfCategory(Category category) {
        return quizRepository.findByCategory(category);
    }

    @Override
    public List<Quizz> getActiveQuizzes() {
        return quizRepository.findByActive(true);
    }

    @Override
    public List<Quizz> getActiveQuizzesOfCategory(Category category) {
        return quizRepository.findByCategoryAndActive(category, true);
    }
}
