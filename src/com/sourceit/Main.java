package com.sourceit;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws FileNotFoundException {
	// write your code here
        User[] users = new User[10];
        Bicicle[] bicicles = new Bicicle[10];

        File dir = new File("C:\\Users\\motoyarko\\IdeaProjects\\DZ1velo4");   //set input file for users
        File inputFile = new File(dir, "users.txt");
        FileInputStream fis = new FileInputStream(inputFile);
        Scanner scanner = new Scanner(fis);

        File dir1 = new File("C:\\Users\\motoyarko\\IdeaProjects\\DZ1velo4");   //set input file for bicicles
        File inputFile1 = new File(dir1, "becicles.txt");
        FileInputStream fis1 = new FileInputStream(inputFile1);
        Scanner scanner1 = new Scanner(fis1);


        //users and bicycles DB inicialization
        parseUsers(users, scanner);
        parseBicicles(bicicles, scanner1);

        for (User user: users){
            for (Bicicle bicicle: bicicles) {
                CrossCountry cross = new CrossCountry();
                MountainBike mountain = new MountainBike();

                if (cross.checkBicicleType(bicicle)){
                    System.out.println( "user" + user.getName() +" ride on a " + bicicle.getBicicleType() + cross.calcCalories(user, bicicle));
                }
                else if (mountain.checkBicicleType(bicicle)) {
                    System.out.println("user" + user.getName() + " ride on a " + bicicle.getBicicleType() + mountain.calcCalories(user, bicicle));
                }
                else {
                    System.out.println("user" + user.getName() + " ride on a gnome");
                }
            }
        }

// test print database

       /* for (int a = 0; a < users.length; a++  ) {
            if (users[a] != null){
                System.out.println(users[a].getAge() +" "+ users[a].getHeight() +" "+ users[a].getWeight() +" "+ users[a].getGirth());
            }
        }
        for (int a = 0; a < bicicles.length; a++  ) {
            if (bicicles[a] != null){
                System.out.println(bicicles[a].getWheelsDiameter() +" "+ bicicles[a].getBaseSize() +" "+ bicicles[a].getIsBrakesExist() +" "+ bicicles[a].getBicicleType());
            }
        }*/
    }

    private static void parseBicicles(Bicicle[] bicicles, Scanner scanner1) {
        int i = 0;
        while (scanner1.hasNextLine()) {
            String jsonline = scanner1.nextLine();
            if (jsonline != null && !jsonline.equals("")){
                JSONObject jsonObject = (JSONObject) JSONValue.parse(jsonline);
                if (jsonObject != null) {
                    Long wheelsDiameter = (Long) jsonObject.get("wheelsDiameter");
                    Long baseSize = (Long) jsonObject.get("baseSize");
                    boolean isBrakesExist = (boolean) jsonObject.get("isBrakesExist");
                    String bicicleType = (String) jsonObject.get("bicicleType");
                    Bicicle bicicle = new Bicicle();
                    bicicle.setWheelsDiameter(wheelsDiameter);
                    bicicle.setBaseSize(baseSize);
                    bicicle.setIsBrakesExist(isBrakesExist);
                    bicicle.setBicicleType(bicicleType);
                    bicicles[i] = bicicle;
                    i++;
                }
            }
        }
    }

    private static void parseUsers(User[] users, Scanner scanner) {
        int i = 0;
        while (scanner.hasNextLine()) {     //users parsing

            String jsonline = scanner.nextLine();
            if (jsonline != null && !jsonline.equals("")) {
                JSONObject jsonObject = (JSONObject) JSONValue.parse(jsonline);
                if (jsonObject != null) {
                    Long age = (Long) jsonObject.get("age");            //why I can't use int?
                    Long height = (Long) jsonObject.get("height");
                    Long weight = (Long) jsonObject.get("weight");
                    Long girth = (Long) jsonObject.get("girth");
                    String name = (String) jsonObject.get("name");
                    User user = new User();
                    user.setAge(age);
                    user.setHeight(height);
                    user.setWeight(weight);
                    user.setGirth(girth);
                    user.setName(name);
                    users[i] = user;
                    i++;
                }
            }
        }
    }
}
