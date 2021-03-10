<%@page import="DAOImpl.MusicianDaoImpl"%>
<%@page import="DAOImpl.AlbumDaoImpl"%>
<%@page import="pojo.Musician"%>
<%@page import="java.util.ArrayList"%>
<%@page import="pojo.Album"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    	<link rel="stylesheet" href="CSS/style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Songs</title>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script>
            $(document).ready(function () {
                $("#deleteSong").hide();
                $("#modifySong").hide();

                $('#update').click(function() {
                    $("#modifySong").toggle(this.checked);
                });
                
                $('#delete').click(function() {
                    $("#deleteSong").toggle(this.checked);
                });
            });
        </script>

    </head>
    <body>
        <%
            AlbumDaoImpl albumDaoImpl = new AlbumDaoImpl();
            MusicianDaoImpl musicianDaoImpl = new MusicianDaoImpl();
            List<Album> albumList = new ArrayList();
            albumList = albumDaoImpl.showAlbums();
            List<Musician> musicianList = new ArrayList();
            musicianList = musicianDaoImpl.showMusicians();
            request.setAttribute("albumList", albumList);
            request.setAttribute("musicianList", musicianList);
        %>
        <h1 align="center"> Songs:</h1>
        
        <table border="1" align="center">
        	<thead>
            <tr>
                <th><b>IdSong:</b></th>
                <th><b>IdAlbum:</b></th>
                <th><b>Album name:</b></th>
                <th><b>Number of songs:</b></th>
                <th><b>Album release date:</b></th>
                <th><b>Album awards:</b></th>
                <th><b>Album nominations:</b></th>
                <th><b>IdMusician:</b></th>
                <th><b>First name:</b></th>
                <th><b>Last name:</b></th>
                <th><b>Birthdate:</b></th>
                <th><b>Age:</b></th>
                <th><b>Music type:</b></th>
                <th><b>Song name:</b></th>
                <th><b>Song release date:</b></th>
                <th><b>Song features:</b></th>
                <th><b>Song awards:</b></th>
                <th><b>Song nominations:</b></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="songs" items="${songList}">
                <tr>
                    <td>${songs.idsong}</td>
                    <td>${songs.albums.idalbum}</td>
                    <td>${songs.albums.name}</td>
                    <td>${songs.albums.nrsongs}</td>
                    <td>${songs.albums.releasedate}</td>
                    <td>${songs.albums.awards}</td>
                    <td>${songs.albums.nominations}</td>
                    <td>${songs.musicians.idmusician}</td>
                    <td>${songs.musicians.firstname}</td>
                    <td>${songs.musicians.lastname}</td>
                    <td>${songs.musicians.birthdate}</td>
                    <td>${songs.musicians.age}</td>
                    <td>${songs.musicians.musictype}</td>
                    <td>${songs.name}</td>
                    <td>${songs.releasedate}</td>
                    <td>${songs.features}</td>
                    <td>${songs.awards}</td>
                    <td>${songs.nominations}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
       <br>
       <p align="center">
            <a href="index.html" class="homeLink"><b>Home</b></a>
        </p>
        <form action="SongController" method="POST">
            <p align="center">
                Modify: <input type="checkbox" id="update"> 
                Delete: <input type="checkbox" id="delete" 
                onclick="document.getElementById('idalbum').disabled = this.checked;
                         document.getElementById('idmusician').disabled = this.checked;
                         document.getElementById('name').disabled = this.checked;
                         document.getElementById('releasedate').disabled = this.checked;
                         document.getElementById('features').disabled = this.checked;
                         document.getElementById('awards').disabled = this.checked;
                         document.getElementById('nominations').disabled = this.checked;"><br><br>
                IdSong: <br>
                <select name="idsong">
                    <c:forEach items="${songList}" var="songs">
                        <option value="${songs.idsong}">${songs.idsong}</option>
                    </c:forEach>
                </select>
                <br>
                IdAlbum: <br>
                <select name="idalbum">
                    <c:forEach items="${albumList}" var="albums">
                        <option value="${albums.idalbum}">${albums.idalbum}, ${albums.name},
                         ${albums.nrsongs}, ${albums.releasedate}, ${albums.awards}, ${albums.nominations}</option>
                    </c:forEach>
                </select>
                <br>
                IdMusician: <br>
                <select name="idmusician">
                    <c:forEach items="${musicianList}" var="musicians">
                        <option value="${musicians.idmusician}">${musicians.idmusician},
                         ${musicians.firstname}, ${musicians.lastname}, ${musicians.birthdate},
                          ${musicians.age}, ${musicians.musictype}</option>
                    </c:forEach>
                </select>
                <br>
                Modify song name: <br><input id="name" type="text" name="name"><br>
                Modify song release date: <br><input id="releasedate" type="text" name="releasedate" placeholder="yyyy-mm-dd"> <br>
                Modify song features: <br><input id="features" type="text" name="features"> <br>
                Modify song awards: <br><input id="awards" type="text" name="awards"> <br>
                Modify song nominations: <br><input id="nominations" type="text" name="nominations"> <br>
                <button type="submit" id="modifySong" name="modifySong"> Modify</button> <br> <br>
                <button type="submit" id="deleteSong" name="deleteSong"> Delete </button>
            </p>
        </form>
        
    </body>
</html>
