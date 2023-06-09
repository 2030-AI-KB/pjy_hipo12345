import java.util.Scanner;

public class array { // 배열 
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		// 배열 :: 같은 타입의 여러 값을 저장할 수 있는 변수 공간
		
		// 배열 선언
		// (타입) (배열이름)[] = new (타입) [배열크기];
		int arr[]=new int [5];	// "이름이 arr인 정수형 배열을 선언하고, 이 배열의 크기를 5로 하라."
		// arr 배열의 배열번호는 0~4번까지 있다. (5번은 없음)
		
		// 배열값 저장 :: (배열이름)[배열번호] = (저장할 값);
		arr[0]=100;		// "arr 배열의 0번째 공간에 100을 저장하라."
		
		// 배열값 얻어오는 방법
		//System.out.println("어떤 배열 공간의 값: "+arr[0]);
		
		
		// 예제 :: 5명의 학생 성적을 입력받고, 이들의 합계와 평균을 구하라.
		// 1. 5명의 학생 성적 입력
		// 학생 성적을 저장할 공간인 배열을 우선 선언한다.
		int score[]=new int [5];
		for(int i=0;i<5;i++) {
			score[i]=sc.nextInt();
		}
		
		// 2. 합계 구하기
		int sum=0;
		for(int i=0;i<5;i++) {
			sum+=score[i];	// 현재 sum에 i번째 score값을 더해서 저장하라.
		}
		
		// 3. 평균 구하기
		// [정수]/[정수] = [정수]
		// [실수]/[정수] = [실수]
		// [정수]/[실수] = [실수]
		double avg=(double)sum/5;
		
		// 4. 합계와 평균 출력하기
		System.out.println("성적 합계: "+sum);
		System.out.println("성적 평균: "+avg);
	}
}





