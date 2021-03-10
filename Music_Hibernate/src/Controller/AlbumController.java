package Controller;

import DAO.AlbumDao;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import pojo.Album;
import DAOImpl.AlbumDaoImpl;
import DAOImpl.HibernateUtil;


public class AlbumController extends HttpServlet {

	Album album = new Album();
	AlbumDaoImpl albumDaoImpl = new AlbumDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
		
		if (request.getParameter("addAlbum") != null) {
			int IAE = 0;
			Date releasedate = null;
			Integer nrsongs = null;
			try {
				releasedate = Date.valueOf(request.getParameter("releasedate"));
				nrsongs = Integer.parseInt(request.getParameter("nrsongs"));
			} catch(IllegalArgumentException e) {
				e.printStackTrace();
				IAE = 1;
			}
			
			if (IAE == 0) {
				String name = request.getParameter("name");
				String awards = request.getParameter("awards");
				String nominations = request.getParameter("nominations");
				
				album.setName(name);
				album.setNrsongs(nrsongs);
				album.setReleasedate(releasedate);
				album.setAwards(awards);
				album.setNominations(nominations);
				albumDaoImpl.addAlbum(album);
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("add_Album.jsp");
			rd.forward(request, response);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if (request.getParameter("showAlbums") != null) {
			List<Album> albumList = new ArrayList();
			albumList = albumDaoImpl.showAlbums();
			request.setAttribute("albumList", albumList);
			RequestDispatcher rd = request.getRequestDispatcher("albums_table.jsp");
			rd.forward(request, response);
		}
		
		if (request.getParameter("modifyAlbum") != null) {
			
			int IAE = 0;
			Date releasedate = null;
			Integer nrsongs = null;
			try {
				releasedate = Date.valueOf(request.getParameter("releasedate"));
				nrsongs = Integer.parseInt(request.getParameter("nrsongs"));
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
				IAE = 1;
			}
			
			if (IAE == 0) {
				Integer idalbum = Integer.parseInt(request.getParameter("idalbum"));
				String name = request.getParameter("name");
				String awards = request.getParameter("awards");
				String nominations = request.getParameter("nominations");
				
				albumDaoImpl.modifyAlbum(idalbum, name, nrsongs, releasedate,
						awards, nominations);
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("add_Album.jsp");
			rd.forward(request, response);
			
		}
		
		if (request.getParameter("deleteAlbum") != null) {
			Integer idalbum = Integer.parseInt(request.getParameter("idalbum"));
			album.setIdalbum(idalbum);
			albumDaoImpl.deleteAlbum(album);
			RequestDispatcher rd = request.getRequestDispatcher("add_Album.jsp");
			rd.forward(request, response);
		}	
	}
	
	@Override
	public String getServletInfo() {
		return "Short description";
	}
}
