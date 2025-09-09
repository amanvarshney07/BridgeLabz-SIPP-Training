import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {
}

class PerformanceTest {
    @LogExecutionTime
    public void fastMethod() {
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            sum += i;
        }
        System.out.println("Fast method completed with sum: " + sum);
    }
    
    @LogExecutionTime
    public void slowMethod() throws InterruptedException {
        Thread.sleep(100);
        System.out.println("Slow method completed");
    }
    
    @LogExecutionTime
    public void mediumMethod() {
        int result = 1;
        for (int i = 1; i <= 10000; i++) {
            result = (result * i) % 1000000;
        }
        System.out.println("Medium method completed with result: " + result);
    }
    
    public void regularMethod() {
        System.out.println("Regular method without timing");
    }
}

class ExecutionTimeDemo {
    public static void main(String[] args) throws Exception {
        PerformanceTest test = new PerformanceTest();
        Class<?> clazz = test.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        
        System.out.println("Executing methods with timing:");
        System.out.println("==============================");
        
        for (Method method : methods) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long startTime = System.nanoTime();
                method.invoke(test);
                long endTime = System.nanoTime();
                
                double executionTimeMs = (endTime - startTime) / 1_000_000.0;
                System.out.println("⏱️  " + method.getName() + " took: " + 
                                 String.format("%.3f", executionTimeMs) + " ms");
                System.out.println();
            } else {
                method.invoke(test);
            }
        }
        
        System.out.println("Performance Comparison:");
        System.out.println("======================");
        compareMethodPerformance(test);
    }
    
    static void compareMethodPerformance(PerformanceTest test) throws Exception {
        Method[] methods = test.getClass().getDeclaredMethods();
        
        for (Method method : methods) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long totalTime = 0;
                int runs = 5;
                
                for (int i = 0; i < runs; i++) {
                    long start = System.nanoTime();
                    method.invoke(test);
                    long end = System.nanoTime();
                    totalTime += (end - start);
                }
                
                double avgTimeMs = (totalTime / runs) / 1_000_000.0;
                System.out.println(method.getName() + " average: " + 
                                 String.format("%.3f", avgTimeMs) + " ms (" + runs + " runs)");
            }
        }
    }
}