package Controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.Musician;
import pojo.Album;
import pojo.Song;
import DAOImpl.SongDaoImpl;
import org.hibernate.Session;
import DAOImpl.HibernateUtil;

public class SongController extends HttpServlet {
	
	Song song = new Song();
	SongDaoImpl songDaoImpl = new SongDaoImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
		
		if (request.getParameter("addSong") != null) {
			
			int IAE = 0;
			Integer idalbum = java.lang.Integer.parseInt(request.getParameter("idalbum"));
			Integer idmusician = java.lang.Integer.parseInt(request.getParameter("idmusician"));
			Session session = HibernateUtil.getSessionFactory().openSession();
			Album album = (Album) session.get(Album.class, idalbum);
			Musician musician = (Musician) session.get(Musician.class, idmusician);
			Date releasedate = null;
			try {
				releasedate = Date.valueOf(request.getParameter("releasedate"));
			} catch(IllegalArgumentException e) {
				e.printStackTrace();
				IAE = 1;
			}
			
			if (IAE == 0) {
				String name = request.getParameter("name");
				String features = request.getParameter("features");
				String awards = request.getParameter("awards");
				String nominations = request.getParameter("nominations");
				
				song.setAlbums(album);
				song.setMusicians(musician);
				song.setName(name);
				song.setReleasedate(releasedate);
				song.setFeatures(features);
				song.setAwards(awards);
				song.setNominations(nominations);
				songDaoImpl.addSong(song);
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("add_Song.jsp");
			rd.forward(request, response);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if (request.getParameter("showSongs") != null) {
			List<Song> songList = new ArrayList();
			songList = songDaoImpl.showSongs();
			request.setAttribute("songList", songList);
			RequestDispatcher rd = request.getRequestDispatcher("songs_table.jsp");
			rd.forward(request, response);
		}
		
		if (request.getParameter("modifySong") != null) {
			Integer id1 = Integer.parseInt(request.getParameter("idsong"));
			Integer idalbum = Integer.parseInt(request.getParameter("idalbum"));
			Integer idmusician = Integer.parseInt(request.getParameter("idmusician"));
			Session session = HibernateUtil.getSessionFactory().openSession();
			Album album = (Album) session.get(Album.class, idalbum);
			Musician musician = (Musician) session.get(Musician.class, idmusician);
			String name = request.getParameter("name");
			String features = request.getParameter("features");
			String awards = request.getParameter("awards");
			String nominations = request.getParameter("nominations");
			
			int IAE = 0;
			Date releasedate = null;
			try {
				releasedate = Date.valueOf(request.getParameter("releasedate"));
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
				IAE = 1;
			}
			
			if (IAE == 0) {
				songDaoImpl.modifySong(id1, album, musician, name, releasedate, features,
						awards, nominations);
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("add_Song.jsp");
			rd.forward(request, response);
			
		}
		
		if (request.getParameter("deleteSong") != null) {
			Integer id2 = Integer.parseInt(request.getParameter("idsong"));
			song.setIdsong(id2);
			songDaoImpl.deleteSong(song);
			RequestDispatcher rd = request.getRequestDispatcher("add_Song.jsp");
			rd.forward(request, response);
		}	
	}
	
	@Override
	public String getServletInfo() {
		return "Short description";
	}
}
