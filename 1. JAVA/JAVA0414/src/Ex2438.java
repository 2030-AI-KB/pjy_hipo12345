import java.util.Scanner;

public class Ex2438 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		// 백준 2438번 문제 :: 별 찍기
		// 입력값에 따라, 규칙적으로 별을 찍어내기
		
		// 1. 값 입력받기
		int n=sc.nextInt();
		
		// 2. 별 찍기 -> 2중 반복문
		// System.out.print("*");
		// System.out.println(); 만 써도 무관
		for(int i=1;i<=n;i++) {	// 행에 대한 출력을 제어하는 반복문 (i를 행으로 취급)
			for(int j=1;j<=i;j++) {	// 열에 대한 출력을 제어하는 반복문 (j를 열로 취급)
				System.out.print("*");
			}
			System.out.println();
		}
	}
}



