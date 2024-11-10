package com.vahram.crudapp;


import com.vahram.crudapp.view.SkillView;
import java.util.Locale;

public class AppRunner {
    public static void main(String[] args){
//        Locale locale = new Locale("ru", "RU");
//        Locale.setDefault(locale);

        SkillView skillView = new SkillView();

       skillView.runMenu();
    }
}
