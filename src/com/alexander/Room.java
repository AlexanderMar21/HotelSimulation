package com.alexander;

public class Room {
    private  int roomNumber;
    private int bedAmmount;
    private int roomType;
    private Client client;
    private int checkOutDate;

    public Room(int roomNumber, int bedAmmount, int roomType) {  // we dont use setters for room type, bed amount and room number
        this.roomNumber = roomNumber;
        this.bedAmmount = bedAmmount;
        this.roomType = roomType;
        this.client = null;
    }

    public int getRoomNumber() {
        return roomNumber;
    }


    public int getBedAmmount() {
        return bedAmmount;
    }


    public int getRoomType() {
        return roomType;
    }


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getCheckOutDate() {
        return checkOutDate;
    }


    public boolean isEmpty(){
        if(this.client==null){
            return true;
        }else{
            return false;
        }
    }

    public void checkIn(int currentDay , Client client){

               this.client = client;
               this.checkOutDate = currentDay + client.getTotalStay();

    }

    public void checkOut(){
        this.client = null;
        checkOutDate = 0 ;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", bedAmmount=" + bedAmmount +
                ", roomType=" + roomType +
                ", client=" + client +
                ", checkOutDate=" + checkOutDate +
                '}';
    }
}
