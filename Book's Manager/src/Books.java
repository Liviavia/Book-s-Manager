
public class Books {
	private String booksTitle;
	private String booksType;
	private int booksChapter;
	private int booksPrice;
	private String booksID;
	
	public Books(String booksTitle, String booksType, int booksChapter, int booksPrice, String booksID) {
		super();
		this.booksTitle = booksTitle;
		this.booksType = booksType;
		this.booksChapter = booksChapter;
		this.booksPrice = booksPrice;
		this.booksID = booksID;
	}

	public String getBooksTitle() {
		return booksTitle;
	}

	public void setBooksTitle(String booksTitle) {
		this.booksTitle = booksTitle;
	}

	public String getBooksType() {
		return booksType;
	}

	public void setBooksType(String booksType) {
		this.booksType = booksType;
	}

	public int getBooksChapter() {
		return booksChapter;
	}

	public void setBooksChapter(int booksChapter) {
		this.booksChapter = booksChapter;
	}

	public int getBooksPrice() {
		return booksPrice;
	}

	public void setBooksPrice(int booksPrice) {
		this.booksPrice = booksPrice;
	}

	public String getBooksID() {
		return booksID;
	}

	public void setBooksID(String booksID) {
		this.booksID = booksID;
	}
	
	
	
	
}
