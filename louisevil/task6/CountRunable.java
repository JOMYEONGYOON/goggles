package task6;

public class CountRunable implements Runnable {
	private int integer;
	public CountRunable(int integer) {
		this.integer = integer;
	
	}
	public int getInteger() {
		return integer;
	}

	public void setInteger(int integer) {
		this.integer = integer;
	}

	@Override
	public void run() {
		while (true) { // 무한 루프
			integer++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}