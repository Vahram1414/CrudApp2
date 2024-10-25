package com.vahram.crudapp.controller;

import com.vahram.crudapp.model.Skill;
import com.vahram.crudapp.repository.GsonSkillRepositoryImpl;
import com.vahram.crudapp.repository.SkillRepository;

import java.util.List;

public class SkillController {
    private final SkillRepository skillRepository = new GsonSkillRepositoryImpl();

    public List<Skill> getAll() {
        return getAll();
    }

    public Skill getSkill(int id) {

        return skillRepository.getById(id);
    }

    public Skill createSkill(String name) {
        Skill skillToCreate = new Skill();
        skillToCreate.setName(name);
        return skillRepository.create(skillToCreate);
    }

    public Skill updateSkill(int id, String newName) {
        Skill skillToUpdate = new Skill();
        skillToUpdate.setId(id);
        skillToUpdate.setName(newName);
        return skillRepository.update(skillToUpdate);
    }

    public void deleteSkill(int id) {

        skillRepository.deleteById(id);
    }

//    public void updateSkill(Integer updSk) {
//        skillRepository.deleteById(id);
//    }
}
