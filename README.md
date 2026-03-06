# Student Grading System 🎓

A menu-driven student grading and information system developed in Java. This project was created to calculate, filter, and sort student exam results interactively.

## 🚀 Features
* **Data Registration:** Takes student number, name, midterm, and final grades via a console menu.
* **Grade Calculation:** Automatically calculates the final grade (40% Midterm + 60% Final).
* **Filter by Passing Grade:** Identifies and displays students who scored below 60.
* **Filter by Class Average:** Calculates the overall class average and lists students scoring above it.
* **Find Min/Max:** Pinpoints the students with the highest and lowest grades.
* **Sort Results:** Sorts all students by their final grades in ascending order using the **Bubble Sort** algorithm.

## 💻 Data Structures & Logic
* **Language:** Java
* **Data Handling:** **Parallel Arrays** (`int[]`, `String[]`, `double[]`) were utilized to maintain data integrity across student numbers, names, and grades.
* **Menu Logic:** Built with a `while` loop and `switch-case` statements for an interactive user experience.

## ⚠️ Known Limitations
* **Name Input:** Due to the use of `Scanner.next()`, names must be entered without spaces (e.g., `Name_Surname`). Entering spaces will cause an `InputMismatchException`.
* **Array Size:** The system uses static arrays, meaning the total number of students is defined at the initial launch and cannot be resized dynamically.
