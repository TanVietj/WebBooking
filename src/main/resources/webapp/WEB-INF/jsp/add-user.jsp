<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add User</title>
</head>
<body>
    <h2>Add User</h2>
    <form action="/admin/addUser" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br>
        <label for="role">Role:</label>
        <select id="role" name="role">
            <option value="USER">USER</option>
            <option value="ADMIN">ADMIN</option>
        </select><br>
        <button type="submit">Add User</button>
    </form>
    <a href="/admin/users">Back to User List</a>
</body>
</html>