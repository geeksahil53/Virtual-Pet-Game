# 🎓 Virtual Pet Game (Java Console Application)

This project is a **console-based Java application** that simulates a virtual pet management system.  
While it takes the form of a small game, its purpose is to **demonstrate software development skills** such as:  
- Object-Oriented Programming (OOP)  
- Class design and inheritance  
- Data validation and state management  
- Console-based user interfaces with ANSI colours  
- Software design through UML diagrams  

---

## 🔑 Technologies & Concepts Used

- **Java (JDK 8+)**  
- **Object-Oriented Programming (OOP)**  
  - Inheritance (Dog, Cat, Fish extend Pet)  
  - Encapsulation (private fields with getters/setters)  
  - Polymorphism (common actions across pets)  
- **Game loop & state management**  
- **Data validation** (ensuring stats stay within limits)  
- **CLI UI design** (colours, menus, user feedback)  
- **UML modelling** (Class, Object, Use Case diagrams)  

---

## 📖 Features

- **Multi-user support** → each user can adopt up to 3 pets  
- **Pet adoption system** → choose Dog, Cat, or Fish  
- **Pet attributes** → Hunger, Happiness, Health, Energy  
- **Interactive actions**:  
  - Feed → reduces hunger  
  - Play → increases happiness, reduces energy  
  - Rest → restores energy and improves health  
- **Automatic state updates** (e.g., hunger increases naturally)  
- **Game Status dashboard** → shows all users and pets  
- **Death & reset system** → pets reset if health reaches zero  
- **Coloured console interface** for better readability  

---

## 📸 Demonstration (Views)

Add screenshots in a folder named **`screenshots/`** and display them here. Examples:  

- **Main Menu**  
  ![Main Menu](screenshots/main_menu.png)  

- **Pet Status View**  
  ![Pet Status](screenshots/status.png)  

- **Game Status Overview**  
  ![Game Status](screenshots/game_status.png)  

- **Pet Reset Example**  
  ![Pet Reset](screenshots/reset.png)  

---

## 📊 UML Diagrams

To document the design, UML diagrams are included:  

### 1. Class Diagram  
Shows the structure of the system:  
- `Pet` (abstract class)  
- `Dog`, `Cat`, `Fish` (subclasses)  
- `User` (manages multiple pets)  
- `VirtualPetGame` (main controller)  
 
<img width="1174" height="1013" alt="UML Class Diagram" src="https://github.com/user-attachments/assets/5dcbd409-4562-44b0-920b-d722828bd68e" />

---

### 2. Object Diagram  
Example scenario at runtime:  
- User "Alice" owns a Dog and a Cat  
- User "Bob" owns a Fish  

<img width="1014" height="728" alt="Object Diagram" src="https://github.com/user-attachments/assets/9b49fbe8-167a-4d1d-818e-635225292997" />

---

## 🛠️ How to Run the Program

1. Install **Java (version 8 or higher)**.  
2. Download or clone the project folder.  
3. Open a terminal or command prompt inside the folder.  
4. Compile the code using:  

   ```bash
   javac VirtualPetGame.java
   
Run the program using:

``` bash
java VirtualPetGame
