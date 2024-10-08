package com.vahram.crudapp.controller;

import com.vahram.crudapp.model.Skill;
import com.vahram.crudapp.repository.GsonSkillRepositoryImpl;
import com.vahram.crudapp.repository.SkillRepository;

public class SkillController {
    private final SkillRepository skillRepository = new GsonSkillRepositoryImpl();
    public Skill createSkill(String name) {
        Skill skillToCreate = new Skill();
        skillToCreate.setName(name);
        return skillRepository.create(skillToCreate);
    }
}
