import java.util.Scanner;

public class switch0412 { //switch
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// 예제:: 평점 입력받아서 학점을 출력하기
		// 1. 평점 입력받기
		int score;
		score=sc.nextInt();
				
		// 2. 평점에 따라 학점 출력하기
		// 평점의 값에 따라 학점을 다르게 출력해야함 -> 조건문 사용
		// switch(값을 비교할 변수 v) {
		//	case [값1]:		
		//		[값1]과 v가 같을 경우 실행할 명령문
		//		break;
		// 	case [값2]:
		//		[값2]와 v가 같을 경우 실행할 명령문
		//		break;
		//	default :
		//		위의 case에 제시된 값들과 모두 같지 않을 경우 실행할 명령문
		// }
		
		score=score/10;		// 현재 score의 값에 10을 나눈 몫을 score에 대입하라.
			// 오른쪽의 score는 값을 가져오는 용도
			// 왼쪽의 score는 저장할 공간
		System.out.println("연산 처리된 값: "+score);
		switch(score) {
		case 10:
		case 9:
			System.out.println("A학점입니다.");
			break;
		case 8:
			System.out.println("B학점입니다.");
			break;
		case 7: 
			System.out.println("C학점입니다.");
			break;
		case 6: 
			System.out.println("D학점입니다.");
			break;
		default:
			System.out.println("F학점입니다.");
		}
		
		if(score==10 || score==9) {
			System.out.println("A학점입니다.");
		}
		else if(score==8) {
			System.out.println("B학점입니다.");
		}
		else if(score==7) {
			System.out.println("C학점입니다.");
		}
		else if(score==6) {
			System.out.println("D학점입니다.");
		}
		else {
			System.out.println("F학점입니다.");
		}
	}
}
