package com.alexander;

import java.util.ArrayList;

public class Hotel {

    private String name;
    private ArrayList<Floor> floors;
    private int totalfloors;

    public Hotel(String name, int totalfloors) {
        this.name = name;
        this.floors = new ArrayList<>(totalfloors);
        this.totalfloors=totalfloors;
    }

    public int getTotalfloors() {
        return totalfloors;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Floor> getFloors() {
        return floors;
    }

    public void setFloorRooms(int floorNumber, int totalRooms){
        Floor floor = new Floor(floorNumber,totalRooms);
        floors.add(floor);
    }

    public Floor getFloor(int floorNumber){
        return  floors.get(floorNumber-1);
    }

    public int searchRoom(int beds , int roomType){   // without floor preferation
        for (Floor fl : floors) {
            int i = fl.searchRoom(beds, roomType);
            if(i !=0)
               return i;
        }
        return 0 ;
    }

    public int searchRoom(int floornum ,int beds , int roomType){  // with floor preferation
        int i = this.getFloor(floornum).searchRoom(beds, roomType);
        if(i !=0){
            return i;
        }else
            return 0 ;
    }

    public void bookRoom(int roomNumber , Client client ,int currentDay){
        int floorNumber = roomNumber/100;
        int roomIndex = this.getFloor(floorNumber).roomIndexFromNumber(roomNumber);
        this.getFloor(floorNumber).getRooms().get(roomIndex).checkIn(currentDay,client);
    }

    public void emptyRooms(int currentDay){
        for (Floor fl : floors) {
            fl.emptyRooms(currentDay);
        }
    }

    public void serviceClient(int today ,Client newClient){
        int roomFound;
        newClient.introduce();
        if(newClient.getFloorPreferation()==0){
            roomFound =  this.searchRoom(newClient.getBedNumber(),newClient.getRoomType());
        }else{
            roomFound = this.searchRoom(newClient.getFloorPreferation(),newClient.getBedNumber(),newClient.getRoomType());
        }
        if(roomFound!=0){
            int floorNum = roomFound/100;
            System.out.println(" - We found the room number " + roomFound + " at floor number " + floorNum + " !\n");
            this.bookRoom(roomFound,newClient,today);

        }else{
            System.out.println(" - We are so sorry but we  dont have any availbale rooms with your criteria! \n");
        }

    }

    public String checkOutList(int currentDay){
        String roomList = "";
        for (Floor fl: floors) {
            for (Room r: fl.getRooms()){
                if(r.getCheckOutDate()==currentDay){
                    roomList +=  r.getRoomNumber()+", ";
                }
            }
        } return roomList;
    }
}
