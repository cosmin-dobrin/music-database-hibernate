package Controller;

import DAO.MusicianDao;
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
import DAOImpl.MusicianDaoImpl;
import org.hibernate.Session;
import DAOImpl.HibernateUtil;

public class MusicianController extends HttpServlet {

	Musician musician = new Musician();
	MusicianDaoImpl musicianDaoImpl = new MusicianDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
		
		if (request.getParameter("addMusician") != null) {
			int IAE = 0;
			Date birthdate = null;
			Integer age = null;
			try {
				birthdate = Date.valueOf(request.getParameter("birthdate"));
				age = Integer.parseInt(request.getParameter("age"));
			} catch(IllegalArgumentException e) {
				e.printStackTrace();
				IAE = 1;
			}
			
			if (IAE == 0) {
				String firstname = request.getParameter("firstname");
				String lastname = request.getParameter("lastname");
				String musictype = request.getParameter("musictype");
				
				musician.setFirstname(firstname);
				musician.setLastname(lastname);
				musician.setBirthdate(birthdate);
				musician.setAge(age);
				musician.setMusictype(musictype);
				musicianDaoImpl.addMusician(musician);
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("add_Musician.jsp");
			rd.forward(request, response);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if (request.getParameter("showMusicians") != null) {
			List<Musician> musicianList = new ArrayList();
			musicianList = musicianDaoImpl.showMusicians();
			request.setAttribute("musicianList", musicianList);
			RequestDispatcher rd = request.getRequestDispatcher("musicians_table.jsp");
			rd.forward(request, response);
		}
		
		if (request.getParameter("modifyMusician") != null) {
			int IAE = 0;
			Date birthdate = null;
			Integer age = null;
			try {
				birthdate = Date.valueOf(request.getParameter("birthdate"));
				age = Integer.parseInt(request.getParameter("age"));
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
				IAE = 1;
			}
			
			if (IAE == 0) {
				Integer idmusician = Integer.parseInt(request.getParameter("idmusician"));
				String firstname = request.getParameter("firstname");
				String lastname = request.getParameter("lastname");
				String musictype = request.getParameter("musictype");
				
				musicianDaoImpl.modifyMusician(idmusician, firstname, lastname, birthdate,
						age, musictype);
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("add_Musician.jsp");
			rd.forward(request, response);
			
		}
		
		if (request.getParameter("deleteMusician") != null) {
			Integer idmusician = Integer.parseInt(request.getParameter("idmusician"));
			musician.setIdmusician(idmusician);
			musicianDaoImpl.deleteMusician(musician);
			RequestDispatcher rd = request.getRequestDispatcher("add_Musician.jsp");
			rd.forward(request, response);
		}	
	}
	
	@Override
	public String getServletInfo() {
		return "Short description";
	}
}
