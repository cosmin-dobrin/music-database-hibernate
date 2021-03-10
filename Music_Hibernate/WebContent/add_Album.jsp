<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <link rel="stylesheet" href="CSS/form_style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Albums</title>
    </head>
    <body>

        <div id="add">
            <h1> Add album </h1>
            <form action="AlbumController" method="GET">
                <table align="center">
                    <tr>
                        <td> Album name: </td>
                        <td><input type="text" name="name"></td>
                    </tr>
                    <tr>
                        <td> Number of songs on the album: </td>
                        <td><input type="text" name="nrsongs"></td>
                    </tr>
                    <tr>
                        <td> Release date: </td>
                        <td><input type="text" name="releasedate" placeholder="yyyy-mm-dd"></td>
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
                        <td><input type="submit" name="addAlbum" value="Add"></td>
                    </tr>
                </table>
            </form>
        </div>

        <form action="AlbumController" method="POST" >
        		<p>
            	<input type="submit" name="showAlbums" value="Show"> 
            	</p>
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