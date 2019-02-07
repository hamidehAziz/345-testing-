package point.of.sale;

public class Sale {
	
	HashStorage hashLookUp;
	Display display;
	
	
	public Sale() {
		 Display display = new FakeDisplay();
		HashStorage hashLookUp = new HashStorage();
		
		
		hashLookUp.put("A1", "Milk , 3.99");
		hashLookUp.put("A2", "Bread , 1.99");
	}

	
	public void Scan(String barcode) {
		display.showLine(barcode);
		
		String item = hashLookUp.barcode(barcode);
		
		display.showLine(item);
		
	}
}
