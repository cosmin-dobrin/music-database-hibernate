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
import DAO.AlbumDao;

public class AlbumDaoImpl implements AlbumDao {

	public void addAlbum(Album album) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(album);
		transaction.commit();
		session.close();
	}
	
	public List<Album> showAlbums() {
		List<Album> albumsList = new ArrayList();
		Session session = HibernateUtil.getSessionFactory().openSession();
		org.hibernate.query.Query query = session.createQuery("From Album");
		albumsList = query.list();
		return albumsList;
	}
	
	public void modifyAlbum(Integer idalbum, String name,
			Integer nrsongs, Date releasedate,
			String awards, String nominations) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Album albumDetails;
		albumDetails = (Album) session.load(Album.class, idalbum);
		albumDetails.setName(name);
		albumDetails.setNrsongs(nrsongs);
		albumDetails.setReleasedate(releasedate);
		albumDetails.setAwards(awards);
		albumDetails.setNominations(nominations);
		session.update(albumDetails);
		transaction.commit();
		session.close();
	}
	
	public void deleteAlbum(Album album) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(album);
		transaction.commit();
		session.close();
	}
}
