import java.util.*;

class Room {
    int rNumber;
    boolean isBooked;

    Room(int rNumber) {
        this.rNumber = rNumber;
        this.isBooked = false;
    }
}

class HotelBookingSystem {
    List<Room> rooms = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    void createRooms(int count) {
        for (int i = 1; i <= count; i++) {
            rooms.add(new Room(i));
        }
    }

    void displayRooms() {
        System.out.println("Available Rooms:");
        for (Room room : rooms) {
            if (!room.isBooked) {
                System.out.println("Room " + room.rNumber + " is available.");
            }
        }
    }

    void bookRoom() {
        displayRooms();
        System.out.print("Enter room number to book: ");
        int rNumber = sc.nextInt();
        for (Room room : rooms) {
            if (room.rNumber == rNumber && !room.isBooked) {
                room.isBooked = true;
                System.out.println("Room " + rNumber + " booked successfully.");
                return;
            }
        }
        System.out.println("Room is either booked or does not exist.");
    }

    void run() {
        createRooms(5);
        while (true) {
            System.out.println("\n1. Book Room\n2. Exit");
            System.out.print("Choose an option: ");
            int option = sc.nextInt();
            if (option == 1) {
                bookRoom();
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        new HotelBookingSystem().run();
    }
}
