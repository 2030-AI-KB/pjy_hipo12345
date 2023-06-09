import java.util.Scanner;
// "java.util.Scanner를 현재 파일에 포함한다."

public class review { // review
	// 실행을 할 때, 메인 함수에 있는 내용만 실행한다.
	public static void main(String[] args) {
		// 출력문
		System.out.println("println 사용");	// () 안의 내용 + 줄바꿈("\n")을 출력
		System.out.print("print 사용");		// () 안의 내용만 출력
		
		// 변수 :: "변할 수 있는 숫자", 
		// ;(세미콜론) :: 문장을 끝내는 역할, "온점의 역할"
		// 변수 선언(생성) :: [자료형/타입] [변수이름];
		// 값 저장 :: [변수이름] = [저장할 값];
		// 변수 초기화 :: [자료형/타입] [변수이름] = [저장할 값];
		
		// 입력문
		Scanner sc=new Scanner(System.in);	// "Scanner를 sc라는 이름으로 선언한다/사용한다."
		int i=sc.nextInt();
		long l=sc.nextLong();
		float f=sc.nextFloat();
		double d=sc.nextDouble();
		char c=sc.next().charAt(0);
		String s=sc.next();
	}
}
