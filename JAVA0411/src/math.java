import java.util.Scanner;

public class math { // 수학 사칙연산 계산
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int n1,n2;
		n1=sc.nextInt();
		n2=sc.nextInt();
		
		System.out.println("덧셈 결과: "+(n1+n2));
		System.out.println("뺄셈 결과=" +(n1-n2));
		System.out.println("곱셈 결과" +(n1*n2));
		System.out.println("나눗셈 결과=" +(n1/n2));
	}

}
