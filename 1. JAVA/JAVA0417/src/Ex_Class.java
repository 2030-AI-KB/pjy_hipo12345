
class Women_IT{
	// Women_IT 클래스 멤버 변수
	public String name;		// 인스턴스 변수
	public static String gender="여성";	// 클래스(static) 변수로 선언하고, "여성"으로 초기화
	public boolean student;		// 학생이면 True, 아니라면 False
	
	// 생성자
	public Women_IT(String n, boolean s) {
		this.name=n;
		this.student=s;
	}
	
	// 메소드
	// 1. 이름과 성별 출력하는 메소드
	public void Print() {
		System.out.println("이름: "+this.name);
		System.out.println("성별: "+this.gender);
	}
	// 2. 학생인지 교사인지를 출력하는 메소드
	public void Student() {
		if(this.student==true) {
			System.out.println("학생입니다.");
		}
		else {
			System.out.println("교사입니다.");
		}
	}
}


public class Ex_Class {
	public static void main(String[] args) {
		// 학생 객체 생성
		Women_IT stu=new Women_IT("Lee_Yuna", true);
		// 교사 객체 생성
		Women_IT tc=new Women_IT("이유나", false);
		
		stu.Student();
		stu.Print();
		System.out.println();
		tc.Student();
		tc.Print();
	}
}
