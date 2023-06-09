
public class Ex { // 연습문제 풀기
	public static void main(String[] args) {
		// 문제:: 369 게임의 규칙을 이용한 프로그램 만들기
		int i=1;

		// 무한 반복문으로 구현하기
		while(true) {
			// i의 값이 100이 되면, 반복문 종료
			if(i==100) {break;}
			
			// 십의 자리, 일의 자리 추출
			int n1=i/10;	// 십의 자리
			int n2=i%10;	// 일의 자리
			
//			- 숫자에 3, 6, 9가 있는 경우, "박수 짝"만 출력
			if(n1==3||n1==6||n1==9||n2==3||n2==6||n2==9) {
				System.out.println("박수 짝");
				i++;
				continue;
			}
//			if((n1%3==0&&n1!=0)||(n2%3==0&&n2!=0)) {
//				System.out.println("박수 짝");
//				i++;
//				continue;
//			}
			
//			- 숫자에 3, 6, 9가 없는 경우, 숫자를 그대로 출력
			System.out.println(i);
			i++;
		}
		// 위의 break문을 만나면 이쪽으로 이동함
	}
}
