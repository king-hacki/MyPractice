package type_information;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;


public class JavaDynamicProxy {

    public static void main(String[] args) {

      

        //  call method invoke in MethodSelector
        SomeMethods proxy = (SomeMethods) Proxy.newProxyInstance(       //  Returns a proxy instance for the specified interfaces
                SomeMethods.class.getClassLoader(),     //  Returns the class loader for the class (the class loader to define the proxy class)
                new Class[]{ SomeMethods.class },       // the list of interfaces for the proxy class to implement
                new MethodSelector(new Implementation()));      //  the invocation handler to dispatch method invocations to
        proxy.boring1();                                        //  a proxy instance with the specified invocation handler of a
        proxy.boring2();                                        //  proxy class that is defined by the specified class loader
        proxy.interesting("bonobo");                        //  and that implements the specified interfaces
        proxy.boring3();

    }
}

/*

    Each proxy instance has an associated invocation handler.
    When a method is invoked on a proxy instance, the method
    invocation is encoded and dispatched to the {@code invoke}
    method of its invocation handler.

 */

class MethodSelector implements InvocationHandler {
    private final Object proxied;
    public MethodSelector(Object proxied) {
        this.proxied = proxied;
    }
    /*

     * @param   proxy the proxy instance that the method was invoked on
     *
     * @param   method the {@code Method} instance corresponding to
     * the interface method invoked on the proxy instance.  The declaring
     * class of the {@code Method} object will be the interface that
     * the method was declared in, which may be a superinterface of the
     * proxy interface that the proxy class inherits the method through.
     *
     * @param   args an array of objects containing the values of the
     * arguments passed in the method invocation on the proxy instance,
     * or {@code null} if interface method takes no arguments.
     * Arguments of primitive types are wrapped in instances of the
     * appropriate primitive wrapper class, such as
     * {@code java.lang.Integer} or {@code java.lang.Boolean}.

     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().equals("interesting"))
            System.out.println("Proxy detected the interesting method");
        return method.invoke(proxied, args);
    }
}

interface SomeMethods {
    void boring1();
    void boring2();
    void interesting(String arg);
    void boring3();
}

class Implementation implements SomeMethods {

    public void boring1() {
        System.out.println("boring1");
    }

    public void boring2() {
        System.out.println("boring2");
    }

    public void interesting(String arg) {
        System.out.println("interesting " + arg);
    }

    public void boring3() {
        System.out.println("boring3");
    }
}