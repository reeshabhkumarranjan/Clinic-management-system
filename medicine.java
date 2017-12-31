class medicine {

	static double tax;
	static int packetIdTracker;

	int packetID;
	String name;
	String type;
	int stockQty;

	public medicine(String name,String type,int stockQty) {
		this.name=name;
		this.type=type;
		//this.packetID=packetID;
		this.stockQty=stockQty;
	}
}