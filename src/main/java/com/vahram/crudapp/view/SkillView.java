package com.vahram.crudapp.view;

import com.sun.jdi.Value;
import com.vahram.crudapp.controller.SkillController;
import com.vahram.crudapp.model.Skill;
import com.vahram.crudapp.repository.GsonSkillRepositoryImpl;
import com.vahram.crudapp.repository.SkillRepository;

import java.security.Key;
import java.util.*;

import static java.awt.SystemColor.menu;
import static java.lang.System.*;

public class SkillView {
    private final SkillController skillController = new SkillController();
    private final Scanner scanner = new Scanner(System.in);

    public void runMenu() {
        int userInput;
        while (true) {
            printMenu();
            userInput = getInput();
            performAction(userInput);
        }
    }

    private void printMenu() {
        System.out.println("Выберите операцию: ");
        System.out.println("1 - создания скила");
        System.out.println("2 - получения скила");
        System.out.println("3 - обновление скила");
        System.out.println("4 - удаление скила");
        System.out.println("5 - получение скилов");
        System.out.println("9 - Назад");
    }

    private int getInput() {
        Scanner sc = new Scanner(System.in);
        int userInput = -1;
        while (userInput < 0 || userInput > 9) {
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
                getSkill();
                break;
            case 3:
                updateSkill();
                break;
            case 4:
                deleteSkill();
                break;
            case 5:
                getSkills();
                break;
            case 9:
                System.out.println("Back");
//                System.exit(0); эту стркоу удалить
                break;
        }
    }

    private void getSkills() {
        List<Skill> skills = skillController.getAll();
        System.out.println("Список скиллов" + skills);
    }

    private void createSkill() {
        System.out.println("Enter skill name: ");
        String skillName = scanner.nextLine();
        Skill createdSkill = skillController.createSkill(skillName);
        System.out.println("Created skill: " + createdSkill);
        skillController.createSkill(skillName);
    }

    private void updateSkill() {
        List<Skill> skills = skillController.getAll();
        out.println(skills);
        out.println("Укажите айди скила");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Укажите имя");
        String name = scanner.nextLine();
        Skill updatedSkill = skillController.updateSkill(id, name);
        System.out.println("Обновленный скил " + updatedSkill);

    }

    private void deleteSkill() {
        System.out.println("Enter Skill id");
        Integer skId = scanner.nextInt();
        skillController.deleteSkill(skId);
        out.println("Вы удалили скил " + skId);
    }

    private void getSkill() {
        System.out.println("Enter id");
        Integer skillId = scanner.nextInt();
        System.out.println("entered id: " + skillId);
        Skill currentSkill = skillController.getSkill(skillId);
        System.out.println("Skill: " + currentSkill);
    }
}
