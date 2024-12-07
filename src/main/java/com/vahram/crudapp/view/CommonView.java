package com.vahram.crudapp.view;

import java.util.Scanner;

public class CommonView {
    SkillView skillView = new SkillView();
    SpecialtyView specialtyView = new SpecialtyView();
    DeveloperView developerView = new DeveloperView();
    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Главное меню ---");
            System.out.println("\n--- Выберите слой для работы: ---");
            System.out.println("1. Меню Skill");
            System.out.println("2. Меню Developer");
            System.out.println("3. Меню Specialty");
            System.out.println("4. Выход");
            System.out.print("Введите номер действия: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    skillView.runMenu();
                    break;
                case "2":
                    developerView.runMenu();
                    break;
                case "3":
                    specialtyView.runMenu();
                    break;
                case "4":
                    System.out.println("Выход из приложения...");
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }



    }
}

