package in.codetech.angulareducloud.portal.service;

import java.util.Set;

import in.codetech.angulareducloud.portal.module.exam.Question;
import in.codetech.angulareducloud.portal.module.exam.Quizz;

public interface QuestionService {
	
	  public Question addQuestion(Question question);

	    public Question updateQuestion(Question question);

	    public Set<Question> getQuestions();

	    public Question getQuestion(Long questionId);

	    public Set<Question> getQuestionsOfQuiz(Quizz quiz);

	    public void deleteQuestion(Long quesId);

	    public Question get(Long questionId);

}
