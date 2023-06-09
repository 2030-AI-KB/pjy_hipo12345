import java.util.Scanner;

public class Ex_Clock {
	// 문제. 현재 시각을 입력받고 아래의 함수를 실행하게끔 하여라
	// 1) clock() :: 현재 시각(시, 분, 초)을 전달받아 양식대로 출력하는 함수
	static void clock(int hour, int min, int sec) {
		// 시, 분, 초에 대한 정보 전달 -> 매개변수를 3개로 선언
		// void를 반환형으로 선언할 때에는, return문 사용X
		System.out.println("현재 시각은 "+hour+"시 "+min+"분 "+sec+"초입니다.");
	}
	
	// 2) ap() :: 현재가 오전인지 오후인지 출력하는 함수
	static void ap(int hour) {
		if(hour<12) {	// "시 정보다 12보다 작다면"
			System.out.println("현재는 오전입니다.");
		}
		else {		// "시 정보가 12보다 크거나 같다면"
			System.out.println("현재는 오후입니다.");
		}
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// 1. 시, 분, 초에 대한 정보 입력받기
		int h=sc.nextInt();
		int m=sc.nextInt();
		int s=sc.nextInt();
		
		// 2. 현재 시각 출력하는 함수 호출(참조)
		clock(h, m, s);
		
		// 3. 오전인지 오후인지를 출력하는 함수 호출(참조)
		ap(h);
	}
}



