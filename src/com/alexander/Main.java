package com.alexander;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static final int NUM_FLOORS = 4;  // replace the floors here
    static final int NUM_FLOOR_ROOMS = 10;  // rooms per floor


    public  static Hotel createHotel(String name ){
        Hotel hotel = new Hotel(name,NUM_FLOORS);
        Random  rand = new Random();
        for(int i = 0 ; i < NUM_FLOORS ;i++){
            hotel.setFloorRooms(i+1,NUM_FLOOR_ROOMS);
        }
        for(int i = 1 ; i<= NUM_FLOORS ;i++){
            // initialize the hotel with the final floors and NUM_FLOOR_ROOMS
            int roomPatern = (i) * 100;
            while(hotel.getFloor(i).getRooms().size() < NUM_FLOOR_ROOMS){
                // Each room is created with random fields
                int roomType = rand.nextInt(2)+1;
                int roomNumber = ++roomPatern;
                int roomBeds = rand.nextInt(2)+2;
                hotel.getFloor(i).setRoomData(roomNumber,roomBeds,roomType);
            }
        }
        return hotel;
    }

    public static void runSimulation(Hotel hotel ) {
        Random rand = new Random();
        int day = 1;
        int todalDays = 0;
        int floors = hotel.getTotalfloors();
        int totalRooms = (hotel.getFloors().size())*(hotel.getFloors().get(0).getRooms().size());

        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to simulation of " + (hotel.getName()) + " Hotel!");
        System.out.println("Total rooms of hotel " + totalRooms +".");
        
        System.out.println("Choose days of simulation : ");
        todalDays = scan.nextInt();
        while (day <= todalDays) {
                ArrayList<Client>  newClients = new ArrayList<>();
                int randomClientsAmount = rand.nextInt(totalRooms/2)+15;

                for(int i = 0; i < randomClientsAmount;i++){
                    Client newClient = new Client();
                    newClient.decideBooking(floors);
                    newClients.add(newClient);
                }

                System.out.println("\t\t\t\t\t\t\tDay " + (day)+"\n");
                String roomListForCheckout = hotel.checkOutList(day);
                if(day!=1)
                    System.out.println("Checking out guests from rooms "+roomListForCheckout+"\n");
                hotel.emptyRooms(day);

                for(int i = 0 ;i<newClients.size();i++){
                    hotel.serviceClient(day,newClients.get(i));
                }
            day++;
        }
    }


    public static void main(String[] args) {


        runSimulation(createHotel("FourSeason"));





    }
}
