package com.vahram.crudapp.view;

import com.vahram.crudapp.controller.SkillController;
import com.vahram.crudapp.model.Skill;

import java.util.Scanner;

public class SkillView {
    private final SkillController skillController = new SkillController();
    private final Scanner scanner = new Scanner(System.in);

    public void createSkill() {
        System.out.println("Enter skill name: ");
        String skillName = scanner.nextLine();
        Skill createdSkill = skillController.createSkill(skillName);
        System.out.println("Created skill: " + createdSkill);
    }

    public void updateSkill() {
        System.out.println("Choose skill");
        Integer updatedSkill = scanner.nextInt();

    }

    public void deleteSkill() {
        System.out.println("Enter Skill id");
        Integer skId = scanner.nextInt();
        skillController.deleteSkill(skId);
    }

    public Skill getSkill() {
        System.out.println("Get skll");
        Integer skillId = scanner.nextInt();
        Skill currentSkill = skillController.getSkill(skillId);
        System.out.println("Getting skill: " + currentSkill);
        return currentSkill;
    }
}
