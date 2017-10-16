package ChandyLamport;

public class RecorderThread extends Thread {
	String name;
	Buffer channel;
	public RecorderThread(String name) {
		this.name = name;
	}
	public void setChannel(Buffer channel) {
		this.channel = channel;
	}
}
