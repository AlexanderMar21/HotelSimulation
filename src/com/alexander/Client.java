package com.alexander;
import java.util.Random;
public class Client {
        // Fields //
        Random rand = new Random();

        private static int count=0;

        private int clientId;

        private int bedNumber;
        private int roomType;
        private int floorPreferation;
        private int totalStay;


        // == Constructors == //

        public Client() {
            this.clientId = ++count;
        }

        // == Methods == //
        public void decideBooking(int totalFloors){
            this.floorPreferation= rand.nextInt(totalFloors+1); // Value 0 indicates not floor preferation
            this.bedNumber = rand.nextInt(2)+2;
            this.roomType = rand.nextInt(2)+1;
            this.totalStay = rand.nextInt(7)+1;
        }

        public int getBedNumber() {
            return bedNumber;
        }

        public int getRoomType() {
            return roomType;
        }

        public int getFloorPreferation() {
            return floorPreferation;
        }

        public int getTotalStay() {
            return totalStay;
        }

        public int getClientId() {
            return clientId;
        }

        public void introduce(){
            String text ;
            if(this.getFloorPreferation()==0){
                text="";
            }else{
                text="I would prefer a room at floor number  "+(this.getFloorPreferation())+" !";
            }
            System.out.println(" - Hello , I would like a room with " + this.getBedNumber()+ " beds and " +((this.getRoomType()==1)?"standard":"superior")+
                    " type for " +this.getTotalStay() + " nights ! " + text);

        }

}


