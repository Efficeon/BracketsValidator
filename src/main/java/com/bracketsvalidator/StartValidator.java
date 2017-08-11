package com.bracketsvalidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StartValidator {
    public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        boolean isValidation = false;

        System.out.println("Введите данные для проверки: ");

        String line = readString();

        if (line != null){
            BracketsValidator bracketsValidator = new BracketsValidator();
            bracketsValidator.verify(line);
        }

        if (isValidation){
            System.out.println("Верно");
        } else {
            System.out.println("Не верно");
        }
    }

    public static String readString() {
        String line = null;
        try {
            line = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }
}
