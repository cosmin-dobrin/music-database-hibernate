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
    <link rel="stylesheet" href="CSS/form_style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Song</title>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <div id="add">
            <h1> Add a new song </h1>
            <form action="SongController" method="GET">
                <table align="center">
                    <tr>
                        <td> Album: </td>
                        <td>
                            <select name="idalbum">
                                <c:forEach items="${albumList}" var="albums">
                                    <option value="${albums.idalbum}">${albums.idalbum},
                                     ${albums.name}, ${albums.nrsongs}, ${albums.releasedate},
                                      ${albums.awards}, ${albums.nominations}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td> Musician: </td>
                        <td>
                            <select name="idmusician">
                                <c:forEach items="${musicianList}" var="musicians">
                                    <option value="${musicians.idmusician}">${musicians.idmusician},
                                     ${musicians.firstname}, ${musicians.lastname}, ${musicians.birthdate},
                                      ${musicians.age}, ${musicians.musictype}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td> Name: </td>
                        <td><input type="text" name="name"></td>
                    </tr>
                    <tr>
                        <td> Release date: </td>
                        <td><input type="text" name="releasedate" placeholder="yyyy-mm-dd"></td>
                    </tr>
                    <tr>
                        <td> Features: </td>
                        <td><input type="text" name="features"></td>
                    </tr>
                     <tr>
                        <td> Awards: </td>
                        <td><input type="text" name="awards"></td>
                    </tr>
                     <tr>
                        <td> Nominations: </td>
                        <td><input type="text" name="nominations"></td>
                    </tr>
                    
                    <tr>
                        <td><input type="submit" name="addSong" value="Add"></td>

                    </tr>
                </table>
            </form>
        </div>

        <form action="SongController" method="POST">
        	<p align="center">
            <input type="submit" name="showSongs" value="Show">
            </p>
        </form>
        <br>
        <br>
        <br>
        <br>
        <p align="center">
        <a href="index.html"><b>Home</b></a>
        </p>
    </body>
</html>
