package info.model;

import java.sql.Timestamp;

/*JspProject

DTO(data transfer object)
:특정테이블의 정보를 단위별로 정의한 클래스
필수변수와 set,get메서드만으로 이루어짐

DAO(data access object)
:데이타베이스에 접속,명령전송전담클래스(메서드)

DB CRUD
Create
Read
Update
Delete

1.db생성(Oracle)
2.dto  :데이타를 처리하는 클래스
3.dao:db메서드 가지고 있는 클래스(CRUD)
4.addForm.jsp  입력폼
5.addAction.jsp  입력폼의 데이타를 읽어서 db에 저장후 목록으로 이동
6.list.jsp 목록파일(시작파일)
*/
public class InfoDto {
	private String num;
	private String name;
	private String addr;
	private Timestamp sdate;
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Timestamp getSdate() {
		return sdate;
	}
	public void setSdate(Timestamp sdate) {
		this.sdate = sdate;
	}
	
}
