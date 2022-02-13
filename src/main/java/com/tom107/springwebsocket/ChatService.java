package com.tom107.springwebsocket;

import com.tom107.springwebsocket.model.Client;
import com.tom107.springwebsocket.model.ClientMessage;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Data
@NoArgsConstructor
public class ChatService {

    private HashMap<String, Client> clientHashMap;
    private ArrayList<ClientMessage> clientMessages;

    @Autowired
    public ChatService(HashMap<String, Client> clientHashMap, ArrayList<ClientMessage> clientMessages) {
        this.clientHashMap = clientHashMap;
        this.clientMessages = clientMessages;
    }

    public ClientMessage addMessage(String id, String message)  {
        ClientMessage clientMessage = null;
        Client client = clientHashMap.getOrDefault(id, null);
        if (client != null) {
            clientMessage = new ClientMessage(client, message);
            clientMessages.add(clientMessage);
        }
        return clientMessage;
    }

    public Client addClient(String name) {
        String id = UUID.randomUUID().toString();
        Client client = new Client(id, name);
        clientHashMap.put(id, client);
        return client;
    }

    public Client removeClient(String id) {
        return clientHashMap.remove(id);
    }
}
