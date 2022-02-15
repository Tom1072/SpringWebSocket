import { Client, IMessage } from '@stomp/stompjs'
import SockJS from 'sockjs-client';

let client;

export function connect(handleNewMessage) {
    console.log("Connect")

    client = new Client({
        webSocketFactory: () => { return new SockJS('http://localhost:8080/gs-guide-websocket'); },
        reconnectDelay: 50000,
        heartbeatIncoming: 4000,
        heartbeatOutgoing: 4000,
    });

    client.onConnect = (frame) => {
        client.subscribe('/response/message', (message) => {
            let body = JSON.parse(message.body);
            console.log(body);
            handleNewMessage(body.name, body.message);
        })
    }

    client.onStompError = function (frame) {
        console.log('Broker reported error: ' + frame.headers['message']);
        console.log('Additional details: ' + frame.body);
    };

    client.activate();
}

export function sendMessage(name, message) {
    client.publish({
        destination: "/request/message",
        body: JSON.stringify({
            name: name,
            message: message
        })
    })
}


export function disconnect() {
    console.log("Disconnect")
}
