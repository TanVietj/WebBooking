<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Your Bookings</title>
    <!-- Bắt đầu thêm CSS Bootstrap -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- Kết thúc thêm CSS Bootstrap -->
    <style>
        body {
            background-color: #f8f9fa;
            padding: 20px;
        }
        h2 {
            text-align: center;
            margin-bottom: 30px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #dee2e6;
        }
        th {
            background-color: #007bff;
            color: #ffffff;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Your Bookings</h2>
        <table class="table">
            <thead class="thead-dark">
                <tr>
                    <th>Room Number</th>
                    <th>Check In</th>
                    <th>Check Out</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="booking" items="${bookings}">
                    <tr>
                        <td>${booking.roomNumber}</td>
                        <td>${booking.checkIn}</td>
                        <td>${booking.checkOut}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
  <!-- Bắt đầu thêm JS Bootstrap (nếu cần) -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <!-- Kết thúc thêm JS Bootstrap -->
</body>
</html>