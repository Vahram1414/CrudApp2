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
}
