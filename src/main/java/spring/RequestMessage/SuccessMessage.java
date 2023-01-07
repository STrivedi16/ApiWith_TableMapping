package spring.RequestMessage;

public class SuccessMessage {

	private String successmessage;

	private String successkey;

	private Object object;

	public String getSuccessmessage() {
		return successmessage;
	}

	public void setSuccessmessage(String successmessage) {
		this.successmessage = successmessage;
	}

	public String getSuccesskey() {
		return successkey;
	}

	public void setSuccesskey(String successkey) {
		this.successkey = successkey;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public SuccessMessage(String successmessage, String successkey, Object object) {
		super();
		this.successmessage = successmessage;
		this.successkey = successkey;
		this.object = object;
	}

	public SuccessMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

}
