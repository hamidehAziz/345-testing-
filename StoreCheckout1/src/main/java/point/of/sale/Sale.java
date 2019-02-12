package point.of.sale;


public class Sale {
	
	HashStorage hashLookUp;
	Display display;
	
		
	public Sale (Display display, HashStorage hashStorage) {
			
			this.display = display;
			this.hashLookUp = hashStorage;
	}
	
		
	public Sale () {
			
			display = new  ArtR56Display();
			
			
			hashLookUp = new HashStorage();		
			hashLookUp.put("A1", "Milk, 3.99");
			hashLookUp.put("A2", "Bread, 1.99");
	}
	
		
	

	
	public void scan(String barcode) {
		
			display.showLine(barcode);			
			String item = hashLookUp.barcode(barcode);			
			display.showLine(item);
		
	}
}
