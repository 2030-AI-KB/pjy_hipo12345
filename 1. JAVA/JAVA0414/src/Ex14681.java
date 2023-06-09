import java.util.Scanner;

public class Ex14681 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		// 백준 14681번 문제 :: 사분면 고르기
		// x축과 y축의 값을 입력받고, 이 좌표가 위치하는 사분면 번호를 출력하라.
		// (단, x값과 y값이 0이 아닌 값이라고 가정한다.)
		
		// 1. x축과 y축 값 입력받기
		int x=sc.nextInt();
		int y=sc.nextInt();
		
		// 2. 각각 음수, 양수인지에 따라 사분면 출력하기
//		if(x>0 && y>0) {	// x가 0보다 크고, y가 0보다 클때,
//			System.out.println("1");
//		}
//		else if(x<0 && y>0) {	// x가 0보다 작고, y가 0보다 클때,
//			System.out.println("2");
//		}
//		else if(x<0 && y<0) {	// x가 0보다 작고, y가 0보다 작을 때, 
//			System.out.println("3");
//		}
//		else {	// 위 조건문들을 모두 만족하지 못하면,
//			System.out.println("4");
//		}
		
		
		
		// 번외. 중첩 if문
		if(x>0) {	// x가 0보다 크다면, 
			if(y>0) {	// y가 0보다 크다면, 
				System.out.println("1");
			}
			else {	// y가 0보다 작다면,
				System.out.println("4");
			}
		}
		else {	// x가 0보다 작다면,
			if(y>0) {	// y가 0보다 크다면,
				System.out.println("2");
			}
			else {		// y가 0보다 작다면,
				System.out.println("3");
			}
		}
	}
}




