package kz.uib.kolesa.kolesa.api.controllers;

import kz.uib.kolesa.kolesa.api.models.sockets.Message;
import kz.uib.kolesa.kolesa.api.models.sockets.OutputMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequiredArgsConstructor
public class ChatController {

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public OutputMessage send(final Message message) throws Exception {

        final String time = new SimpleDateFormat("HH:mm").format(new Date());
        System.out.println("message: " + message);
        return new OutputMessage(message.getFrom(), message.getText(), time);
    }
}
