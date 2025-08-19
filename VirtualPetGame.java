import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

interface HealthState {
    void handleSickness();
    void recover();
}

interface Activity {
    void feed();
    void play();
    void rest();
}

abstract class Pet implements HealthState, Activity {
    protected static final int MAX_HAPPINESS = 70;
    protected static final int MAX_HEALTH = 100;
    protected static final int MAX_ENERGY = 70;
    protected static final int MAX_HUNGER = 100;
    
    // Color codes
    public static final String RESET = "\033[0m";
    public static final String RED = "\033[0;31m";
    public static final String GREEN = "\033[0;32m";
    public static final String YELLOW = "\033[0;33m";
    public static final String CYAN = "\033[0;36m";
    public static final String PURPLE = "\033[0;35m";

    private String name;
    private int hunger;
    private int happiness;
    private int health;
    private int energy;

    public Pet(String name) {
        this.name = name;
        this.hunger = 50;
        this.happiness = 35;
        this.health = 80;
        this.energy = 50;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getHunger() { return hunger; }
    protected void setHunger(int value) { 
        hunger = Math.max(0, Math.min(MAX_HUNGER, value)); 
    }

    public int getHappiness() { return happiness; }
    protected void setHappiness(int value) { 
        happiness = Math.max(0, Math.min(MAX_HAPPINESS, value)); 
    }

    public int getHealth() { return health; }
    protected void setHealth(int value) { 
        health = Math.max(0, Math.min(MAX_HEALTH, value)); 
    }

    public int getEnergy() { return energy; }
    protected void setEnergy(int value) { 
        energy = Math.max(0, Math.min(MAX_ENERGY, value)); 
    }

    @Override
    public void feed() {
        int prevHunger = getHunger();
        setHunger(prevHunger - 30);
        String message = (prevHunger == getHunger()) 
            ? RED + name + " is already full!" 
            : YELLOW + name + " has been fed (" + prevHunger + " -> " + getHunger() + ")";
        System.out.println(message + RESET);
    }

    @Override
    public void rest() {
        int prevEnergy = getEnergy();
        int prevHealth = getHealth();
        setEnergy(prevEnergy + 20);
        setHealth(prevHealth + 10);
        System.out.println(YELLOW + name + " rested (Energy: " + prevEnergy + " -> " + getEnergy() 
            + ", Health: " + prevHealth + " -> " + getHealth() + ")" + RESET);
        if (prevHealth < 20 && getHealth() >= 20) recover();
    }

    public void updateState() {
        if (getHunger() > 80) {
            int prevHealth = getHealth();
            setHealth(prevHealth - 5);
            System.out.println(RED + name + "'s health is dropping! (" + prevHealth + " -> " + getHealth() + ")" + RESET);
        }
    }

    @Override
    public void handleSickness() {
        if (getHealth() < 20) {
            System.out.println(RED + "[ ! ] " + name + " is sick! Needs care! [ ! ]" + RESET);
        }
    }

    @Override
    public void recover() {
        System.out.println(GREEN + " Wow! " + name + " has recovered! " + RESET);
    }

    public void displayColored() {
        String healthColor = (getHealth() < 20) ? RED : (getHealth() < 50) ? YELLOW : GREEN;
        String hungerColor = (getHunger() > 80) ? RED : (getHunger() > 20) ? YELLOW : GREEN;
        String happinessColor = (getHappiness() < 20) ? RED : (getHappiness() < 50) ? YELLOW : GREEN;
        String energyColor = (getEnergy() < 20) ? RED : (getEnergy() < 50) ? YELLOW : GREEN;

        System.out.printf("%s%-10s %s| %s%-12s %s| %s%-12s %s| %s%-12s %s| %s%-12s%s\n",
            CYAN, getClass().getSimpleName(),
            PURPLE, hungerColor, "Hunger: " + hunger,
            PURPLE, happinessColor, "Happiness: " + happiness,
            PURPLE, healthColor, "Health: " + health,
            PURPLE, energyColor, "Energy: " + energy, RESET);
    }

    @Override
    public abstract void play();
}

class Dog extends Pet {
    public Dog(String name) { super(name); }

