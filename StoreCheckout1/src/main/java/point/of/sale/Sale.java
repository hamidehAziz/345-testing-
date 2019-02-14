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
		
		//lookup barcode in postgres and get item
				String item = hashLookUp.barcode(barcode);			

		 		//display the barcode
				display.showLine(barcode);


		 		//display the item			
				display.showLine(item);			
			
		
	}
}
