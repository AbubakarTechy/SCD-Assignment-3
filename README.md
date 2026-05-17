# 📚 Library Book Issue System

## 📸 Screenshots

![Output 1](https://raw.githubusercontent.com/AbubakarTechy/SCD-Assignment-3/main/GUI%20Screenshots/Output%201.png)

![Output 2](https://raw.githubusercontent.com/AbubakarTechy/SCD-Assignment-3/main/GUI%20Screenshots/Output%202.png)

A Java Swing GUI application for managing library book issuance, built as part of the Software Construction & Development (SCD) course at the University of Central Punjab (UCP).

## 🖥️ Features

- Issue books to students via a clean GUI
- Dropdown for book categories (Programming, AI, Databases, Networking)
- Radio buttons for book type (New / Old Edition)
- Full exception handling with custom exception classes
- Reset and Exit functionality

## ⚠️ Exception Handling

| Exception | Scenario |
|-----------|----------|
| `EmptyFieldException` | Any required field is left empty |
| `InvalidRollNumberException` | Roll number contains alphabets or invalid format |
| `InvalidDateException` | Return date is earlier than issue date |
| `NullSelectionException` | No book category or book type selected |
| `NumberFormatException` | Invalid numeric input |

## 🛠️ Tech Stack

- Java (JDK 8)
- Java Swing (JFrame, JLabel, JTextField, JComboBox, JRadioButton)
- Eclipse IDE with WindowBuilder

## 📁 Project Structure

src/
└── com/
└── library/
├── LibrarySystem.java
├── EmptyFieldException.java
├── InvalidRollNumberException.java
├── InvalidDateException.java
└── NullSelectionException.java


## 🚀 How to Run

1. Clone the repo
2. Open in Eclipse
3. Run `LibrarySystem.java`

## 👨‍💻 Author

**Abu Bakar** — BS Software Engineering, UCP Lahore  
GitHub: [@AbubakarTechy](https://github.com/AbubakarTechy)
