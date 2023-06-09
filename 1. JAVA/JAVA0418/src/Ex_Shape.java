// Shape 클래스 생성 (추상 클래스로 생성하기)
abstract class Shape{
	// getSize() :: 추상 메소드, 넓이 반환하는 함수
	abstract public double getSize();
}

// Circle 클래스 생성
class Circle extends Shape{
	// 멤버 변수 :: radius(반지름)
	public int radius;
	public double getSize() {
		return radius*radius*3.14;
	}
}

public class Ex_Shape {
	public static void main(String[] args) {
		
	}
}
