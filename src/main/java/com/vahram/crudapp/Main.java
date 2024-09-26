package com.vahram.crudapp;

import com.vahram.crudapp.model.Skill;
import com.vahram.crudapp.repository.GsonSkillRepositoryImpl;
import com.vahram.crudapp.repository.SkillRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        GsonSkillRepositoryImpl gsri = new GsonSkillRepositoryImpl();
        
//        Skill mySkill = gsri.getById(5);
        Skill mySkill = new Skill();
        mySkill = gsri.getById(5);
        mySkill = gsri.update(mySkill);
        gsri.deleteById(6);
        System.out.println(mySkill);








    }
}
