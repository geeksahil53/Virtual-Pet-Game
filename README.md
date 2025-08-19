:

🎓 Virtual Pet Game (Java Console Application)

This project is a console-based Java application that simulates a virtual pet management system.
While it takes the form of a small game, its purpose is to demonstrate software development skills such as:

Object-Oriented Programming (OOP)

Class design and inheritance

Data validation and state management

Console-based user interfaces with ANSI colours

Software design through UML diagrams

🔑 Technologies & Concepts Used

Java (JDK 8+)

Object-Oriented Programming (OOP)

Inheritance (Dog, Cat, Fish extend Pet)

Encapsulation (private fields with getters/setters)

Polymorphism (common actions across pets)

Game loop & state management

Data validation (ensuring stats stay within limits)

CLI UI design (colours, menus, user feedback)

UML modelling (Class, Object, Use Case diagrams)

📖 Features

Multi-user support → each user can adopt up to 3 pets

Pet adoption system → choose Dog, Cat, or Fish

Pet attributes → Hunger, Happiness, Health, Energy

Interactive actions:

Feed → reduces hunger

Play → increases happiness, reduces energy

Rest → restores energy and improves health

Automatic state updates (e.g., hunger increases naturally)

Game Status dashboard → shows all users and pets

Death & reset system → pets reset if health reaches zero

Coloured console interface for better readability

📸 Demonstration (Views)

Add screenshots in a folder named screenshots/ and display them here. Examples:

Main Menu


Pet Status View


Game Status Overview


Pet Reset Example


📊 UML Diagrams

To document the design, UML diagrams are included:

1. Class Diagram

Shows the structure of the system:

Pet (abstract class)

Dog, Cat, Fish (subclasses)

User (manages multiple pets)

VirtualPetGame (main controller)

2. Object Diagram

Example scenario at runtime:

User "Alice" owns a Dog and a Cat

User "Bob" owns a Fish

3. Use Case Diagram

Illustrates interactions between the User and the System:

Adopt Pet

Feed Pet

Play with Pet

Rest Pet

View Game Status

🛠️ How to Run the Program

Install Java (version 8 or higher).

Download or clone the project folder.

Open a terminal or command prompt inside the folder.

Compile the code using:
javac VirtualPetGame.java

Run the program using:
java VirtualPetGame

📂 Project Structure
virtual-pet-game/
│── VirtualPetGame.java     (Main Java file with all classes)
│── README.md               (Project documentation)
│── screenshots/            (Screenshots of the game)
│── diagrams/               (UML diagrams: class, object, use case)

🚀 Skills Demonstrated

Programming skills: Java, OOP, encapsulation, inheritance

Problem solving: Modelling real-world entities into a software system

Design thinking: UML diagrams for planning & structure

User interaction design: Creating a simple but clear CLI interface

Game logic: Handling pet stats, updates, and resets

Presentation skills: Screenshots, diagrams, and structured documentation
