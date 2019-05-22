# PREPARED BY VICTOR MOLINA FOR RenoRun INTERNSHIP ASSESSMENT

# Importing Flask and Flask MySQL connector libraries
from flask import Flask, jsonify, request
from flask_mysqldb import MySQL

# Creating Application Object, instance of Flask class (Web Server Gateway Interface)
app = Flask(__name__)
# Including provided database information
app.config['MYSQL_HOST'] = 'candidate.cgaxg1swcr35.us-east-1.rds.amazonaws.com'
app.config['MYSQL_USER'] = 'RenoRun'
app.config['MYSQL_PASSWORD'] = 'o7feu6hC*3qVnfMsON'
app.config['MYSQL_DB'] = 'develop'
# Creating instance of database
mysql = MySQL(app)


@app.route('/')
def index():
    return "Flask is running"

# Get all products API call
@app.route('/products', methods=['GET'])
def get_all_products():
    # validate get request
    if request.method == 'GET':
        # bind mysql database cursor
        cur = mysql.connection.cursor()
        # get row size
        rows = cur.execute("SELECT * FROM product")
        # if any products exist, execute to return database contents
        if rows > 0:
            data = cur.fetchall()
            return jsonify(data)
        # return message if database is empty of products
        else:
            return "Database is empty of products.."

# Get product by id API call
@app.route('/products/<id>', methods=['GET'])
def get_product(id):
    # validate get request
    if request.method == 'GET':
        # bind mysql database cursor
        cur = mysql.connection.cursor()
        # navigate to database entry
        cur.execute("SELECT * FROM product WHERE product_id = %s", [id])
        target = jsonify(cur.fetchall())
        # return target
        return target


# Get orders API call calls
@app.route('/orders', methods=['GET'])
def get_all_orders():
    # validate get request
    if request.method == 'GET':
        # bind mysql database cursor
        cur = mysql.connection.cursor()
        # get row size
        rows = cur.execute("SELECT * FROM orders")
        # if any orders exist, execute to return database contents
        if rows > 0:
            data = cur.fetchall()
            return jsonify(data)
        # return message if database is empty of orders
        else:
            return "Database is empty of orders.."


# Add an order to the database
@app.route('/orders/add', methods=['GET', 'POST'])
def post_order():
    # validate post request
    if request.method == 'POST':
        # retrieve input from post data
        id = request.form.get('id')
        pid = request.form.get('product_id')
        color = request.form.get('color')
        email = request.form.get('email')
        # bind cursor
        cur = mysql.connection.cursor()
        # enter new order
        cur.execute("INSERT into orders(order_id,product_id,color,email) VALUES(%s, %s, %s, %s)", [id, pid, color, email])
        mysql.connection.commit()
        cur.close()
        # return confirmation
        return "Order placed"

    # prompt form interface for post request (as a test for POST capability of API)
    else:
        return '''<form method="POST">
                    Order ID: <input type="text" name="id"><br>
                    Product ID: <input type="text" name="product_id"><br>
                    Color: <input type="text" name="color"><br>
                    Email: <input type="text" name="email"><br>
                    <input type="submit" value="Submit"><br>
                    </form>'''


# Run and check for exceptions
if __name__ == '__main__':
    app.run(debug=True)

