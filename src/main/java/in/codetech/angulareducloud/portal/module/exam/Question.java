package in.codetech.angulareducloud.portal.module.exam;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity

@Table(name = "questions")
public class Question {
	       
	
	      @Id
	      @GeneratedValue(strategy = GenerationType.AUTO)
	       private long quesId;
	       @Column(length=5000)
	        private String content;
	        private String image;
	        private String option1;
	        private String option2;
	        private String option3;
	        private String option4;
	        @JsonIgnore
	        private String answer;
	        
	        
	        @ManyToOne(fetch = FetchType.EAGER)
	        private Quizz quiz;

	        
	        
	        
			@Override
			public String toString() {
				return "Question [quesId=" + quesId + ", content=" + content + ", image=" + image + ", option1="
						+ option1 + ", option2=" + option2 + ", option3=" + option3 + ", option4=" + option4
						+ ", answer=" + answer + "]";
			}
			public Question() {
				super();
				// TODO Auto-generated constructor stub
			}
			public Question(long quesId, String content, String image, String option1, String option2, String option3,
					String option4, String answer) {
				super();
				this.quesId = quesId;
				this.content = content;
				this.image = image;
				this.option1 = option1;
				this.option2 = option2;
				this.option3 = option3;
				this.option4 = option4;
				this.answer = answer;
			}
			public long getQuesId() {
				return quesId;
			}
			public void setQuesId(long quesId) {
				this.quesId = quesId;
			}
			public String getContent() {
				return content;
			}
			public void setContent(String content) {
				this.content = content;
			}
			public String getImage() {
				return image;
			}
			public void setImage(String image) {
				this.image = image;
			}
			public String getOption1() {
				return option1;
			}
			public void setOption1(String option1) {
				this.option1 = option1;
			}
			public String getOption2() {
				return option2;
			}
			public void setOption2(String option2) {
				this.option2 = option2;
			}
			public String getOption3() {
				return option3;
			}
			public void setOption3(String option3) {
				this.option3 = option3;
			}
			public String getOption4() {
				return option4;
			}
			public void setOption4(String option4) {
				this.option4 = option4;
			}
			public String getAnswer() {
				return answer;
			}
			public void setAnswer(String answer) {
				this.answer = answer;
			}
	        
	        

}
