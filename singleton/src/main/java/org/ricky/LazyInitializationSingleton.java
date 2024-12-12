package org.ricky;

/**
 * @author Ricky
 * @version 1.0
 * @date 2024/12/12
 * @className LazyInitializationSingleton
 * @desc 懒汉式单例
 */
public class LazyInitializationSingleton {

    private LazyInitializationSingleton() {
        System.out.println("Private constructor.");
    }

    public static LazyInitializationSingleton getInstance() {
        return Holder.INSTANCE;
    }

    public void method() {
        System.out.println(this + ":method");
    }

    private static class Holder {
        private static final LazyInitializationSingleton INSTANCE = new LazyInitializationSingleton();
    }

}
