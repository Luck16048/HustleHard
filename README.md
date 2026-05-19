# 🚀 HustleHard

**HustleHard** is a Java backend learning project created to practice real backend development concepts such as database communication, caching, REST API creation, and clean project architecture.

The goal of this project is not only to make the code work but also to understand how backend applications are structured in real-world development.

---

## 📖 About the Project

This project was built as part of my backend learning journey using Java.

It includes work with:

- **MySQL** for storing data
- **Redis** for caching
- **Javalin** for building HTTP endpoints
- **Maven** for dependency management
- **GitHub** for version control

The project is organized using a layered architecture to better understand how backend applications communicate with databases and APIs.

Architecture flow:

```text
Endpoint → Service → Repository → Database
```

This structure helps separate responsibilities and keeps the code more organized and maintainable.

---

## 🛠️ Technologies Used

| Technology | Description |
|------------|-------------|
| Java | Main programming language |
| MySQL | Relational database |
| Redis | Cache storage |
| Jedis | Redis Java client |
| Javalin | Lightweight web framework |
| Maven | Dependency management |
| Git & GitHub | Version control |

---

## 📂 Project Structure

```text
src
└── main
    └── java
        └── org.example
            ├── entity/         # Entity classes
            ├── repository/     # Database communication layer
            ├── service/        # Business logic layer
            ├── enums/          # Enum classes
            ├── Main.java       # Main application logic
            └── App.java        # HTTP endpoints (Javalin)
```

---

## ✨ Features

### 📦 Product Management
- Save product data
- Find product by ID
- Delete product from database

### 🛂 Passport Management
- Save passport data
- Find passport by ID
- Delete passport
- Store cache data in Redis

### 🏢 Apartment Management
- Save apartment data
- Find apartment by ID
- Delete apartment
- Use enums for apartment status and type

---

## 🌐 REST API Endpoints

### Get entity by ID

```http
GET /products/:id
GET /passports/:id
GET /apartments/:id
```

### Example request

```http
GET http://localhost:9000/products/1
```

Returns product data from the database.

---

## ⚡ How to Run the Project

### 1. Clone the repository

```bash
git clone YOUR_REPOSITORY_LINK
```

### 2. Open the project in IntelliJ IDEA

Make sure Maven dependencies are loaded.

### 3. Configure databases

- Start **MySQL**
- Start **Redis**

### 4. Run the application

Run:

```text
App.java
```


## 🎯 Learning Goals

This project was created to improve knowledge in:

- Object-Oriented Programming (OOP)
- SQL database communication
- Redis caching
- REST API fundamentals
- Service & Repository architecture
- Clean project structure
- Backend development basics

---

## 📌 Future Improvements

Planned improvements for the project:

- Add POST and DELETE endpoints
- Improve validation
- Add better exception handling
- Expand Redis caching
- Learn Spring Boot integration
