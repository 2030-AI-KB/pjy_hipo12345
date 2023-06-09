import java.util.Scanner;

public class Ex1330 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		// 백준 1330번 문제 :: 두수 비교하기
		// 두 수를 입력받고, 이들의 크기를 비교하라. (결과값: >, <, ==)
		
		// 1. 두 수를 입력받기
		int a=sc.nextInt();
		int b=sc.nextInt();
		
		// 2. 비교 결과 출력하기
		if(a==b) {	// a와 b의 값이 같다면,
			System.out.println("==");
		}
		else if(a<b) {	// a와 b가 같지 않고, a가 b보다 작다면,
			System.out.println("<");
		}
		else {	// 위의 조건들을 모두 만족하지 않는 경우(a가 b보다 크다면),
			System.out.println(">");
		}
	}
}



