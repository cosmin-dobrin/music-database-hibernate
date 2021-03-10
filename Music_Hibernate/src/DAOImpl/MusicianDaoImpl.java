package DAOImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Musician;
import pojo.Album;
import pojo.Song;
import DAO.MusicianDao;

public class MusicianDaoImpl implements MusicianDao {
	
	public void addMusician(Musician musician) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(musician);
		transaction.commit();
		session.close();
	}
	
	public List<Musician> showMusicians() {
		List<Musician> musiciansList = new ArrayList();
		Session session = HibernateUtil.getSessionFactory().openSession();
		org.hibernate.query.Query query = session.createQuery("From Musician");
		musiciansList = query.list();
		return musiciansList;
	}
	
	public void modifyMusician(Integer idmusician, String firstname,
			String lastname, Date birthdate,
			Integer age, String musictype) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Musician musicianDetails;
		musicianDetails = (Musician) session.load(Musician.class, idmusician);
		musicianDetails.setFirstname(firstname);
		musicianDetails.setLastname(lastname);
		musicianDetails.setBirthdate(birthdate);
		musicianDetails.setAge(age);
		musicianDetails.setMusictype(musictype);
		session.update(musicianDetails);
		transaction.commit();
		session.close();
	}
	
	public void deleteMusician(Musician musician) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(musician);
		transaction.commit();
		session.close();
	}
}
