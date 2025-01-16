package com.vahram.crudapp.view;

import com.vahram.crudapp.controller.SpecialtyController;
import com.vahram.crudapp.model.Specialty;

import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class SpecialtyView {
    private final SpecialtyController specialtyController = new SpecialtyController();
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
        System.out.println("1 - создания специальности");
        System.out.println("2 - получения специальности");
        System.out.println("3 - обновление специальности");
        System.out.println("4 - удаление специальности");
        System.out.println("5 - получение специальностей");
        System.out.println("9 - Назад"); //Заменил "Выход" на "Назад"
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
                createSpecialty();
                break;
            case 2:
                getSpecialty();
                break;
            case 3:
                updateSpecialty();
                break;
            case 4:
                deleteSpecialty();
                break;
            case 5:
                getSpecialties();
                break;
            case 9:
                System.out.println("Back"); //Заменил Exit на Back
                break;
//                System.exit(0);
//                break;
        }
    }

    private void getSpecialties() {
        List<Specialty> specialties = specialtyController.getAll();
        System.out.println("Список специальностей" + specialties);
    }

    private void createSpecialty() {
        System.out.println("Enter specialty name: ");
        String specialtyName = scanner.nextLine();
        Specialty createdSpecialty = specialtyController.createSpecialty(specialtyName);
        System.out.println("Created skill: " + createdSpecialty);
    }

    private void updateSpecialty() {
        List<Specialty> specialties = specialtyController.getAll();
        out.println(specialties);
        out.println("Укажите айди специальности");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Укажите имя");
        String name = scanner.nextLine();
        Specialty updatedSpecialty = specialtyController.updateSpecialty(id, name);
        System.out.println("Обновленный скил " + updatedSpecialty);

    }

    private void deleteSpecialty() {
        System.out.println("Enter Specialty id");
        Integer spId = scanner.nextInt();
        specialtyController.deleteSpecialty(spId);
        out.println("Вы удалили скил " + spId);
    }

    private void getSpecialty() {
        System.out.println("Enter id");
        Integer specialtyId = scanner.nextInt();
        System.out.println("entered id: " + specialtyId);
        Specialty currentSpecialty = specialtyController.getSpecialty(specialtyId);
        System.out.println("Specialty: " + currentSpecialty);
    }
}
