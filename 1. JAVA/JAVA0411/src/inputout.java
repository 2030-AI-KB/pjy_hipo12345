import java.util.Scanner;

public class inputout {
	public static void main(String[] args) {
//		 이름, 나이, 키, 혈액형을 입력 받기
		Scanner sc= new Scanner(System.in); // 딱 한번만 작성하면 ok
		
		String name = sc.next("박정연"); // 이름
		int age = sc.nextInt(29); //나이
		//정수 입력문에 실수를 입력할 경우, 오류는 발생하지 않지만 소수점을 빼고 저장한다.
		double height = sc.nextDouble(); //키
		char blood = sc.next().charAt(0); //혈액형
		
		System.out.println("이름: "+ name);
		System.out.println("나이: "+ age);
		System.out.println("키: "+ height);
		System.out.println("혈액형: "+ blood);
		
	}
}
