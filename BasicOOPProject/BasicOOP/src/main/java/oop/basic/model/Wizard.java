package oop.basic.model;

/**
 * Created by USER on 9/8/2556.
 */
public class Wizard extends BaseClass {
    public static int createdTimes = 0;

    public Wizard() {
        super("Wizard");
        createdTimes++;
    }

    @Override
    protected int getStrength(int lvl) {
        int bonusA = lvl / 5;
        return lvl / 2 + bonusA;
    }

    @Override
    protected int getAgility(int lvl) {
        int bonusA = lvl / 3;
        return lvl + bonusA;
    }

    @Override
    protected int getIntelligent(int lvl) {
        int bonusA = lvl / 5;
        int bonusB = lvl / 10;
        int bonusC = lvl / 20;
        return lvl * 2 + bonusA * 2 + bonusB * 3 + bonusC * 5;
    }

    @Override
    public int getAllClassCreatedTimes() {
        return super.createdTimes;
    }

    @Override
    public int getClassCreatedTimes() {
        return createdTimes;
    }
}
