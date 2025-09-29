# 🚀 Login & Registration System (Java + MySQL)

A **console-based** Java application with **MySQL (JDBC)** that enables users to:

- 📝 Register (Name, Email, Password)  
- 🔐 Login with validation  
- ✏️ Update Email address  
- 🔄 Reset Password (Forget Password)  
- ⏹ Exit program  

---

## ✨ Features

| Feature              | Description                                  |
|----------------------|----------------------------------------------|
| 📝 Registration       | Register new users with name, email, password |
| 🔐 Login              | Validate user credentials from MySQL DB      |
| ✏️ Update Email       | Change user email securely                   |
| 🔄 Forget Password    | Reset password if forgotten                  |
| ⏹ Exit               | Close the program gracefully                 |

---

## 🛠 Requirements

- ☕ Java **8 or higher**  
- 🐬 MySQL installed & running  
- 🔗 JDBC Driver → `mysql-connector-j` JAR  
- 💻 IDE (IntelliJ / Eclipse / VS Code) **or** terminal  

---

## ⚙️ Database Setup  

Run these queries in **MySQL** before starting the program:

```sql
CREATE DATABASE login_re_db;
USE login_re_db;

CREATE TABLE registered (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL
);


🔎 Internal Working (Flow)

Database Connectivity

Uses JDBC for communication with MySQL.

DB password is read from environment variables for security.

Registration Flow

Takes Name, Email, Password from user.

Runs an INSERT query into the table.

If email already exists → shows error.

Login Flow

Takes Email + Password.

Runs SELECT query.

If valid → login success, else error.

Update Email Flow

User enters current + new email.

Runs UPDATE query.

Forget Password Flow

User enters registered email.

If found → allows new password (UPDATE query).

Exit

Program terminates gracefully.

▶️ How to Run

Set MySQL password as environment variable

Linux / Mac

export DB_PASSWORD="your_mysql_password"


Windows PowerShell

setx DB_PASSWORD "your_mysql_password"


Compile & Run

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

🔒 Use password hashing (BCrypt / SHA) instead of plain text

📧 Add email verification system

🎨 Build a GUI or Web version

🔑 Add session management for logged-in users

📜 License

This project is licensed under the MIT License – free to use, modify, and distribute.

💡 Made with ❤️ using Java + MySQL


---

⚡ This version is **GitHub-ready**:  
- Stylish table 📊  
- Emojis 🎨  
- Clean structure ✨  

👉 Do you want me to now prepare the **`LoginOrReg.java`** file in the **same stylish, professional way** (with comments, methods, and JDBC code), so your whole project looks awesome end-to-end?
