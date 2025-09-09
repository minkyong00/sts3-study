package springaop_exam.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MemberAdvice {
	
	@Pointcut("execution(* springaop_exam.service..*Impl.*(..))")
	public void allMethodPointcut() {
	}

	@Pointcut("execution(* springaop_exam.service.impl.*ServiceImpl.select*(..))")
	public void selectPointcut() {
	}
	
	@Pointcut(
		"execution(int springaop_exam.service.impl.*ServiceImpl.insert*(springaop_exam.model.*))" +
			 "|| execution(int springaop_exam.service.impl.*ServiceImpl.update*(springaop_exam.model.*))"
			 +  "|| execution(int springaop_exam.service.impl.*ServiceImpl.delete*(..))"
			)
	public void CUDPointcut() {
	}
	
	
	//모든 dao의 메소드 호출 전 화면에 "[메소드명] 호출됨!" 출력
	@Before("allMethodPointcut()")
	public void beforeAllMethod(JoinPoint joinPoint) {
		System.out.println("[" + joinPoint.getSignature().getName() + "] 호출됨!");
	}
	
	// 모든 selectXXX 메소드 호출 전 화면에 "[메소드명] 데이터조회 로깅!" 출력
	@Before("selectPointcut()")
	public void beforeSelectMethod(JoinPoint joinPoint) {
		System.out.println("[" + joinPoint.getSignature().getName() + "] 데이터조회 로깅!");
	}
	
	//모든 insert, update, delete 메소드 호출 후 화면에 "[메소드명] 데이터변경 로그 등록됨!" 출력
	@After("CUDPointcut()")
	public void after(JoinPoint joinPoint) {
		System.out.println("[" + joinPoint.getSignature().getName() + "] 데이터변경 로그 등록됨!");
	}
	

}
