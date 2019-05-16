# Description
RenoRun Software Intern take home evaluation. The goal is to test interns knowledge of basic api server design.

# Instructions
1. Create a branch using your name.
2. Using any language/framework, create an API that meets the specifications below.
3. Make meaningful commits with messages that describe the content.
4. Use the API that was built to add orders into the orders table.

# Requirements
- API must use the MySQL database provided to you in the confirmation email

* Front end view is not required

## getAllProducts (GET /products)
### Response:
```json
[
    {
        "product_id": "int",
        "name": "String",
        "description": "String",
        "price": "double"
    }
]
```

## getProduct (GET /products/:id)
### Response
```json
{
  "product_id": "int",
  "name": "String",
  "description": "String",
  "price": "double"
}
```

## getAllOrders (GET /orders)
### Response
```json
[
    {
        "order_id": "int",
        "product_id": "int",
        "color": "String",
        "email": "String"
    }
]
```
## postOrder (POST /orders)
### Request
```json
{
    "order_id": "int",
    "product_id": "int",
    "color": "String",
    "email": "String"
}
```
