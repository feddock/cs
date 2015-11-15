/**
 * Basic representation of a novel
 * @author Henson Sturgill
 * @version 2015.11.13
 */
public class Novel {
	// Title of the novel
	private String title;
	
	// Author of the novel
	private String author;
	
	// Genre of the novel
	private String genre;
	
	// Year novel was published
	private int date;
	
	/**
	 * Intialize novel with title, author, genre, and date
	 * @param title Novel title
	 * @param author Novel author
	 * @param genre Novel genre
	 * @param date Novel date
	 */
	public Novel(String title, String author, String genre, int date) {
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.date = date;
	}
	
	/**
	 * Create a string representation of Novel
	 * @return Novel description
	 */
	@Override
	public String toString() {
		// What we'll use for a separator
		String sep = " : ";
		
		StringBuilder retStr = new StringBuilder(title);
		retStr.append(sep).append(author);
		retStr.append(sep).append(genre);
		retStr.append(sep).append(date);
		
		return retStr.append('.').toString();
	}
	
	/**
	 * Compare this novel to another
	 * @param o Other novel
	 * @return True if same
	 */
	@Override
	public boolean equals(Object o) {
		Novel other;
		
		if (o instanceof Novel) {
			other = (Novel) o;
			return other.author.equals(this.author) &&
					other.genre.equals(this.genre) &&
					other.title.equals(this.title) &&
					other.date == this.date;
		}
			
		return false;
	}

	/**
	 * Get the title of the novel
	 * @return Novel title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Set the title of the novel
	 * @param title Novel title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Get the author of the novel
	 * @return Novel author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Set the author of the  novel
	 * @param author Novel author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * Get the genre of the novel
	 * @return Novel genre
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * Set the genre of the novel
	 * @param genre Novel genre
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	/**
	 * Get the date of the novel
	 * @return Novel date
	 */
	public int getDate() {
		return date;
	}

	/**
	 * Set the date of the novel
	 * @param date Novel date
	 */
	public void setDate(int date) {
		this.date = date;
	}
}