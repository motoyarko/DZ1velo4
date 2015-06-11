package com.sourceit;

/**
 * Created by motoyarko on 02-Jun-15.
 */
public class Bicicle {

    private Long wheelsDiameter;
    private Long baseSize;
    private boolean isBrakesExist;
    //boolean isBrakesExist1;
    private String bicicleType;



    public String getBicicleType() {

        return bicicleType;
    }

 /*   public Bicicle(Long wheelsDiameter, Long baseSize, boolean isBrakesExist){
        this.wheelsDiameter = wheelsDiameter;
        this.baseSize = baseSize;
        this.isBrakesExist = isBrakesExist;



    }
*/
    public float wheelsLength(){
        float legth = (float) Math.PI * wheelsDiameter;
        return legth;
    }

    public float getBaseSize() {
        return baseSize;
    }

    public Long getWheelsDiameter() {
        return wheelsDiameter;
    }

    public boolean getIsBrakesExist() {
        return isBrakesExist;
    }

    public void setWheelsDiameter(Long wheelsDiameter) {
        this.wheelsDiameter = wheelsDiameter;
    }

    public void setBaseSize(Long baseSize) {
        this.baseSize = baseSize;
    }

    public void setIsBrakesExist(boolean isBrakesExist) {
        this.isBrakesExist = isBrakesExist;
    }

    public void setBicicleType(String bicicleType) {
        this.bicicleType = bicicleType;
    }

}
