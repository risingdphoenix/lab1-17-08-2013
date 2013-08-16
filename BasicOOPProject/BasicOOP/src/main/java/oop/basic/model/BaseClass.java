package oop.basic.model;

/**
 * Created by USER on 9/8/2556.
 */
public abstract class BaseClass implements GetCreatedTimes {
    // final variable can assign value only once
    final private String mClassName;

    // all object will access the same static variable
    public static int createdTimes = 0;

    public BaseClass(String className) {
        // assign value to final variable
        mClassName = className;
        createdTimes++;
    }

    // final method can not be overridden
    final public String getClassName() {
        return mClassName;
    }

    // abstract method must be implemented in subclass
    abstract protected int getStrength(int lvl);
    abstract protected int getAgility(int lvl);
    abstract protected int getIntelligent(int lvl);

    /* TODO: create method get class picture id */

}
