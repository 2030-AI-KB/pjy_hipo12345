import java.util.Scanner;

public class test { // 사칙연산 테스트
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in); 
		int score =sc.nextInt();
		int score2 =sc.nextInt();
		System.out.println("두점의 덧셈은"+(score + score2));
		System.out.println("두점의 뺄셈은"+(score - score2));
		System.out.println("두점의 곱셈은"+(score * score2));
		System.out.println("두점의 나눈 몫은"+(score / score2));
		System.out.println("두점의 나눈 나머지는"+(score % score2));
}
	
	
}
