import java.util.Scanner;

// shape 클래스 생성 (추상 클래스로 생성하기)
abstract class Shape{
	// getSize() :: 추상 메소드, 넓이 반환하는 함수
	abstract double getSize();
	// Print() :: 추상 메소드, 각 멤버 변수에 대한 값을 출력하는 함수
	abstract void Print();
}

// Circle 클래스 생성
class Circle extends Shape{	// 추상 클래스인 Shape 상속 -> Shape의 추상 메소드 재정의(오버라이딩)
	// 멤버 변수 :: radius(반지름)
	public int radius;
	
	// getSize() 구성하기
	public double getSize() {
		return radius*radius*3.14;
	}
	// Print() 구성하기
	public void Print() {
		System.out.println("원에 대한 객체입니다.");
		System.out.println("반지름: "+this.radius);
	}
	
	//  Circle 생성자 구현
	public Circle(int r) {
		this.radius=r;
	}
}

// Triangle 클래스 생성
class Triangle extends Shape{
	// 멤버 변수 :: w(밑변), h(높이), boolean tf(직각삼각형인지 아닌지)
	public int w;
	public int h;
	public boolean tf;
	
	// getSize() 구성하기
	public double getSize() {
		return w*h*(0.5);
	}
	// Print() 구성하기
	public void Print() {
		System.out.println("삼각형에 대한 객체입니다.");
		System.out.println("밑변: "+this.w);
		System.out.println("높이: "+this.h);
		System.out.println("직각삼각형인가? "+this.tf);
	}
	
	// Triangle 생성자 구현
	public Triangle(int w, int h, boolean tf) {
		this.w=w;
		this.h=h;
		this.tf=tf;
	}
}

class Rectangle extends Shape{
	// 멤버 변수 :: w(밑변), h(높이)
	public int w;
	public int h;
	
	// getSize() 구성하기
	public double getSize() {
		return w*h;
	}
	// Print() 구성하기
	public void Print() {
		System.out.println("사각형에 대한 객체입니다.");
		System.out.println("밑변: "+this.w);
		System.out.println("높이: "+this.h);
	}
	
	// Rectangle 생성자 구현
	public Rectangle(int w, int h) {
		this.w=w;
		this.h=h;
	}
}


public class review_Shape {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// 객체 생성 시, 각 멤버 변수 초기화하기
//		Circle에 대한 객체 생성
		Circle c=new Circle(sc.nextInt());
//		Triangle에 대한 객체 생성
		Triangle t=new Triangle(sc.nextInt(), sc.nextInt(), sc.nextBoolean());
//		Rectangle에 대한 객체 생성
		Rectangle r=new Rectangle(sc.nextInt(), sc.nextInt());
		
		c.Print();
		System.out.println("이 원의 넓이는 "+c.getSize()+"입니다.");
		System.out.println();
		t.Print();
		System.out.println("이 삼각형의 넓이는 "+t.getSize()+"입니다.");
		System.out.println();
		r.Print();
		System.out.println("이 사각형의 넓이는 "+r.getSize()+"입니다.");
	}
}



