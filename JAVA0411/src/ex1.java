import java.util.Scanner;

public class ex1 { // 예제 1
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);	// 딱 한번만 작성하면 됌
		
//		- 이름, 나이, 키, 혈액형을 "입력"받기
		String name=sc.next();	// 이름 입력받기
		int age=sc.nextInt();	// 나이 입력받기
			// 정수 입력문에 실수를 입력할 경우, 소수점 밑의 숫자를 모두 제외하고 저장함
			
		double height=sc.nextDouble();	// 키를 입력받기
		char blood=sc.next().charAt(0); // 혈액형을 입력받기 
		
//		- 입력받은 걸 그대로 출력하기 (양식은 자유롭게)
		System.out.println("이름: "+name);
		System.out.println("나이: "+age);
		System.out.println("키: "+height);
		System.out.println("혈액형: "+blood);
	}
}
