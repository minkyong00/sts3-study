package springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LogAspect {
	
	public void printMethodName() {
		System.out.println("@After printMethodName 호출됨!");
	}
	
    // listPerson메소드가 호출되기 전 "listPerson메서드 호출 전!" 출력
	public void beforeListPersonMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		if(methodName.equals("listPerson")) {
			System.out.println("@Before " + methodName + "메서드 호출 전!");
		}
	}
	
	// getPerson메소드가 호출된 후 "getPerson메소드 호출 후!" 출력
	public void afterGetPersonMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		if(methodName.equals("getPerson")) {
			System.out.println("@After " + methodName + "메서드 호출 후!");
		}
	}
	
	// insertPerson와 updatePerson메소드 호출 전과 후에 "xxxxxxPerson메소드 호출 전!"
	// 과 "xxxxxxPerson메소드 호출 후!" 출력
	public void aroundPersonMethod(ProceedingJoinPoint joinPoint) throws Throwable {
		String methodName = joinPoint.getSignature().getName();
		if(methodName.equals("insertPerson") || methodName.equals("updatePerson")) {
			System.out.println("@Around " + methodName + "메소드 호출 전!");
			try {
				joinPoint.proceed();
			} finally {
				System.out.println("@Around " + methodName + "메소드 호출 후!");
			}
		}
	}
	
	
	// deletePerson메소드 내에서 예외를 발생시키고 "deletePerson메소드 예외 발생! (예외메세지:xxxxxx)" 출력
	public void afterThrowingDeleteMethod(JoinPoint joinPoint, Throwable ex) {
		String methodName = joinPoint.getSignature().getName();
		if(methodName.equals("deletePerson")) {
			System.out.println("@AfterThrowing " + methodName + "메소드 예외 발생! (예외메세지: " + ex.getMessage() + ")");
		}
	}

}
