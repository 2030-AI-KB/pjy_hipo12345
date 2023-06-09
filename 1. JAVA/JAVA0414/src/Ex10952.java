import java.util.Scanner;

public class Ex10952 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		// 백준 10952번 문제 :: A+B (5)
		// 각 테스트 케이스의 2개 값 합을 구하여라.
		// 입력의 마지막에는 0 0이 입력된다 -> 무한 반복문, break 활용
		
		while(true) {	// (일단은) 무한대로 실행한다.
			// 입력쌍이 얼마나 있을지 모르지만, 우선은 입력을 받는다.
			// 입력값에 따라 실행을 종료할지 말지가 결정되기 때문
			int a=sc.nextInt();
			int b=sc.nextInt();
			
			// 우선은 실행을 할지 말지를 결정하기
			if(a==0 && b==0) {break;}
			
			// 입력값을 더한 결과를 출력하기
			System.out.println(a+b);
		}
		// break문을 만나면, 이쪽으로 이동한다. (무한 반복문 탈출)
	}
}
