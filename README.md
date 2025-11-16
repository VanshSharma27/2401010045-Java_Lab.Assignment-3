# 2401010045-Java_Lab.Assignment-3
This Java program manages student records with exception handling and multithreading. It reads student details, validates inputs, and throws custom exceptions for invalid data. A loading animation runs in a separate thread before displaying the student's details and calculated grade.

# 📘 Student Management System – Exception Handling, Multithreading & Wrapper Classes  

## Java Lab Assignment 3

This project enhances the Student Management System by implementing:

- Exception Handling  
- Multithreading (Loader simulation)  
- Wrapper classes (Integer, Double)  
- Interface-based class structure  
- Validations for user input  

---

## 🎯 Objective
- Handle runtime exceptions  
- Implement multithreading  
- Use wrapper classes and autoboxing  
- Manage student data safely  

---

## 🧩 Class Structure

| Class | Description |
|-------|-------------|
| StudentManager | Implements RecordActions, handles validation |
| Loader | Runnable for loading animation |
| StudentNotFoundException | Custom exception |
| Student | Stores details and calculates grade |
| Main | Driver class |

---

## 🖥️ Expected Output Example
```
Enter Roll No (Integer): 102
Enter Name: Karan
Enter Email: karan@mail.com
Enter Course: BCA
Enter Marks: 77.5
Loading.....
Roll No: 102
Name: Karan
Email: karan@mail.com
Course: BCA
Marks: 77.5
Grade: B
Program execution completed
```


```
