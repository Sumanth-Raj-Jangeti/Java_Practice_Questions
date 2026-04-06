package com.concepts.practice;

class Member {
    private int memberId;
    private String name;
    private Room room; //Aggregation --> Member has a Room
    public Member(int memberId,String name){
        this.memberId=memberId;
        this.name=name;
    }
    public int getMemberId(){
        return memberId;
    }
    public void setMemberId(int memberId){
        this.memberId=memberId;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public Room getRoom(){
        return room;
    }
    public void setRoom(Room room){
        this.room=room;
    }
}

class Room {
    private int roomNo;
    private int capacity;
    private static int roomCounter;
    static{
        roomCounter=499;
    }
    public Room(){
        this.roomNo = ++Room.roomCounter;
        this.capacity=4;
    }
    public int getRoomNo(){
        return roomNo;
    }
    public int getCapacity(){
        return capacity;
    }
    public void setCapacity(int capacity){
        this.capacity=capacity;
    }
}

class Admin {
    public void assignRoom(Room[] rooms,Member member){
        for (Room room : rooms) {
            if (room.getCapacity() > 0) {
                member.setRoom(room);
                room.setCapacity(room.getCapacity() - 1);
                return;
            }
        }
    }
}

public class Aggregation_EX03 {
    public static void main(String[] args) {
        Room room1 = new Room();
        Room room2 = new Room();
        Room room3 = new Room();
        Room room4 = new Room();
        Room room5 = new Room();
        Room[] rooms = {room1, room2, room3, room4, room5};
        Member member1 = new Member(101, "Serena");
        Member member2 = new Member(102, "Martha");
        Member member3 = new Member(103, "Nia");
        Member member4 = new Member(104, "Maria");
        Member member5 = new Member(105, "Eva");
        Member[] members = {member1, member2, member3, member4, member5};
        Admin admin = new Admin();
        for (Member member : members) {
            admin.assignRoom(rooms, member);
            if(member.getRoom()!=null) {
                System.out.println("Hi "+member.getName()+"! Your room number is "+member.getRoom().getRoomNo());
            }
            else {
                System.out.println("Hi "+member.getName()+"! No room available");
            }
        }
    }
}



