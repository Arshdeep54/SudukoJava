
# 🧩 Sudoku Java Game

A simple Swing-based Sudoku game built in Java.

## 📦 Prerequisites

Make sure Java is installed:

```bash
sudo apt update
sudo apt install deafult-jdk
```

Verify installation:

```bash
java -version
javac -version
```

## 📁 Project Structure

```
src/
├── gameFrame.java
├── solve.java
├── sudoku.java         # Main class
└── sudokuPanel.java
```

## 🚀 How to Compile & Run

### Step 1: Clone and Navigate to project directory

```bash
git clone https://github.com/Arshdeep54/SudukoJava.git
cd SudukoJava
```

### Step 2: Compile all Java files

```bash
javac -d out src/*.java
```

This compiles all Java files and puts `.class` files in the `out` directory.

### Step 3: Run the game

```bash
java -cp out sudoku
```

---

## 🛠 Notes

- Main class is `sudoku`, located in `sudoku.java`.
- Make sure all files are in the `src` folder and there's no package declaration.