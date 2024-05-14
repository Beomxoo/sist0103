package spring.mvc.answerdata;

import java.util.HashMap;
import java.util.List;

public interface AnswerDaoInter {
	
	public void insertAnswer(AnswerDto dto);
	public List<AnswerDto>  getAnswerList(int num);
	public int passCheckAnswer(int idx, String pass);
	public void deleteAnswer(int idx);
}
