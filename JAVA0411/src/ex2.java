import java.util.Scanner;

public class ex2 { // 예제 2
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// => 정수를 2개 입력받고
		int n1, n2;
		n1=sc.nextInt();	// 첫번째 정수 입력받기
		n2=sc.nextInt();	// 두번째 정수 입력받기
		
		// => +, -, *, /, % 연산의 결과를 출력하십시오.
		// + :: 출력값을 이어주는 역할
		System.out.println("덧셈 결과: "+(n1+n2));
		System.out.println("뺄셈 결과: "+(n1-n2));
		System.out.println("곱셈 결과: "+(n1*n2));
		System.out.println("몫 나눗셈 결과: "+(n1/n2));
		System.out.println("나머지 나눗셈 결과: "+(n1%n2));
	}
}
