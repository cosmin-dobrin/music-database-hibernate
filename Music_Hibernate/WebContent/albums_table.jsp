<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    	<link rel="stylesheet" href="CSS/style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Albums</title>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script>
            $(document).ready(function () {
                $("#deleteAlbum").hide();
                $("#modifyAlbum").hide();

                $('#update').click(function() {
                    $("#modifyAlbum").toggle(this.checked);
                });
                
                $('#delete').click(function() {
                    $("#deleteAlbum").toggle(this.checked);
                });
            });
        </script>

    </head>
    <body>
        <h1 align="center"> Albums table:</h1> 
        <table border="1" align="center">
        	<thead>
            <tr>
                <th><b>IdAlbum:</b></th>
                <th><b>Name:</b></th>
                <th><b>NrSongs:</b></th>
                <th><b>Release date:</b></th>
                <th><b>Awards:</b></th>
                <th><b>Nominations:</b></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="albums" items="${albumList}">
                <tr>
                    <td>${albums.idalbum}</td>
                    <td>${albums.name}</td>
                    <td>${albums.nrsongs}</td>
                    <td>${albums.releasedate}</td>
                    <td>${albums.awards}</td>
                    <td>${albums.nominations}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <br>
         <p align="center">
            <a href="index.html" class="homeLink"><b>Home</b></a>
        </p>
        
        <form action="AlbumController" method="POST">
            <p align="center">
                Modify: <input type="checkbox" id="update"> 
                Delete: <input type="checkbox" id="delete" 
                onclick="document.getElementById('name').disabled = this.checked;
                         document.getElementById('nrsongs').disabled = this.checked;
                         document.getElementById('releasedate').disabled = this.checked;
                         document.getElementById('awards').disabled = this.checked;
                         document.getElementById('nominations').disabled = this.checked;"><br><br>
                IdAlbum: <br>
                <select name="idalbum">
                    <c:forEach items="${albumList}" var="albums">
                        <option value="${albums.idalbum}">${albums.idalbum}</option>
                    </c:forEach>
                </select>
                <br>
                Modify Name: <br><input id="name" type="text" name="name"><br>
                Modify Number of songs: <br><input id="nrsongs" type="text" name="nrsongs"> <br>
                Modify Release date: <br><input id="releasedate" type="text" name="releasedate" placeholder="yyyy-mm-dd"> <br>
                Modify Awards: <br><input id="awards" type="text" name="awards"> <br>
                Modify Nominations: <br><input id="nominations" type="text" name="nominations"> <br>
                <button type="submit" id="modifyAlbum" name="modifyAlbum"> Modify</button> <br> <br>
                <button type="submit" id="deleteAlbum" name="deleteAlbum"> Delete </button>
            </p>
        </form>
    </body>
</html>
