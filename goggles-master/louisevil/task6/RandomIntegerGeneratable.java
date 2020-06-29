package task6;

interface RandomIntegerGeneratable{
	public default int getRandomInt(int start,int end) {
		return (int)(Math.random()*end+1)+ start;
	}
}