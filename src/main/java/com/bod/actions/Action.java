package com.bod.actions;

import com.bod.entity.Client;
import com.bod.entity.Fare;

import java.util.List;

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

}
