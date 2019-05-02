package com.bod;

import com.bod.actions.Action;
import com.bod.entity.*;

import java.util.List;
import java.util.Scanner;

public class MainMenu {
    static Scanner s;
    static String optionString;
    static OptionsEnum optionsEnum;
    static Action action;
    static String name;

    public static void main(String[] args) {
        action = new Action();
        action.init();

        callSubMenu();
    }

    private static int[] multipleInput(int size) {
        name = s.nextLine();

        int[] servicesArr = new int[size];
        for (int i = 0; i < size; i++) {
            servicesArr[i] = s.nextInt();
        }

        return servicesArr;
    }

    private static void addFair() {
        System.out.println("Choose a fair type: Simple, Internet, TV, Premium");
        optionString = s.nextLine();

        Fare fare = null;
        int[] servicesArr;

        switch (getParam(optionString)) {
            case SIMPLE:
                System.out.println("input name, internalCalls(minutes), externalCalls(minutes), smsAmount(number)");

                servicesArr = multipleInput(3);

                fare = new SimpleBasedFare(name, servicesArr[0], servicesArr[1], servicesArr[2]);
                break;
            case INTERNET:
                System.out.println("input name, internalCalls(minutes), externalCalls(minutes), smsAmount(number), megabytes(number)");

                servicesArr = multipleInput(4);

                fare = new InternetBasedFare(name, servicesArr[0], servicesArr[1], servicesArr[2], servicesArr[3]);
                break;
            case TV:
                System.out.println("input name, internalCalls(minutes), externalCalls(minutes), smsAmount(number), tvChannels");

                servicesArr = multipleInput(4);

                fare = new TVBasedFare(name, servicesArr[0], servicesArr[1], servicesArr[2], servicesArr[3]);
                break;
            case PREMIUM:
                System.out.println("input name, internalCalls(minutes), externalCalls(minutes), smsAmount(number), megabytes, tvChannels");

                servicesArr = multipleInput(5);

                fare = new PremiumBasedFare(name, servicesArr[0], servicesArr[1], servicesArr[2], servicesArr[3], servicesArr[4]);
                break;
        }

        action.addFare(fare);
    }

    private static void addClient() {
        System.out.println("Enter name and fare name");
        String name, fareName;

        name = s.nextLine();
        fareName = s.nextLine();

        List<Entity> faresList = action.getFaresList();


        action.addClient(name, fareName);

    }

    private static void outputFaresList() {
        List<Fare> list = action.getFaresList();

        for (Entity l : list) {
            System.out.println(l.getName());
        }
    }

    private static void outputClientsList() {

        List<Client> list = action.getClientsList();

        for (Client l : list) {
            System.out.println(l.getName());
        }
    }

    private static void outputClientsNum() {
        System.out.println(action.getClientsNum());
    }

    private static void sortFares() {
        List<Fare> sortedList = action.sortFares();

        for (Fare f : sortedList) {
            System.out.println(f.getName() + " " + f.calculateFee());
        }
    }

    private static void findFares() {
        System.out.println("Input fee range(from/to)");

        Double from, to;

        from = s.nextDouble();
        to = s.nextDouble();

        List<Fare> list = action.getFaresFromRange(from, to);

        for (Fare f : list) {
            System.out.printf("%s: %s\n", f.getName(), f.calculateFee());
        }
    }


    private static void callSubMenu() {
        System.out.println("Choose the option(Add_fare, Add_client, Get_fares_list, Get_clients_list, Get_clients_num, Sort_fares, Find_fares, Exit):");

        s = new Scanner(System.in);
        optionString = s.nextLine();

        optionsEnum = getParam(optionString);

        switch (optionsEnum) {
            case ADD_FARE:
                addFair();
                break;
            case ADD_CLIENT:
                addClient();
                break;
            case GET_FARES_LIST:
                outputFaresList();
                break;
            case GET_CLIENTS_LIST:
                outputClientsList();
                break;
            case GET_CLIENTS_NUM:
                outputClientsNum();
                break;
            case SORT_FARES:
                sortFares();
                break;
            case FIND_FARES:
                findFares();
                break;
            case EXIT:
                return;
        }
        callSubMenu();
    }

    private static OptionsEnum getParam(String optionString) {
        OptionsEnum result = null;

        try {
            result = OptionsEnum.valueOf(optionString.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("incorrect option");
        }

        return result;
    }
}
