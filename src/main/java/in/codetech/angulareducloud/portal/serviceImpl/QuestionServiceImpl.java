package in.codetech.angulareducloud.portal.serviceImpl;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.codetech.angulareducloud.portal.module.exam.Question;
import in.codetech.angulareducloud.portal.module.exam.Quizz;
import in.codetech.angulareducloud.portal.repository.QuestionRepository;
import in.codetech.angulareducloud.portal.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        Optional<Question> optionalQues = questionRepository.findById(question.getQuesId());
        if (optionalQues.isPresent()) {
            Question selectedQuestion = optionalQues.get();
            selectedQuestion.setContent(question.getContent());
            selectedQuestion.setOption1(question.getOption1());
            selectedQuestion.setOption2(question.getOption2());
            selectedQuestion.setOption3(question.getOption3());
            selectedQuestion.setOption4(question.getOption4());
            selectedQuestion.setAnswer(question.getAnswer());
            return questionRepository.save(selectedQuestion);
        }
        return null;
    }

    @Override
    public Set<Question> getQuestions() {
        return new LinkedHashSet<>(questionRepository.findAll());
    }

    @Override
    public Question getQuestion(Long questionId) {
        return questionRepository.findById(questionId).orElseThrow();
    }

    @Override
    public Set<Question> getQuestionsOfQuiz(Quizz quiz) {
        return questionRepository.findByQuiz(quiz);
    }

    @Override
    public void deleteQuestion(Long quesId) {
        questionRepository.deleteById(quesId);
    }

    @Override
    public Question get(Long questionId) {
        return questionRepository.findById(questionId).orElseThrow();
    }
}
