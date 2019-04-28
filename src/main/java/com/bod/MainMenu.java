package com.bod;

import com.bod.actions.Action;
import com.bod.actions.SerializeService;
import com.bod.entity.*;

import java.util.List;
import java.util.Scanner;

public class MainMenu {
    static Scanner s;
    static String optionString;
    static OptionsEnum optionsEnum;
    static SerializeService faresSerializeService, clientsSerializeService;
    static List<Fare> faresList;
    static List<Client> clientsList;
    static Action action;
    String promptString, name;

    private int[] multipleInput(int size){
        name = s.nextLine();

        int[] servicesArr = new int [size];
        for(int i: servicesArr)
        {
            i = s.nextInt();
        }

        return servicesArr;
    }

    private void addFair(){
        System.out.println("Choose a fair type: Simple, Internet, TV, Premium");
        optionString = s.nextLine();

        Fare fare = null;
        int[] servicesArr;

        switch (getParam(optionString))
        {
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

//    private void addClient(){
//        System.out.println("Enter name and fare name");
//        String name, fareName;
//
//        name = s.nextLine();
//        fareName = s.nextLine();
//
//        List<Entity> faresList = faresSerializeService.deserialize();
//
//        boolean fareExists = false;
//
//        for(Entity fl: faresList)
//        {
//            if(fareName.equals(fl.getName())){
//                fareExists = true;
//                clientsList.add(new Client(name, fareName));
//                clientsSerializeService.serialize(clientsList);
//                break;
//            }
//        }
//
//        if(!fareExists){
//            System.out.println("No such fare");
//        }
//
//        System.out.println("new clients list");
//        for(Client c: clientsList)
//        {
//            System.out.println(c.getName() + " " + c.getFareId());
//        }
//    }
//
//    private void outputFaresList(){
//        List<Fare> list = faresSerializeService.deserialize();
//
//        for(Entity l: list)
//        {
//            System.out.println(l.getName());
//        }
//    }
//
//    private void outputClientsList(){
//
//        List<Client> list = clientsSerializeService.deserialize();
//
//        for(Client l: list)
//        {
//            System.out.println(l.getName());
//        }
//    }
//
//    private void outputClientsNum(){
//        List<Entity> list = clientsSerializeService.deserialize();
//        System.out.println(list.size() + " clients");
//    }
//
//    private void sortFares(){
//        List<Fare> list = faresSerializeService.deserialize();
//        List<Fare> sortedList = new ArrayList<>(list);
//        Collections.sort(sortedList);
//
//        for(Fare f: sortedList)
//        {
//            System.out.println(f.getName() + " " + f.calculateFee());
//        }
//    }
//
//    private void findFares(){
//        System.out.println("Input fee range(from/to)");
//
//        Double from, to;
//
//        from = s.nextDouble();
//        to = s.nextDouble();
//
//        List<Fare> list = faresSerializeService.deserialize();
//
//        list
//           .stream()
//           .filter(p -> p.calculateFee() >= from && p.calculateFee() <= to)
//           .collect(Collectors.toList())
//           .forEach(p -> System.out.println(p.getName()));
//
//
//    }


    private static void callSubMenu(){
        System.out.println("Choose the option(Add_fare, Add_client, Get_fares_list, Get_clients_list, Get_clients_num, Sort_fares, Find_fares, Exit):");

        s = new Scanner(System.in);
        optionString = s.nextLine();

        optionsEnum = getParam(optionString);

        switch(optionsEnum)
        {
            case ADD_FARE: mainMenu.addFair(); break;
//            case ADD_CLIENT: mainMenu.addClient();break;
//            case GET_FARES_LIST: mainMenu.outputFaresList();break;
//            case GET_CLIENTS_LIST: mainMenu.outputClientsList();break;
//            case GET_CLIENTS_NUM: mainMenu.outputClientsNum();break;
//            case SORT_FARES: mainMenu.sortFares();break;
//            case FIND_FARES: mainMenu.findFares();break;
            case EXIT: return;
        }
        callSubMenu();
    }

    private static MainMenu mainMenu;

    public static void main(String[] args) {
        mainMenu = new MainMenu();

        action = new Action();
        action.init();

        callSubMenu();
    }

    private static OptionsEnum getParam(String optionString){
        OptionsEnum result = null;

        try {
            result = OptionsEnum.valueOf(optionString.toUpperCase());
        }catch (IllegalArgumentException e){
            System.out.println("incorrect option");
        }

        return result;
    }
}




