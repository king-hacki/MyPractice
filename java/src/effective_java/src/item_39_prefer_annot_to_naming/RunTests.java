package item_39_prefer_annot_to_naming;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RunTests {

    public static void main(String[] args) throws Exception {

        int tests = 0;
        int passed = 0;

        Class<?> testClass = Class.forName("item_39_prefer_annot_to_naming.Sample");
        for (Method m : testClass.getDeclaredMethods()) {               //  return array of all methods in the class or interface
            //  testing for Test.class
            if (m.isAnnotationPresent(Test.class)) {                    //  true if under method is annotation @Test
                tests++;
                try {
                    m.invoke(null);
                    passed++;
                } catch (InvocationTargetException wrappedExc) {
                    Throwable exc = wrappedExc.getCause();               //  getCause() — Get the thrown target exception.
                    System.out.println(m.getName() + " failed: " + exc);
                } catch (Exception exc) {
                    System.out.println("Invalid @Test: " + m.getName());
                }
            }

            //  testing for ExceptionTest.class
            if (m.isAnnotationPresent(ExceptionTest.class)) {
                tests++;
                try {
                    m.invoke(null);
                    System.out.printf("Test %s failed: no exception%n", m.getName());
                } catch (InvocationTargetException wrappedExc) {

                    Throwable exc = wrappedExc.getCause();
                    Class<? extends Throwable> excType = m.getAnnotation(ExceptionTest.class).value();

                    if (excType.isInstance(exc)) passed++;
                    else System.out.printf("Test %s failed: expected %s, got %s%n", m.getName(), excType.getName(), exc);
                } catch (Exception exc) {
                    System.out.println("Invalid @Test: " + m.getName());
                }
            }
        }
        System.out.printf("Passed: %d, Failed: %d%n", passed, tests - passed);
    }

}
