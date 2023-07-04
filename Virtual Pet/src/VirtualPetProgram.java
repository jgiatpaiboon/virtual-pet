/*
 *  Assignment 7
 *  Description: This program uses objects and classes to control the status of a virtual pet, depending on the user.
 *  Name: James Giatpaiboon
 *  ID: 917848716
 *  Class: CSC 210-01
 *  Semester: Fall 2019
 */
import java.util.Scanner;   // imported scanner class
public class VirtualPetProgram {    //main class
    public static void main(String[] args) {

        VirtualPet pet = new VirtualPet();  //object for the user's pet

        String dogName; // stores dog name
        Scanner input = new Scanner(System.in); // created for user input
        int activity = 0;   // number of activity
        System.out.println("Enter the name of your dog: "); // prompts user to enter a dog name
        dogName = input.nextLine(); // stores input for name of the dog


        while (activity != 4) { // loop to allow user to perform actions until they choose the fourth option
            System.out.println("What would you like to do with " + dogName + "?");  // statement asking user what they want to perform with the dog
            System.out.println("1. Walk " + dogName + "."); // option to walk dog
            System.out.println("2. Feed " + dogName + "."); // option to feed dog
            System.out.println("3. Clean " + dogName + ".");   // option to clean dog
            System.out.println("4. Exit the program."); // option to exit program
            activity = input.nextInt(); // stores input for which ever option is chosen

            //if-else statements for activity chosen by the user
            if (activity == 1) {
                System.out.println("Walked " + dogName + ".");
                pet.walk(); // walk method called
            } else {
                if (activity == 2) {
                    System.out.println("Fed " + dogName + ".");
                    pet.feed(); // pet method called
                } else {
                    if (activity == 3) {
                        System.out.println("Cleaned " + dogName + ".");
                        pet.clean();    // clean method called
                    } else {
                        if (activity == 4) {
                            System.out.println(dogName + "'s " + "Summary: ");
                            pet.displaySummary();   // summary method called - ends program and displays summary for user
                        }
                    }
                }
            }
        }
    }
}
class VirtualPet {  // virtual pet class
    //private instance variables
    private int happiness = 60;
    private int energy = 60;
    private int hygiene = 60;

    //constructs virtual pet object
    public VirtualPet() {
    }
    // constructors for virtual pet - integers for happiness, energy, and hygiene
    public VirtualPet(int happiness, int energy, int hygiene) {
        this.happiness = happiness;
        this.energy = energy;
        this.hygiene = hygiene;
    }
    // walk method - if user chooses to walk, statuses below will be updated. (if statements to restrict user from going below or over certain values.
    public void walk() {
        happiness = happiness + 5;  // increases the dog's happiness status by 5
        energy = energy - 20;   // decreases the dog's energy
        hygiene = hygiene - 5;  //  decreases te dog's hygiene
        if (energy <= 30) { // makes sure the user's dog has at least 30 energy
            happiness = happiness - 5;  // decreases the dog's energy by 5 if the user performs the action
        }   //doesn't allow energy to go below 0
        if (energy < 0) {
            energy = 0;
        }   // doesn't allow hygiene to below 0
        if (hygiene < 0) {
            hygiene = 0;
        }
        // doesn't allow happiness status to go above 100 if the action is performed
        if(happiness > 100) {
            happiness = 100;
        }
    }

    public void feed() {    // feed method - if user chooses to feed, statuses below will be updated. (if statements used to restrict going over/under
        happiness = happiness + 5;  // happiness status increases by 5
        energy = energy + 10;   // energy status is increased by 10
        if (energy > 95) {  // doesn't know user to perform action if energy is above 95
        }   // energy cannot go above 100
        if(energy > 100) {
            energy = 100;
        }   // happiness cannot go above 100
        if(happiness > 100) {
            happiness = 100;
        }   // hygiene cannot go above 100
        if(hygiene > 100) {
            hygiene = 100;
        }
    }

    public void clean() {   // clean method - statuses below will be updated (if statements used to restrict going over/ under certain values.
        happiness = happiness + 5;  // happiness increases by 5
        hygiene = hygiene + 30; // hygiene increases by 30
        if (energy > 80) {  // energy must be less than 80 to perform this action
        }
        if(energy > 100){   // energy cannot go above 100
            energy = 100;
        }
        if(happiness > 100) {    //happiness cannot go above 100
            happiness = 100;
        }
        if(hygiene > 100) {  // hygiene cannot go above 100
            hygiene = 100;
        }
    }
    // setter methods to set updated happiness, energy, and hygiene
    public void setHappiness(int newHappiness) {
        this.happiness = newHappiness;
    }
    public void setEnergy(int newEnergy) {
        this.energy = newEnergy;
    }
    public void setHygiene(int newHygiene) {
        this.hygiene = newHygiene;
    }
    public int getHappiness() {
        return this.happiness;
    }
    public int getEnergy() {
        return this.energy;
    }
    public int getHygiene() {
        return this.hygiene;
    }
    public void displaySummary() {  // summary method, display's the virtual pet's summary after program ends
        System.out.println("Level of happiness: " + this.happiness);
        System.out.println("Level of energy: " + this.energy);
        System.out.println("Level of hygiene: " + this.hygiene);
        if (happiness >= 90) {
            System.out.println("You did a great job, your pet is happy!");
        } else {
            if (happiness >= 70) {
                System.out.println("You did a decent job, your pet is okay.");
            } else {
                if (happiness >= 50) {
                    System.out.println("You did a poor job, your pet is sad.");
                }
            }
        }
    }
}