package in.codetech.angulareducloud.portal.module.exam;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "quizzes")
public class Quizz {
	
	 @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private long qid;
     private String title;
     @Column(length=5000)
     private String description;
     private String maxMarks;
     private String noofQuestions;
     private boolean active=false;
     
     @ManyToOne(fetch = FetchType.EAGER)
     private Category category;

     @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
     private LinkedHashSet<Question> questions = new LinkedHashSet<>();
     
     
	@Override
	public String toString() {
		return "Quizz [qid=" + qid + ", title=" + title + ", description=" + description + ", maxMarks=" + maxMarks
				+ ", noofQuestions=" + noofQuestions + ", active=" + active + "]";
	}
	public Quizz() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Quizz(long qid, String title, String description, String maxMarks, String noofQuestions, boolean active) {
		super();
		this.qid = qid;
		this.title = title;
		this.description = description;
		this.maxMarks = maxMarks;
		this.noofQuestions = noofQuestions;
		this.active = active;
	}
	public long getQid() {
		return qid;
	}
	public void setQid(long qid) {
		this.qid = qid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMaxMarks() {
		return maxMarks;
	}
	public void setMaxMarks(String maxMarks) {
		this.maxMarks = maxMarks;
	}
	public String getNoofQuestions() {
		return noofQuestions;
	}
	public void setNoofQuestions(String noofQuestions) {
		this.noofQuestions = noofQuestions;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Object getCategory() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setCategory(Object category2) {
		// TODO Auto-generated method stub
		
	}
     
     

}
