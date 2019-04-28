package com.bod.actions;

import com.bod.entity.Client;
import com.bod.entity.Fare;

import java.util.*;
import java.util.stream.Collectors;

public class Action {
    private SerializeService<Fare> faresSerializeService;
    private SerializeService<Client> clientsSerializeService;
    private List<Fare> faresList;
    private List<Client> clientsList;

    public void init(){
        faresSerializeService = new SerializeService<Fare>("fares.txt");
        clientsSerializeService = new SerializeService<Client>("clients.txt");

        faresList = faresSerializeService.deserialize();
        clientsList = clientsSerializeService.deserialize();
    }

    public void addFare(Fare fare){
        faresList.add(fare);
        faresSerializeService.serialize(faresList);
    }

    public List getFaresList(){
        return faresSerializeService.deserialize();
    }

    public void addClient(String name, String fareName){
        clientsList.add(new Client(name, fareName));
        clientsSerializeService.serialize(clientsList);
    }

    public List getClientsList(){
        return clientsSerializeService.deserialize();
    }

    public int getClientsNum(){
        return clientsList.size();
    }

    public List<Fare> sortFares() {
        List<Fare> sortedList = new ArrayList<>(faresList);
        Collections.sort(sortedList);
        return sortedList;
    }

    public List<Fare> getFaresFromRange(Double from, Double to){
        List<Fare> list = new LinkedList<>();

        for(int i = 0; i < faresList.size(); i++)
        {
            if(faresList.get(i).calculateFee() >= from &&
               faresList.get(i).calculateFee() <= to){
                list.add(faresList.get(i));

            }
        }
        return list;
    }
}
