package springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
	
	// 모든접근지정자, 모든반환타입, springaop.service를 포함한 모든하위패키지, Impl로 끝나는 모든클래스, 모든메소드, 모든파라미터
	@Pointcut("execution(* springaop.service..*Impl.*(..))")
	public void pointcut1() {
	}
	
//	@After("pointcut1()")
//	public void printMethodName() {
//		System.out.println("@After printMethodName 호출됨!");
//	}
	
	// listPerson메소드가 호출되기 전 "listPerson메서드 호출 전!" 출력
	@Before("pointcut1()")
	public void beforeListPersonMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		if(methodName.equals("listPerson")) {
			System.out.println("@Before " + methodName + "메서드 호출 전!");
		}
	}
	
	// getPerson메소드가 호출된 후 "getPerson메소드 호출 후!" 출력
	@After("pointcut1()")
	public void afterGetPersonMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		if(methodName.equals("getPerson")) {
			System.out.println("@After " + methodName + "메서드 호출 후!");
		}
	}
	
	
	// deletePerson메소드 내에서 예외를 발생시키고 "deletePerson메소드 예외 발생! (예외메세지:xxxxxx)" 출력
	@AfterThrowing(pointcut="pointcut1()", throwing="ex")
	public void afterThrowingDeleteMethod(JoinPoint joinPoint, Throwable ex) {
		String methodName = joinPoint.getSignature().getName();
		if(methodName.equals("deletePerson")) {
			System.out.println("@AfterThrowing " + methodName + "메소드 예외 발생! (예외메세지: " + ex.getMessage() + ")");
		}
	}
	
	// insertPerson와 updatePerson메소드 호출 전과 후에 "xxxxxxPerson메소드 호출 전!"
	// 과 "xxxxxxPerson메소드 호출 후!" 출력
//	@Around("pointcut1()")
//	public void aroundPersonMethod(ProceedingJoinPoint joinPoint) throws Throwable {
//		String methodName = joinPoint.getSignature().getName();
//		if(methodName.equals("insertPerson") || methodName.equals("updatePerson")) {
//			System.out.println("@Around " + methodName + "메소드 호출 전!");
//			try {
//				joinPoint.proceed();
//			} finally {
//				System.out.println("@Around " + methodName + "메소드 호출 후!");
//			}
//		}
//	}

}













