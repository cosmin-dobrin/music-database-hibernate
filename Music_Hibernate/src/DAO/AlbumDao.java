package DAO;

import java.util.List;
import pojo.Song;
import java.util.Date;
import pojo.Musician;
import pojo.Album;

public interface AlbumDao {

	public void addAlbum(Album album);
	public List<Album> showAlbums();
	public void modifyAlbum(Integer idalbum, String name,
						Integer nrsongs, Date releasedate,
						String awards, String nominations);
	public void deleteAlbum(Album album);
}
