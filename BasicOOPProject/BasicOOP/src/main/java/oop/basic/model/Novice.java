package oop.basic.model;

import oop.basic.R;

/**
 * Created by USER on 9/8/2556.
 */
public class Novice extends BaseClass {
    public static int createdTimes = 0;

    public Novice() {
        super("Novice");
        createdTimes++;
    }

    @Override
    protected int getStrength(int lvl) {
        int bonusA = lvl / 5;
        int bonusB = lvl / 10;
        int bonusC = lvl / 20;
        return lvl + bonusA + bonusB + bonusC;
    }

    @Override
    protected int getAgility(int lvl) {
        int bonusA = lvl / 5;
        int bonusB = lvl / 10;
        int bonusC = lvl / 20;
        return lvl + bonusA + bonusB + bonusC;
    }

    @Override
    protected int getIntelligent(int lvl) {
        int bonusA = lvl / 5;
        int bonusB = lvl / 10;
        int bonusC = lvl / 20;
        return lvl + bonusA + bonusB + bonusC;
    }

    @Override
    final protected int getClassPicture() {
        return R.drawable.novice;
    }

    @Override
    public int getAllClassCreatedTimes() {
        return BaseClass.createdTimes;
    }

    @Override
    public int getClassCreatedTimes() {
        return createdTimes;
    }
}
