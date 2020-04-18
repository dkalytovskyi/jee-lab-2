
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Movie</title>
</head>
<body>
    <h1>Movie registration</h1>
    <h3>Please, enter movie parameters:</h3>
    <form action="add-new-movie" method="POST">
        <table>
            <tr>
                <td>Title:</td>
                <td><input type="text" name="title" size="20px" /></td>
            </tr>
            <tr>
                <td>Director:</td>
                <td><input type="text" name="director" /></td>
            </tr>
            <tr>
                <td>Release Year:</td>
                <td><input type="text" name="year"/></td>
            </tr>
            <tr>
                <td>IMDb Rating</td>
                <td><input type="text" name="imdb_rate" /></td>
            </tr>
            <tr>
                <td><input type="submit" value="submit" /></td>
            </tr>
        </table>
    </form>
</body>
</html>
