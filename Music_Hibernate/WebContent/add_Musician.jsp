<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <link rel="stylesheet" href="CSS/form_style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Musicians</title>
    </head>
    <body>

        <div id="add">
            <h1> Add musician </h1>
            <form action="MusicianController" method="GET">
                <table align="center">
                    <tr>
                        <td> First name: </td>
                        <td><input type="text" name="firstname"></td>
                    </tr>
                    <tr>
                        <td> Last name: </td>
                        <td><input type="text" name="lastname"></td>
                    </tr>
                    <tr>
                        <td> Birthdate: </td>
                        <td><input type="text" name="birthdate" placeholder="yyyy-mm-dd"></td>
                    </tr>
                    <tr>
                        <td> Age: </td>
                        <td><input type="text" name="age"></td>
                    </tr>
                    <tr>
                        <td> Music type: </td>
                        <td><input type="text" name="musictype"></td>
                    </tr>
                    <tr>
                        <td><input type="submit" name="addMusician" value="Add"></td>

                    </tr>
                </table>
            </form>
        </div>

        <form action="MusicianController" method="POST">
        	<p align="center">
            <input type="submit" name="showMusicians" value="Show">
            <p>
        </form>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <p align="center">
        <a href="index.html"><b>Home</b></a>
        </p>
    </body>
</html>
