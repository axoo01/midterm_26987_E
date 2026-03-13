# Rental Management System

## Overview

This project is a **Spring Boot Rental Management System** that allows a business to manage customers, rental items, and rental transactions.

The system keeps track of **where customers live, what items are available, and which items are currently rented**. It uses a structured location hierarchy so that customers can be linked to a specific place while still allowing the system to retrieve customers by higher locations such as district or province.

Customers are always connected to the **lowest level of the location hierarchy (Village)**. From that village, the system automatically knows the customer's **Cell, Sector, District, and Province** through relationships stored in the database.

The system also supports **pagination** when retrieving customers so large datasets can be viewed in smaller pages instead of returning all records at once.

---

## Entities

The system is built around the following entities:

* **Location** – stores geographic locations in a hierarchical structure
* **Customer** – stores basic customer information
* **CustomerProfile** – stores additional customer details
* **Item** – stores items available for rent
* **Rental** – stores rental transactions between customers and items

---

## Location Hierarchy

Locations follow a hierarchical structure:

Province
→ District
→ Sector
→ Cell
→ Village

Customers are linked to a **Village**, and the system derives the higher levels automatically.

---

## Key Features

* Manage customers and their profiles
* Manage rental items
* Create rental transactions
* Retrieve customers by province
* Pagination support when retrieving customers

---

All API endpoints start from this base URL.

```
http://localhost:8080/api
```



## Main API Endpoints

### Locations

Create a location:

```
POST /api/locations/save
```

---

### Customers

Create a customer (linked to a village):

```
POST /api/customers/save?locationId={villageId}
```

Retrieve customers by province code:

```
GET /api/customers/province/code/{code}
```

Retrieve customers by province name:

```
GET /api/customers/province/name/{name}
```

Retrieve customers with pagination:

```
GET /api/customers/paged?page=0&size=5
```

---

### Customer Profiles

Create a customer profile:

```
POST /api/profiles/save?customerId={customerId}
```

---

### Items

Create an item:

```
POST /api/items/save
```

Retrieve all items:

```
GET /api/items/all
```

---

### Rentals

Create a rental transaction:

```
POST /api/rentals/create?customerId={customerId}&itemId={itemId}
```

---

