package spring.di.ex5;

public class Emp {
	
	SawonInfo sawoninfo;
	private String empname;
	private String emploc;
	
	public Emp(String empname) {
		this.empname=empname;
	}

	public SawonInfo getSawoninfo() {
		return sawoninfo;
	}

	public void setSawoninfo(SawonInfo sawoninfo) {
		this.sawoninfo = sawoninfo;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getEmploc() {
		return emploc;
	}

	public void setEmploc(String emploc) {
		this.emploc = emploc;
	}
	
	public void writeEmp() {
		System.out.println("****�������****\n");
		System.out.println("ȸ���:"+empname);
		System.out.println("ȸ����ġ:"+emploc);
		System.out.println("�����:"+sawoninfo.getName());
		System.out.println("�޿�:"+sawoninfo.getPay());
		System.out.println("����:"+sawoninfo.getGrade());
		System.out.print("�μ���:");
		for(String h: sawoninfo.getBuseo()) {
			System.out.print(h+" ");
		}
	}
	
}
