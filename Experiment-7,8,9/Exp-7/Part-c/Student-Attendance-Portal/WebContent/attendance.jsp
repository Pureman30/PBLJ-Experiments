<!DOCTYPE html>
<html>
<head>
    <title>Student Attendance</title>
</head>
<body>
    <h2>Attendance Form</h2>

    <form action="attendance" method="post">
        Student ID: <input type="text" name="sid" required><br><br>
        Date: <input type="text" name="date" required><br><br>
        Status:
        <select name="status">
            <option>Present</option>
            <option>Absent</option>
        </select>
        <br><br>

        <input type="submit" value="Mark Attendance">
    </form>
</body>
</html>
