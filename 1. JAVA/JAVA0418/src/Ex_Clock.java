
// * 시계 클래스 만들기
class Clock{
	// 멤버 변수 :: 시(hour), 분(min), 초(sec)
	public int hour;
	public int min;
	public int sec;
	
	// 생성자 :: "새로운 시각에 대한 객체 생성합니다." 출력한 뒤, 각 변수 초기화
	// this :: 해당 메소드를 불러낸 객체 자신을 지칭
	public Clock(int h, int m, int s) {
		System.out.println("새로운 시각에 대한 객체를 생성합니다.");
		this.hour=h;
		this.min=m;
		this.sec=s;
	}
	
	// 멤버 함수
	// 1. 현재 시각을 양식대로 출력해주는 메소드
	public void Print() {
		// 시(hour)에 대한 출력문
		if(this.hour<10) {
			System.out.print("0");
		}
		System.out.print(hour+":");
		// 분(min)에 대한 출력문
		if(this.min<10) {
			System.out.print("0");
		}
		System.out.print(min+":");
		// 초(sec)에 대한 출력문
		if(this.sec<10) {
			System.out.print("0");
		}
		System.out.println(sec);
	}
	
	// 2. 오전인지 오후인지를 출력해주고, 표준 시각대로 출력해주는 메소드
	public void ap() {
		// 오전인지 오후인지 출력
		if(hour<12) {
			System.out.print("현재는 오전입니다. AM ");
			Print();
		}
		else {
			System.out.print("현재는 오후입니다. PM ");
			hour-=12;	// 다음 연산에 지장을 줄 수 있기 때문에, 비추천하는 방법
			Print();
		}
	}
}

public class Ex_Clock {
	public static void main(String[] args) {
		// 객체 생성
		Clock c1=new Clock(9,10,30);
		Clock c2=new Clock(16,40,0);
		System.out.println();
		
		c1.Print();
		c2.Print();
		System.out.println();
		
		c1.ap();
		c2.ap();
	}
}



