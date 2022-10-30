package kz.uib.kolesa.kolesa.api.models.sockets;

import lombok.Data;

@Data
public class Message {

    private String from;
    private String text;

}