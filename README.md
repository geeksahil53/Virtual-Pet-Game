# 🎓 Virtual Pet Game (Java Console Application)

This project is a **console-based application in Java** that demonstrates the use of **Object-Oriented Programming (OOP) principles, input handling, and state management**.  
Although presented as a small "virtual pet game", its primary purpose is to showcase **programming and design skills**.

---

## 🔑 Technologies & Concepts Used

- **Java (JDK 8+)**
- **Object-Oriented Programming**
  - Inheritance (e.g., `Dog`, `Cat`, `Fish` extend `Pet`)
  - Encapsulation (private fields with getters/setters)
  - Polymorphism (common methods across different pets)
- **Class design**: Abstract base class (`Pet`) and specialised subclasses
- **Data validation**: Preventing invalid inputs and keeping stats within bounds
- **Game loop & state management**:
  - Updating pet stats when actions are taken
  - Resetting pets when health reaches 0
- **Console UI with ANSI colour codes** for a more user-friendly display
- **User and entity management**: multiple users, each with up to 3 pets

---

## 📖 Features

- **Multiple users** (each can adopt up to 3 pets)
- **Pet adoption** (Dog, Cat, Fish)
- **Pet attributes**:
  - Hunger, Happiness, Health, Energy
- **Actions**:
  - Feed (reduces hunger)
  - Play (increases happiness, reduces energy)
  - Rest (restores energy, boosts health)
- **Automatic state updates** (e.g., hunger increases over time)
- **Game status dashboard** for an overview of all users and pets
- **Death & reset**: Pets are reset if their health reaches zero

---

## 📸 Demonstration (Views)

Screenshots to include:
- Main Menu  
- Adopt Pet menu  
- Pet Status screen (with coloured attributes)  
- Game Status overview  
- Example of a pet dying/resetting  

🛠️ Setup & Run
1. Clone repository
bash
Copy
Edit
git clone https://github.com/yourusername/virtual-pet-game.git
cd virtual-pet-game
2. Compile the code
bash
Copy
Edit
javac VirtualPetGame.java
3. Run the program
   
java VirtualPetGame
📂 Project Structure
bash
Copy
Edit
virtual-pet-game/
│── VirtualPetGame.java   # Main Java file (contains all classes)
│── README.md             # Documentation
│── screenshots/          # Screenshots folder (add your own)
🚀 Skills Demonstrated
Problem solving: modelling a real-world scenario (pet care) into a system of objects and interactions.

Code organisation: keeping responsibilities separate across User, Pet, and subclasses.

Input/output handling: managing console interactions with validation.

Game logic: balancing stats (hunger, health, energy) and consequences of actions.

Presentation skills: CLI UI design with colour for readability.