    @Override
    public void play() {
        if (getHunger() > 20 && getEnergy() > 10) {
            int prevHappiness = getHappiness();
            int happinessIncrease = (int) (prevHappiness * 0.10);
            setHappiness(prevHappiness + happinessIncrease);
            int prevEnergy = getEnergy();
            setEnergy(prevEnergy - 15);
            System.out.println(YELLOW + getName() + " played fetch! (Happiness: " + prevHappiness + " -> " 
                + getHappiness() + ", Energy: " + prevEnergy + " -> " + getEnergy() + ")" + RESET);
        } else {
            String reason = getHunger() <= 20 ? "hungry" : "tired";
            System.out.println(RED + getName() + " is too " + reason + " to play." + RESET);
        }
    }
}

class Cat extends Pet {
    public Cat(String name) { super(name); }

    @Override
    public void play() {
        if (getHunger() > 20 && getEnergy() > 10) {
            int prevHappiness = getHappiness();
            int happinessIncrease = (int) (prevHappiness * 0.10);
            setHappiness(prevHappiness + happinessIncrease);
            int prevEnergy = getEnergy();
            setEnergy(prevEnergy - 10);
            System.out.println(YELLOW + getName() + " chased a laser! (Happiness: " + prevHappiness + " -> " 
                + getHappiness() + ", Energy: " + prevEnergy + " -> " + getEnergy() + ")" + RESET);
        } else {
            System.out.println(RED + getName() + " ignores you. Maybe try feeding?" + RESET);
        }
    }
}

class Fish extends Pet {
    public Fish(String name) { super(name); }

    @Override
    public void play() {
        if (getHunger() > 20 && getEnergy() > 10) {
            int prevHappiness = getHappiness();
            int happinessIncrease = (int) (prevHappiness * 0.10);
            setHappiness(prevHappiness + happinessIncrease);
            int prevEnergy = getEnergy();
            setEnergy(prevEnergy - 5);
            System.out.println(YELLOW + getName() + " swam through a hoop! (Happiness: " + prevHappiness + " -> " 
                + getHappiness() + ", Energy: " + prevEnergy + " -> " + getEnergy() + ")" + RESET);
        } else {
            System.out.println(RED + getName() + " floats listlessly. Needs energy!" + RESET);
        }
    }
}

class User {
    private String name;
    private List<Pet> pets = new ArrayList<>();

    public User(String name) { this.name = name; }

    public static void displayUserList(List<User> users) {
        System.out.println(Pet.CYAN + "\n=== Registered Users ===" + Pet.RESET);
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            String petStatus = Pet.YELLOW + "(" + user.getPets().size() + "/3 pets)" + Pet.RESET;
            System.out.printf(" %s%-2d. %-10s %s%n",
                    Pet.PURPLE, i+1,
                    user.getName(),
                    petStatus);
        }
    }

    public void addPet(Pet pet) {
        if (pets.size() < 3) {
            pets.add(pet);
            System.out.println(Pet.GREEN + "\n Ok! Successfully adopted " + pet.getName() + "!" + Pet.RESET);
        } else {
            System.out.println(Pet.RED + "\n Sorry! " + name + " can't adopt more pets!" + Pet.RESET);
        }
    }

    public void removePet(Pet pet) {
        if (pets.remove(pet)) {
            System.out.println(Pet.YELLOW + "\n i] " + pet.getName() + " was released." + Pet.RESET);
        }
    }

    public void displayPets() {
        if (pets.isEmpty()) {
            System.out.println(Pet.RED + "\n   No pets available!" + Pet.RESET);
            return;
        }
        
        System.out.println(Pet.CYAN + "\n=== " + name + "'s Pets ===" + Pet.RESET);
        System.out.println(Pet.PURPLE + "------------------------------------------------------------" + Pet.RESET);
        for (int i = 0; i < pets.size(); i++) {
            System.out.print(Pet.YELLOW + " " + (i+1) + ". " + Pet.RESET);
            pets.get(i).displayColored();
        }
        System.out.println(Pet.PURPLE + "------------------------------------------------------------" + Pet.RESET);
    }

