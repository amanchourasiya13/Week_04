package Day06_AnnotationsAndReflection.Reflection.AdvancedLevelProblems.MethodExecutionTiming;

class MyClass {
    public void method1() {
        try { Thread.sleep(100); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }

    public void method2() {
        try { Thread.sleep(200); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
}