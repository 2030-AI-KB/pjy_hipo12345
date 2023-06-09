
public class for0412 { // for
	public static void main(String[] args) {
		// 제어변수 :: 반복문의 실행을 제어하는 역할
//		for(제어변수(v) 선언; 조건문; v에 대한 연산(증감연산자를 많이 씀)) {
//			조건문을 만족할 시 반복할 명령문
//		}
		// () 안은, 조건문을 제외하고는 모두 생략이 가능
		
		// 예제 :: 1부터 10까지 순서대로 출력하는 프로그램
//		int n=1;
//		while(n<=10) {
//			// 반복할 명령문 :: n을 1씩 증가, 출력문
//			System.out.println(n);
//			n++;	// n=n+1;
//		}
		
//		System.out.println("for문 사용");
//		for(int num=1; num<=10; num++) {
//			System.out.println(num);
//		}
		
		int a=1;
		System.out.println("a++의 값: "+(a++));	// a의 값을 넘기는 것을 먼저, + 연산을 나중에
		// 여기까지 출력했을 때는 1이지만, 실제 여기까지 왔을때 a의 값을 2
		System.out.println("++a의 값: "+(++a));	// + 연산을 먼저, a의 값을 넘기는 것을 나중에
	}
}