    public List<Pet> getPets() { return new ArrayList<>(pets); }
    public String getName() { return name; }
}

public class VirtualPetGame {
    private static List<Pet> availablePets = new ArrayList<>();
    private static List<User> users = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    
    private static final String WELCOME_ART = 
    Pet.CYAN +
    " _______  ________  _________    ______   _____  ____    ____   \n" +
    "|_   __ \\|_   __  ||  _   _  | .' ____ \\ |_   _||_   \\  /   _| \n" +
    "  | |__) | | |_ \\_||_/ | | \\_| | (___ \\_|  | |    |   \\/   |   \n" +
    "  |  ___/  |  _| _     | |      _.____`.   | |    | |\\  /| |   \n" +
    " _| |_    _| |__/ |   _| |_    | \\____) | _| |_  _| |_\\/_| |_  \n" +
    "|_____|  |________|  |_____|    \\______.'|_____||_____||_____| \n" +
    Pet.RESET;


    public static void main(String[] args) {
        initializeDummyData();
        showMainMenu();
    }

    private static void initializeDummyData() {
        for (int i = 1; i <= 7; i++) availablePets.add(new Dog("Dog" + i));
        for (int i = 1; i <= 7; i++) availablePets.add(new Cat("Cat" + i));
        for (int i = 1; i <= 6; i++) availablePets.add(new Fish("Fish" + i));
        for (int i = 1; i <= 5; i++) users.add(new User("User" + i));
    }

