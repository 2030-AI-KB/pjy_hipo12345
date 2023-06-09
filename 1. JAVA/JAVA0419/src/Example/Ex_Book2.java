package Example;
// "한빛미디어"에서 만드는 교재를 객체로 생성하여 정보를 출력하자
import java.util.Scanner;

// Book 인터페이스
interface Pub{
//	필드: publish("한빛미디어")
	public static final String publish="한빛미디어";
//	메소드: Print(), updown2000()	-> 추상 메소드로 작성
	abstract public void Print();
	abstract public void updown2000();
}

abstract class Book implements Pub{
	public int year;
	
	// updown2000() :: 개정년도에 따라, 개정된 버전인지 아닌지를 출력
	public void updown2000() {
		if(this.year>=2000) {
			System.out.println("개정된 버전입니다.");
		}
		else {
			System.out.println("개정되기 이전의 버전입니다.");
		}
	}
}

class Java extends Book{
	// 멤버: 개정년도(year), 이름(name, 상수로 선언한 뒤 "Java"로 적용)
	public final String name="Java";
	
	// Print() -> 출판사, 개정년도, 책 이름 출력
	public void Print() {
		System.out.println("책 이름: "+this.name);
		System.out.println("출판사 :"+this.publish);
		System.out.println("개정년도: "+this.year);
	}
	
	// 생성자 구현
	public Java(int y) {
		this.year=y;
	}
}

class Python extends Book{
	// 멤버: 개정년도(year), 이름(name, 상수로 선언한 뒤 "Python"로 적용)
		public final String name="Python";
		
		// Print() -> 출판사, 개정년도, 책 이름 출력
		public void Print() {
			System.out.println("책 이름: "+this.name);
			System.out.println("출판사 :"+this.publish);
			System.out.println("개정년도: "+this.year);
		}
		
		// 생성자 구현
		public Python(int y) {
			this.year=y;
		}
}

public class Ex_Book2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// 객체 생성
		Java j=new Java(sc.nextInt());
		Python p=new Python(sc.nextInt());
		
		j.Print();
		j.updown2000();
		System.out.println();
		p.Print();
		p.updown2000();
	}
}