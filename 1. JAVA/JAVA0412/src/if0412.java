import java.util.Scanner;

public class if0412 { // IF
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// 연산자
		// 산술연산자 :: +, -, *, /(몫 나누기), %(나머지 나누기)
		// 대입연산자 :: = (오른쪽의 값을 왼쪽에 "대입"한다.)
		// 비교연산자 :: <, <=, >, >=, ==("같다"), !=("다르다")
		// 논리연산자 :: &&("그리고"), ||("또는")
		
		// 조건문 (if) :: "만약에 ~한다면", 조건을 따지면서 명령문을 선택하게끔 하는 구문
		// if - else if - else, switch
		// else if, else는 생략 가능하지만, if를 제외하고 else if, else를 사용하면 오류 발생
		
		// 예제:: 입력받는 평점에 따라 학점을 출력하기
		// 1. 평점 입력받기
		int score;
		score=sc.nextInt();
		
		// 2. 평점에 따라 학점 출력하기
		// 평점의 값에 따라 학점을 다르게 출력해야함 -> 조건문 사용
		// if(조건문) {	// if(조건) -> "만약 [조건]을 만족한다면,"
		//		위 조건문을 만족할 때, 실행할 명령문들
		//	}
		if(score>=90) {		// score의 값이 90보다 크거나 같다면,
			System.out.println("A학점입니다.");
		}
		else if(score>=80) {	// 위 조건문을 만족하지 않고, score가 80 이상이라면,
			System.out.println("B학점입니다.");
		}
		else if(score>=70) {
			System.out.println("C학점입니다.");
		}
		else if (score>=60) {
			System.out.println("D학점입니다.");
		}
		else {	// 위 조건들을 모두 만족하지 않는다면,
			System.out.println("F학점입니다.");
		}
	}
}
