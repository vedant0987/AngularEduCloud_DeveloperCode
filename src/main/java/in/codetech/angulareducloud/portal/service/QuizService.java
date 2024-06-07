package in.codetech.angulareducloud.portal.service;

import java.util.List;
import java.util.Set;

import in.codetech.angulareducloud.portal.module.exam.Category;
import in.codetech.angulareducloud.portal.module.exam.Quizz;

public interface QuizService {
	
	 public Quizz addQuiz(Quizz quiz);

	    public Quizz updateQuiz(Quizz quiz);

	    public Set<Quizz> getQuizzes();

	    public Quizz getQuiz(Long quizId);

	    public void deleteQuiz(Long quizId);

	    public List<Quizz> getQuizzesOfCategory(Category category);

	    public List<Quizz> getActiveQuizzes();

	    public List<Quizz> getActiveQuizzesOfCategory(Category category);
	}


