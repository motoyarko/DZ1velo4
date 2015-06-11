package com.sourceit;

/**
 * Created by motoyarko on 02-Jun-15.
 */
public class CrossCountry extends AdultBicicle implements Calories{


    @Override
    boolean checkBicicleType(Bicicle bicicle) {
        if (bicicle.getBicicleType().equals("crosscountry")) {
            return true;
        }

        return false;
    }

    @Override
    public float calcCalories(User user, Bicicle bicicle) {
        boolean result = checkBicicleType(bicicle);
        if (result) {
            return user.getGirth() + user.getAge() + user.getHeight() + user.getWeight() + bicicle.getBaseSize() + bicicle.getWheelsDiameter();

        }
        return 0;
    }
}
