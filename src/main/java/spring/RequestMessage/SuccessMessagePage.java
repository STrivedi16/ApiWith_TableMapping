package spring.RequestMessage;

public class SuccessMessagePage {

	private String Message;

	private String Key;

	private Object object;

	private Integer pagenumber;

	private Integer pagesize;

	private Integer totalPages;

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public String getKey() {
		return Key;
	}

	public void setKey(String key) {
		Key = key;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public Integer getPagenumber() {
		return pagenumber;
	}

	public void setPagenumber(Integer pagenumber) {
		this.pagenumber = pagenumber;
	}

	public Integer getPagesize() {
		return pagesize;
	}

	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public SuccessMessagePage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SuccessMessagePage(String message, String key, Object object, Integer pagenumber, Integer pagesize,
			Integer totalPages) {
		super();
		Message = message;
		Key = key;
		this.object = object;
		this.pagenumber = pagenumber;
		this.pagesize = pagesize;
		this.totalPages = totalPages;
	}

}
