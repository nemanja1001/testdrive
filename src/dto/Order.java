package dto;

public class Order {

	private int id;
	private String status;
	private static int Id = 0;
	private int myId;
	
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMyId() {
		return myId;
	}
	public void setMyId(int myId) {
		this.myId = myId;
	}
}
