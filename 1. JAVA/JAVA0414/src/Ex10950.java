import java.util.Scanner;

public class Ex10950 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		// 백준 10950번 문제 :: A+B (3)
		
		// 1. 숫자 쌍의 개수 입력받기
		int n=sc.nextInt();
		
		// 2. [각 숫자쌍 입력 및 덧셈 연산 출력] 반복 수행
		for(int i=1;i<=n;i++) {	// i는 1~5 순서로 변동됨
			// 각 숫자쌍 입력
			int a=sc.nextInt();
			int b=sc.nextInt();
			
			// 덧셈 연산 수행 및 저장
			int sum=a+b;
			
			// 덧셈 결과 출력
			System.out.println(sum);
		}
	}
}




