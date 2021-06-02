package sortingClean;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Timer;

@Aspect
public class RunningTime {

    private long startTime;

    @Pointcut("execution(void *.*.sort(..))")
    private void selectSort(){}

    @Before("selectSort()")
    public void before(JoinPoint jp) throws Throwable{
        System.out.println("Running sort in " + jp.getSignature().getName() + "." +
                jp.getThis().getClass().getSimpleName() + " with array size "
        + ((Integer[])jp.getArgs()[0]).length);
        startTime = System.currentTimeMillis();

    }

    @After("selectSort()")
    public void after(JoinPoint jp) throws Throwable{
        long endTime = System.currentTimeMillis();
        System.out.println("Function sort in " + jp.getSignature().getName() + "." +
                  jp.getThis().getClass().getSimpleName() +" took "
        + (endTime - startTime) + " ms");
    }

}
