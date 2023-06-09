import java.util.Scanner;

public class Ex10872 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		// 백준 10872번 문제 :: 팩토리얼
		// 0! = 1
		// 10! = 10*9*8*7*6*5*4*3*2*1
		
		// 1. 값 입력받기
		int n=sc.nextInt();
		
		// 2. 결과를 저장할 변수 만들기
		int result=1;
		
		// 3. 팩토리얼 곱셈 연산 수행 (for문)
		for(int i=1;i<=n;i++) {		// i는 1~n까지 변동이 있음
			result*=i;		// result에 순차적으로 1~n까지 곱함
		}
		
		// 3. 팩토리얼 곱셈 연산 수행 (while문)
		while(n>0) {	// n이 양수라면
			result*=n;
			n--;
		}
		// n이 0이 되는 순간에는, while문 종료
		
		// 4. 결과값 출력
		System.out.println(result);
	}
}


