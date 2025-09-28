# Login & Registration System (Java + MySQL)

A simple **Login, Registration, Update Email, and Forget Password** console-based application built using **Java (JDBC)** and **MySQL**.  

---

## ✨ Features
- ✅ User Registration (Name, Email, Password)  
- ✅ User Login with validation  
- ✅ Update Email address  
- ✅ Forget Password (reset functionality)  
- ✅ Exit option  

---

## 🛠 Requirements
- Java 8 or higher  
- MySQL  
- JDBC Driver (`mysql-connector-j` JAR)  
- IDE (IntelliJ, Eclipse, VS Code) or command line  

---

## ⚙️ Database Setup
```sql
CREATE DATABASE login_re_db;
USE login_re_db;

CREATE TABLE registered (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL
);

---

## 📌 How to Run
1. Set your MySQL password as environment variable:

   **Linux/Mac:**
   ```bash
   export DB_PASSWORD="your_mysql_password"
Windows PowerShell:

setx DB_PASSWORD "your_mysql_password"


Compile & Run:

javac LoginOrReg.java
java LoginOrReg

🖥 Sample Menu
===== MENU =====
1. Register
2. Login
3. Update Email
4. Forget Password
5. Exit
Enter the Option:

🚀 Future Improvements

Password hashing (BCrypt/SHA) instead of plain text

Email verification system

GUI or Web version

Session management

📜 License

This project is licensed under the MIT License – free to use, modify, and distribute.


---

✅ Once you paste this, your README will be **complete and ready for GitHub**.  

Next step is to make sure your `.gitignore` is there and **push your project** using the Git commands I gave earlier.  

Do you want me to give you the **final ready-to-paste `LoginOrReg.java`** file too?
