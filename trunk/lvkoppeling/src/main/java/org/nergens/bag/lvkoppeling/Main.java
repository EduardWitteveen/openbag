package org.nergens.bag.lvkoppeling;

public class Main {
	public static void main(String[] args) {
		// create the client stub
		nl.vrom.www.bag.stuf._0120.STUFBAGSynchroonStub stub = new nl.vrom.www.bag.stuf._0120.STUFBAGSynchroonStub(target);				        
		// do something
		stub.beantwoordVraag(vraagBericht3)
		String isbn = "0061020052";
		GetBook gb = new GetBook();
		gb.setIsbn(isbn);
		GetBookResponse gbr = stub.getBook(gb);
		BookInformation book = gbr.getGetBookReturn();
		if (book == null) {
		  System.out.println("No book found with ISBN '" + isbn + '\'');
		} else {
		  System.out.println("Retrieved '" + book.getTitle() + '\'');
		}		
	}
}