    private static void showMainMenu() {
        System.out.println(WELCOME_ART);
        while (true) {
            try {
                System.out.println(Pet.CYAN + "\n=== Main Menu ===" + Pet.RESET);
                System.out.println(Pet.YELLOW + " 1." + Pet.RESET + " Adopt a pet");
                System.out.println(Pet.YELLOW + " 2." + Pet.RESET + " Interact with pets");
                System.out.println(Pet.YELLOW + " 3." + Pet.RESET + " View game status");
                System.out.println(Pet.YELLOW + " 4." + Pet.RESET + " Exit game");
                System.out.print(Pet.GREEN + "\n Choose an option: " + Pet.RESET);

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> adoptPet();
                    case 2 -> interactWithPets();
                    case 3 -> displayGameStatus();
                    case 4 -> {
                        System.out.println(Pet.YELLOW + "\n Thanks for playing! <3" + Pet.RESET);
                        System.exit(0);
                    }
                    default -> System.out.println(Pet.RED + " Invalid choice!" + Pet.RESET);
                }
            } catch (InputMismatchException e) {
                System.out.println(Pet.RED + " Please enter a number (1-4)!" + Pet.RESET);
                scanner.nextLine();
            }
        }
    }

    private static int getValidInput(String prompt, int min, int max) {
        while(true) {
            try {
                System.out.print(Pet.GREEN + " " + prompt + Pet.RESET);
                int input = scanner.nextInt();
                scanner.nextLine();
                if(input >= min && input <= max) return input;
                System.out.println(Pet.RED + " Please enter between " + min + "-" + max + "!" + Pet.RESET);
            } catch (InputMismatchException e) {
                System.out.println(Pet.RED + " Invalid input! Please enter a number." + Pet.RESET);
                scanner.nextLine();
            }
        }
    }

    private static void adoptPet() {
        if (availablePets.isEmpty()) {
            System.out.println(Pet.RED + "\n No pets available for adoption! Oops!" + Pet.RESET);
            return;
        }

        System.out.println(Pet.CYAN + "\n=== Available Pets ===" + Pet.RESET);
        displayAvailablePets();

        User.displayUserList(users);
        int userIndex = getValidInput("Select user: ", 1, users.size()) - 1;
        
        System.out.print(Pet.GREEN + "\n Enter pet name: " + Pet.RESET);
        String petName = scanner.nextLine();
        
        int petIndex = getValidInput("Select pet: ", 1, availablePets.size()) - 1;
        
        Pet pet = availablePets.get(petIndex);
        pet.setName(petName);
        users.get(userIndex).addPet(pet);
        availablePets.remove(petIndex);
    }

    private static void interactWithPets() {
        User.displayUserList(users);
        if (users.stream().allMatch(u -> u.getPets().isEmpty())) {
            System.out.println(Pet.RED + "\n No pets in the game! Adopt some first! " + Pet.RESET);
            return;
        }

        int userIndex = getValidInput("Select user: ", 1, users.size()) - 1;
        User user = users.get(userIndex);
        
        user.displayPets();
        if (user.getPets().isEmpty()) return;

        int petIndex = getValidInput("Select pet: ", 1, user.getPets().size()) - 1;
        Pet pet = user.getPets().get(petIndex);

        System.out.println(Pet.CYAN + "\n=== Current Status ===" + Pet.RESET);
        pet.displayColored();

        // Time-based decay
        pet.setHunger(pet.getHunger() + 10);
        System.out.println(Pet.YELLOW + "\n Time passes... Hunger increased by 10! " + Pet.RESET);

        System.out.println(Pet.CYAN + "\n Available Actions:");
        System.out.println(Pet.YELLOW + " feed" + Pet.RESET + " - Reduce hunger");
        System.out.println(Pet.YELLOW + " play" + Pet.RESET + " - Increase happiness");
        System.out.println(Pet.YELLOW + " rest" + Pet.RESET + " - Restore energy");
        System.out.print(Pet.GREEN + "\n Enter action: " + Pet.RESET);
        
        String action = scanner.nextLine().toLowerCase();
        
        switch(action) {
            case "feed" -> pet.feed();
            case "play" -> pet.play();
            case "rest" -> pet.rest();
            default -> System.out.println(Pet.RED + " No action taken!" + Pet.RESET);
        }

        pet.updateState();
        checkPetHealth(user, pet);
        
        System.out.println(Pet.CYAN + "\n=== Updated Status ===" + Pet.RESET);
        pet.displayColored();
    }

    private static void checkPetHealth(User user, Pet pet) {
        if (pet.getHealth() <= 0) {
            System.out.println(Pet.RED + "\nOops! " + pet.getName() + " has died! [ X ]" + Pet.RESET);
            user.removePet(pet);
            resetPet(pet);
            availablePets.add(pet);
        }
    }

    private static void resetPet(Pet pet) {
        pet.setHealth(80);
        pet.setHunger(50);
        pet.setHappiness(35);
        pet.setEnergy(50);
    }

    private static void displayGameStatus() {
        System.out.println(Pet.CYAN + "\n=== Game Status ===" + Pet.RESET);
        System.out.println(Pet.YELLOW + "--- Users ---" + Pet.RESET);
        for (User user : users) {
            System.out.printf("%s%-10s %s(%d pets)%n",
                Pet.PURPLE, user.getName(),
                Pet.YELLOW, user.getPets().size());
            user.displayPets();
        }
        
        System.out.println(Pet.YELLOW + "\n--- Available Pets ---" + Pet.RESET);
        if (availablePets.isEmpty()) {
            System.out.println(Pet.RED + " No pets available!" + Pet.RESET);
        } else {
            displayAvailablePets();
        }
    }

    private static void displayAvailablePets() {
        System.out.println(Pet.PURPLE + "------------------------------------------------------------" + Pet.RESET);
        for (int i = 0; i < availablePets.size(); i++) {
            Pet p = availablePets.get(i);
            System.out.printf(" %s%-2d. %-10s %s(%s)%n",
                Pet.YELLOW, i+1,
                p.getName(),
                Pet.CYAN, p.getClass().getSimpleName());
        }
        System.out.println(Pet.PURPLE + "------------------------------------------------------------" + Pet.RESET);
    }
}