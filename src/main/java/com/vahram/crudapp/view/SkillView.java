package com.vahram.crudapp.view;

import com.sun.jdi.Value;
import com.vahram.crudapp.controller.SkillController;
import com.vahram.crudapp.model.Skill;

import java.security.Key;
import java.util.*;

import static java.awt.SystemColor.menu;
import static java.lang.System.exit;

public class SkillView {
    private final SkillController skillController = new SkillController();
    private final Scanner scanner = new Scanner(System.in);
    boolean exit;

    public void runMenu() {
        while (!exit) {
            int userInput = getInput();
            performAction(userInput);
        }
    }

    private void printMenu() {
        System.out.println("Выберите операцию: ");
        System.out.println("1 - создания скила");
        System.out.println("2 - получения скила");
        System.out.println("3 - обновление скила");
        System.out.println("4 - удаление скила");
        System.out.println("9 - Выход");
    }

    private int getInput() {
        Scanner sc = new Scanner(System.in);
        int userInput = -1;
        while (userInput < 0 || userInput == 9) {
            try {
                System.out.println("Введите цифру");
                userInput = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод!");
            }
        }
        return userInput;
    }

    private void performAction(int userInput) {
                switch (userInput) {
            case 1:
                createSkill();
                break;
            case 2:
                updateSkill();
                break;
            case 3:
                deleteSkill();
                break;
            case 4:
                deleteSkill();
                break;
            case 9:
                exit = true;
    }

//    public static void start() {
//
//        System.out.println("Нажмите 0 для вызова меню");
//        int userInpout = sc.nextInt();
//        System.out.println("1 - создания скила , 2 - получения скила, 3 - обновление скила, 4 - удаление скила, 5 - поучение всех скилов, 9 - выход");
//        sc.nextInt();
//        System.out.println("Вы выбрали " + menu);

//        switch (userInout2) {
//            case 1:
//                System.out.println(menu.get(1));
//                break;
//            case 2:
//                System.out.println(menu.get(2));
//                break;
//            case 3:
//                System.out.println(menu.get(3));
//                break;
//            case 4:
//                System.out.println(menu.get(4));
//                break;
//            case 5:
//                System.out.println(menu.get(5));
//            case 9:
//                break;
//        }

//        int userInpout = sc.nextInt();
//        int i = sc.nextInt(userIpout3 = 9);
//        sc.nextInt(userIpout3 = 9);
//        while (userInpout == sc.nextInt(9));
//        if (userInpout == 1) {
//            System.out.println("Вы создали скил " + menu.get(1));
//        } else if (userInpout == 2) {
//            System.out.println("Вы получили скил " + menu.get(2));
//        } else if (userInpout == 3) {
//            System.out.println("Вы обновили скил " + menu.get(3));
//        } else if (userInpout == 4) {
//            System.out.println("Вы удалили скил " + menu.get(4));
//        } else if (userInpout == 5) {
//            System.out.println("Вы получили все скилы " + menu.get(5));
//        } else if (userInpout == 9) {
//            sc.close();
//        } else {
//            sc.nextInt();
//        }

    }



    private void createSkill() {
        System.out.println("Enter skill name: ");
        String skillName = scanner.nextLine();
        Skill createdSkill = skillController.createSkill(skillName);
        System.out.println("Created skill: " + createdSkill);
        skillController.createSkill(skillName);
    }

    private void updateSkill() {
        System.out.println("Choose skill");
        Integer updSk = scanner.nextInt();
//        skillController.updateSkill(updSk);

    }

    private void deleteSkill() {
        System.out.println("Enter Skill id");
        Integer skId = scanner.nextInt();
        skillController.deleteSkill(skId);
    }

    private Skill getSkill() {
        System.out.println("Enter id");
        Integer skillId = scanner.nextInt();
        Skill currentSkill = skillController.getSkill(skillId);
        System.out.println("entered id: " + currentSkill);
        skillController.getSkill(skillId);
        return currentSkill;
    }
}
