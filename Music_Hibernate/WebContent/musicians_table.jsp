<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    	<link rel="stylesheet" href="CSS/style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Musicians</title>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script>
            $(document).ready(function () {
                $("#deleteMusician").hide();
                $("#modifyMusician").hide();

                $('#update').click(function() {
                    $("#modifyMusician").toggle(this.checked);
                });
                
                $('#delete').click(function() {
                    $("#deleteMusician").toggle(this.checked);
                });
            });
        </script>

    </head>
    <body>
        <h1 align="center"> Musicians:</h1> 
        <table border="1" align="center">
        	<thead>
            <tr>
                <th><b>IdMusician:</b></th>
                <th><b>Firstname:</b></th>
                <th><b>Lastname:</b></th>
                <th><b>Birthdate:</b></th>
                <th><b>Age:</b></th>
                <th><b>Music type:</b></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="musicians" items="${musicianList}">
                <tr>
                    <td>${musicians.idmusician}</td>
                    <td>${musicians.firstname}</td>
                    <td>${musicians.lastname}</td>
                    <td>${musicians.birthdate}</td>
                    <td>${musicians.age}</td>
                    <td>${musicians.musictype}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <br>
        <p align="center">
            <a href="index.html" class="homeLink"><b>Home</b></a>
        </p>
        
        <form action="MusicianController" method="POST">
            <p align="center">
                Modify: <input type="checkbox" id="update"> 
                Delete: <input type="checkbox" id="delete" 
                onclick="document.getElementById('firstname').disabled = this.checked;
                         document.getElementById('lastname').disabled = this.checked;
                         document.getElementById('birthdate').disabled = this.checked;
                         document.getElementById('age').disabled = this.checked;
                         document.getElementById('musictype').disabled = this.checked;"><br><br>
                IdMusician: <br>
                <select name="idmusician">
                    <c:forEach items="${musicianList}" var="musicians">
                        <option value="${musicians.idmusician}">${musicians.idmusician}</option>
                    </c:forEach>
                </select>
                <br>
                Modify First name: <br><input id="firstname" type="text" name="firstname"><br>
                Modify Last name: <br><input id="lastname" type="text" name="lastname"> <br>
                Modify Birthdate: <br><input id="birthdate" type="text" name="birthdate" placeholder="yyyy-mm-dd"> <br>
                Modify Age: <br><input id="age" type="text" name="age"> <br>
                Modify Music type: <br><input id="musictype" type="text" name="musictype"> <br>
                <button type="submit" id="modifyMusician" name="modifyMusician"> Modify</button> <br> <br>
                <button type="submit" id="deleteMusician" name="deleteMusician"> Delete </button>
            </p>
        </form>
    </body>
</html>
