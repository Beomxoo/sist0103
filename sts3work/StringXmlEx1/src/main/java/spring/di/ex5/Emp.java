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
		System.out.println("****사원정보****\n");
		System.out.println("회사명:"+empname);
		System.out.println("회사위치:"+emploc);
		System.out.println("사원명:"+sawoninfo.getName());
		System.out.println("급여:"+sawoninfo.getPay());
		System.out.println("직급:"+sawoninfo.getGrade());
		System.out.print("부서명:");
		for(String h: sawoninfo.getBuseo()) {
			System.out.print(h+" ");
		}
	}
	
}
