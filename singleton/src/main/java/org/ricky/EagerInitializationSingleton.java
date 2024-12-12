package org.ricky;

/**
 * @author Ricky
 * @version 1.0
 * @date 2024/12/12
 * @className EagerInitializationSingleton
 * @desc 饿汉式单例
 */
public class EagerInitializationSingleton {

    /**
     * volatile: 禁止重排序，所有的写（write）操作都将发生在读（read）操作之前
     */
    private volatile static EagerInitializationSingleton instance;

    private EagerInitializationSingleton() {
        System.out.println("Private constructor.");
    }

    /**
     * 双重检查
     * 执行双重检查是因为，如果多个线程同时了通过了第一次检查，并且其中一个线程首先通过了第二次检查并实例化了对象，那么剩余通过了第一次检查的线程就不会再去实例化对象
     * 这样，除了初始化的时候会出现加锁的情况，后续的所有调用都会避免加锁而直接返回，解决了性能消耗的问题
     */
    public static EagerInitializationSingleton getInstance() {
        if(instance == null) {
            synchronized (EagerInitializationSingleton.class) {
                if(instance == null) {
                    instance = new EagerInitializationSingleton();
                }
            }
        }
        return instance;
    }

    public void method() {
        System.out.println(this + ":method");
    }

}
