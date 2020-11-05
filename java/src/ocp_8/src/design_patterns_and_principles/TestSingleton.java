package design_patterns_and_principles;

public class TestSingleton {

}

class Singleton {       //  simple singleton
    private static final Singleton singleton = new Singleton();
    private Singleton() {}
    public static Singleton getInstance() {
        return singleton;
    }
}

class LazySingleton {
    private  static  LazySingleton lazySingleton;
    private LazySingleton() {}
    public synchronized static LazySingleton getInstance() {
        if (lazySingleton == null)
            lazySingleton = new LazySingleton();        //  NOT THREAD SAFE BECAUSE lazySingleton not final
        return lazySingleton;                           //  need synchronized
    }
}


