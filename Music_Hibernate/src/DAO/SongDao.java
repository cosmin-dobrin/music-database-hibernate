package DAO;

import java.util.List;
import pojo.Song;
import java.util.Date;
import pojo.Musician;
import pojo.Album;

public interface SongDao {

	public void addSong(Song song);
	public List<Song> showSongs();
	public void modifySong(Integer idsong, Album album, 
						Musician musician, String name,
						Date releasedate, String features, 
						String awards, String nominations);
	public void deleteSong(Song song);
}
