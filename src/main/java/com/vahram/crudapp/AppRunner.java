package com.vahram.crudapp;


import com.vahram.crudapp.view.CommonView;
import com.vahram.crudapp.view.SkillView;
import com.vahram.crudapp.view.SpecialtyView;

import java.util.Locale;

public class AppRunner {
    public static void main(String[] args){
        CommonView commonView = new CommonView();
        commonView.start();
    }
}
