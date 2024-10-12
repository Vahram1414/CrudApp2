package com.vahram.crudapp;


import com.vahram.crudapp.view.SkillView;

public class AppRunner {
    public static void main(String[] args){
        SkillView skillView = new SkillView();
        skillView.createSkill();

        skillView.deleteSkill();

        skillView.updateSkill();

        skillView.deleteSkill();
    }
}
