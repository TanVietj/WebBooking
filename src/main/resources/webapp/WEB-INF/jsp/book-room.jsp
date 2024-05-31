<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book Room</title>
    <!-- Bắt đầu thêm CSS Bootstrap -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- Kết thúc thêm CSS Bootstrap -->
    <style>
        body {
            background-color: #f8f9fa;
            padding: 20px;
        }
        .container {
            max-width: 400px;
            margin: auto;
            background-color: #ffffff;
            border-radius: 10px;
            padding: 20px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }
        h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        label {
            font-weight: bold;
        }
        input[type="text"],
        input[type="date"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ced4da;
            border-radius: 4px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            border: none;
            border-radius: 4px;
            background-color: #007bff;
            color: #ffffff;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Book Room</h2>
        <form action="/user/book-room" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <div class="form-group">
                <label for="roomNumber">Room Number:</label>
                <input type="text" class="form-control" id="roomNumber" name="roomNumber">
            </div>
            <div class="form-group">
                <label for="checkIn">Check In:</label>
                <input type="date" class="form-control" id="checkIn" name="checkIn">
            </div>
            <div class="form-group">
                <label for="checkOut">Check Out:</label>
                <input type="date" class="form-control" id="checkOut" name="checkOut">
            </div>
            <button type="submit" class="btn btn-primary">Book Room</button>
        </form>
    </div>
    <!-- Bắt đầu thêm JS Bootstrap (nếu cần) -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <!-- Kết thúc thêm JS Bootstrap -->
</body>
</html>
