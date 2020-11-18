package com.alexander;

import java.util.ArrayList;

public class Floor {

    private int floorNumber;
    private int totalRooms;
    private ArrayList<Room> rooms ;

    public Floor(int floorNumber, int totalRooms) {
        this.floorNumber = floorNumber;
        this.rooms = new ArrayList<Room>(totalRooms);
        this.totalRooms = totalRooms;
    }

    public int getFloorNumber() {
        return this.floorNumber;
    }


    public ArrayList<Room> getRooms() {
        return rooms;
    }


    public void addRoom(Room room){
        rooms.add(room);
    }


    public void setRoomData(int roomNumber, int beds , int roomType ) {
        if(rooms.size()<= totalRooms) {
          //  Room room = new Room(roomNumber, beds, roomType);
            rooms.add(new Room(roomNumber, beds, roomType));
        }
    }

    public void setRoomData(int roomNumberMin,int roomNumberMax,int beds ,int roomType ) {
        if((totalRooms-rooms.size())<=(roomNumberMax-roomNumberMin)) {   //we check that we dont exceed the size
            for (int i = roomNumberMin; i <= roomNumberMax; i++) {
                Room room = new Room(i, beds, roomType);
                this.rooms.add(room);
            }
        }
    }

// rooms={105,108,112}   {101,102,103}
    public void setRoomData(ArrayList<Integer> rooms,int beds ,int roomType ) {
        if((totalRooms-rooms.size())<=rooms.size()) {   //we check that we dont exceed the size
            for (int i = 0; i <= rooms.size(); i++) {
                Room room = new Room(i, beds, roomType);
                this.rooms.add(room);
            }
        }
    }



    public int searchRoom(int beds,int roomType) {
        for (int i = 0 ; i <rooms.size();i++) {
            int roomnumber  = rooms.get(i).getRoomNumber();
            if(rooms.get(i).isEmpty()) {
                if((rooms.get(i).getBedAmmount()==beds)&&(rooms.get(i).getRoomType()==roomType)){
                   return roomnumber;
               }
            }
        }

        return 0;
    }

    public void emptyRooms(int currentDay){
            for (Room r:rooms) {
                if(r.getCheckOutDate()==currentDay){
                r.checkOut();
                }
            }
    }
    public  int roomIndexFromNumber(int roomNumber){
        int roomindex = (roomNumber%100)-1;
        int floor = roomNumber/100;
        if((floor==this.floorNumber)&&(roomindex>=0)) {
            return roomindex;
        }else
            return -1;
    }



}
