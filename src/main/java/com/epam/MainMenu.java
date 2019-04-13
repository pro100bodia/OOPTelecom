package com.epam;

import com.epam.actions.Actions;
import com.epam.entity.*;

import javax.xml.stream.events.EntityDeclaration;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainMenu {
    static Scanner s;
    static String optionString;
    static OptionsEnum optionsEnum;
    static Actions faresActions, clientsActions;
    static List<Fare> faresList;
    static List<Client> clientsList;

    private void addFair(){
        System.out.println("Choose a fair type: Simple, Internet, TV, Premium");
        optionString = s.nextLine();

        Fare fare = null;
        String name;
        int intCalls;
        int extCalls;
        int smsAmount;
        int megabytes;
        int tvChannels;

        switch (getParam(optionString))
        {
            case SIMPLE:
                System.out.println("input name, internalCalls(minutes), externalCalls(minutes), smsAmount(number)");
                

                name = s.nextLine();
                intCalls = s.nextInt();
                extCalls = s.nextInt();
                smsAmount = s.nextInt();

                fare = new SimpleBasedFare(name, intCalls, extCalls, smsAmount);
                break;
            case INTERNET:
                System.out.println("input name, internalCalls(minutes), externalCalls(minutes), smsAmount(number), megabytes");

                name = s.nextLine();
                intCalls = s.nextInt();
                extCalls = s.nextInt();
                smsAmount = s.nextInt();
                megabytes = s.nextInt();

                fare = new InternetBasedFare(name, intCalls, extCalls, smsAmount, megabytes);
                break;
            case TV:
                System.out.println("input name, internalCalls(minutes), externalCalls(minutes), smsAmount(number), tvChannels");

                name = s.nextLine();
                intCalls = s.nextInt();
                extCalls = s.nextInt();
                smsAmount = s.nextInt();
                tvChannels = s.nextInt();

                fare = new TVBasedFare(name, intCalls, extCalls, smsAmount, tvChannels);
                break;
            case PREMIUM:
                System.out.println("input name, internalCalls(minutes), externalCalls(minutes), smsAmount(number), megabytes, tvChannels");

                name = s.nextLine();
                intCalls = s.nextInt();
                extCalls = s.nextInt();
                smsAmount = s.nextInt();
                megabytes = s.nextInt();
                tvChannels = s.nextInt();

                fare = new PremiumBasedFare(name, intCalls, extCalls, smsAmount, megabytes, tvChannels);
                break;

            

        }

        faresList.add(fare);
        faresActions.serialize(faresList);
    }

    private void addClient(){
        System.out.println("Enter name and fare name");
        String name, fareName;

        name = s.nextLine();
        fareName = s.nextLine();

        List<Entity> faresList = faresActions.deserialize();

        boolean fareExists = false;

        for(Entity fl: faresList)
        {
            if(fareName.equals(fl.getName())){
                fareExists = true;
                clientsList.add(new Client(name, fareName));
                clientsActions.serialize(clientsList);
                break;
            }
        }

        if(!fareExists){
            System.out.println("No such fare");
        }

        System.out.println("new clients list");
        for(Client c: clientsList)
        {
            System.out.println(c.getName() + " " + c.getFareId());
        }
    }

    private void outputFaresList(){
        List<Fare> list = faresActions.deserialize();

        for(Entity l: list)
        {
            System.out.println(l.getName());
        }
    }

    private void outputClientsList(){

        List<Client> list = clientsActions.deserialize();

        for(Client l: list)
        {
            System.out.println(l.getName());
        }
    }

    private void outputClientsNum(){
        List<Entity> list = clientsActions.deserialize();
        System.out.println(list.size() + " clients");
    }

    private void sortFares(){
        List<Fare> list = faresActions.deserialize();
        List<Fare> sortedList = new ArrayList<>(list);
        Collections.sort(sortedList);

        for(Fare f: sortedList)
        {
            System.out.println(f.getName() + " " + f.calculateFee());
        }
    }

    private void findFares(){
        System.out.println("Input fee range(from/to)");

        Double from, to;

        from = s.nextDouble();
        to = s.nextDouble();

        List<Fare> list = faresActions.deserialize();

        list
           .stream()
           .filter(p -> p.calculateFee() >= from && p.calculateFee() <= to)
           .collect(Collectors.toList())
           .forEach(p -> System.out.println(p.getName()));


    }


    private static void callSubMenu(){
        System.out.println("Choose the option(Add_fare, Add_client, Get_fares_list, Get_clients_list, Get_clients_num, Sort_fares, Find_fares, Exit):");

        s = new Scanner(System.in);
        optionString = s.nextLine();

        optionsEnum = getParam(optionString);

        MainMenu mainMenu = new MainMenu();

        switch(optionsEnum)
        {
            case ADD_FARE: mainMenu.addFair(); break;
            case ADD_CLIENT: mainMenu.addClient();break;
            case GET_FARES_LIST: mainMenu.outputFaresList();break;
            case GET_CLIENTS_LIST: mainMenu.outputClientsList();break;
            case GET_CLIENTS_NUM: mainMenu.outputClientsNum();break;
            case SORT_FARES: mainMenu.sortFares();break;
            case FIND_FARES: mainMenu.findFares();break;
            case EXIT: return;
        }
        callSubMenu();
    }

    public static void main(String[] args) {
        faresActions = new Actions<Fare>("fares.txt");
        clientsActions = new Actions<Client>("clients.txt");

        faresList = faresActions.deserialize();
        clientsList = clientsActions.deserialize();
        System.out.println("clientsList: " + clientsList);

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
