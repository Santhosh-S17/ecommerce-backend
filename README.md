# 🛒 E-Commerce Backend API

🚀 **Spring Boot + JWT | Production-Ready Backend System**

---

## 🌟 Overview

A scalable and secure **E-Commerce Backend API** built using Spring Boot.
This project demonstrates real-world backend architecture with authentication, role-based access, cart management, and order processing.

---

## 🧩 Key Highlights

✨ JWT Authentication & Authorization
✨ Role-Based Access Control (ADMIN / USER)
✨ Clean DTO-based API Design
✨ Scalable Layered Architecture
✨ Swagger UI for API Testing
✨ MySQL + JPA (Hibernate)

---

## 🏗️ Architecture

```text
Controller → Service → Repository → Database
              ↓
           DTO Layer
              ↓
        Security Layer (JWT)
```

---

## 📂 Project Structure

```text
src/main/java/com/santhosh/ecommercebackend

├── controller
├── service
├── repository
├── entity
├── dto
├── security
├── config
└── exception
```

---

## 🔐 Authentication Flow

1️⃣ Register user
2️⃣ Login → Get JWT Token
3️⃣ Use token in header

```http
Authorization: Bearer YOUR_TOKEN
```

---

## ⚙️ API Endpoints

### 👤 User

* `POST /api/users/register`

### 🔐 Auth

* `POST /api/auth/login`

### 🛍️ Product

* `POST /api/products` (ADMIN)
* `GET /api/products`
* `DELETE /api/products/{id}` (ADMIN)

### 🛒 Cart

* `POST /api/cart/add`
* `PUT /api/cart/update`
* `DELETE /api/cart/remove/{cartItemId}`

### 📦 Order

* `POST /api/orders`
* `GET /api/orders/user/{userId}`

---

## 🧪 Run the Project

### 1️⃣ Clone Repo

```bash
git clone https://github.com/Santhosh-S17/ecommerce-backend.git
```

### 2️⃣ Configure DB

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_db
spring.datasource.username=root
spring.datasource.password=your_password
```

### 3️⃣ Run App

```bash
mvn spring-boot:run
```

---

## 📄 Swagger UI

👉 Open in browser:

```text
http://localhost:8080/swagger-ui/index.html
```

---

## 📊 Database Tables

* Users
* Products
* Cart / CartItems
* Orders / OrderItems

---

## ⚠️ Challenges Solved

✔ Foreign key constraint issue (Product delete)
✔ JWT-based API security
✔ DTO vs Entity separation
✔ Cart & Order relationships

---

## 👨‍💻 Author

**Santhosh**

---

## ⭐ Support

If you like this project:

👉 Star ⭐ the repo
👉 Share it

---
