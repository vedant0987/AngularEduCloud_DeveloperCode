package in.codetech.angulareducloud.portal.repository;

import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import in.codetech.angulareducloud.portal.module.exam.Category;
import in.codetech.angulareducloud.portal.module.exam.Quizz;

public interface QuizRepository extends JpaRepository<Quizz, Long> {

    List<Quizz> findByCategory(Category category);

    List<Quizz> findByActive(boolean active);

    List<Quizz> findByCategoryAndActive(Category category, boolean active);
}
