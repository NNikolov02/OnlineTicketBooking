package com.example.onlineticketbooking.error;

public class NotFoundObjectException extends TicketApiBaseException {
    private final String ObjectClaz;
    private final String id;
    public NotFoundObjectException(String massage, String ObjectClaz,String id){
        super(massage);

        this.id = id;
        this.ObjectClaz = ObjectClaz;



    }

    public String getObjectClaz() {

        return ObjectClaz;
    }

    public String getId() {

        return id;
    }
}

