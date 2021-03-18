package com.min.springboot.aspect;


import com.min.springboot.exception.entity.AIMSException;
import org.springframework.stereotype.Component;

/**
 * @author jxm
 */
@Aspect
@Component
public class AimsAspect {

    //todo 日志

    @Pointcut("execution(* com.min.springboot.service.impl.AimsServiceImpl.*(..))")
    public void aimsAspect(){}

    @AfterThrowing(value = "aimsAspect()", throwing = "e")
    public void catchThrow(Exception e){
        System.out.println("afterThrowing");
        throw new AIMSException(12);
    }

//    @Before("aimsAspect()")
//    public void catchThrow1(){
//        System.out.println("before");
//    }

//    @After("aimsAspect()")
//    public void after1(){
//        System.out.println("after");
//    }
//
//    @Around("aimsAspect()")
//    public void after2(){
//        System.out.println("Around");
//    }


}
