package spring.di.ex5;

import java.util.ArrayList;

public class SawonInfo {
	private String name;
	private ArrayList<String> buseo;
	private int pay;
	private String grade;
	
	public SawonInfo(String name, String grade) {
		this.name=name;
		this.grade=grade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<String> getBuseo() {
		return buseo;
	}

	public void setBuseo(ArrayList<String> buseo) {
		this.buseo = buseo;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
}
