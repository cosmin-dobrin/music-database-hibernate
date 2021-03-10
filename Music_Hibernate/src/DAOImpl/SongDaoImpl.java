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
import DAO.SongDao;

public class SongDaoImpl implements SongDao {

	public void addSong(Song song) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(song);
		transaction.commit();
		session.close();
	}
	
	public List<Song> showSongs() {
		List<Song> songsList = new ArrayList();
		Session session = HibernateUtil.getSessionFactory().openSession();
		org.hibernate.query.Query query = session.createQuery("From Song");
		songsList = query.list();
		return songsList;
	}
	
	public void modifySong(Integer idsong, Album album, Musician musician, 
			String name, Date releasedate, String features, String awards, String nominations) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Song songDetails;
		songDetails = (Song) session.load(Song.class, idsong);
		songDetails.setAlbums(album);
		songDetails.setMusicians(musician);
		songDetails.setName(name);
		songDetails.setReleasedate(releasedate);
		songDetails.setFeatures(features);
		songDetails.setAwards(awards);
		songDetails.setNominations(nominations);
		session.update(songDetails);
		transaction.commit();
		session.close();
	}
	
	public void deleteSong(Song song) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(song);
		transaction.commit();
		session.close();
	}
}
