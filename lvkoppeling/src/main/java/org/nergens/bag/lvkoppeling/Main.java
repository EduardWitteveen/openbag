package org.nergens.bag.lvkoppeling;



public class Main {
	public static void main(String[] args) throws Exception {
              // test for JSSE
              try {
                  Class.forName("com.sun.net.ssl.internal.ssl.Provider");
              }catch(Exception e) {
                  System.out.println("JSSE is NOT installed correctly!");
                  System.exit(1);
              }
              // Enabel SSL via JSSE
              System.getProperty("user.dir");              
              System.setProperty("javax.net.ssl.trustStore",  "path to client trust store");
              System.setProperty("javax.net.ssl.trustStorePassword","your password");
                
            // create the client stub
            org.apache.axis2.engine.AxisConfiguration config = new org.apache.axis2.engine.AxisConfiguration();
            org.apache.axis2.context.ConfigurationContext contex = new org.apache.axis2.context.ConfigurationContext(config);
            //String target = "http://localhost:8080/bag-web/services/BagWebService";
            String target = "https://conformiteit.baglv.nl/";
            nl.vrom.www.bag.stuf._0120.STUFBAGSynchroonStub stub = new nl.vrom.www.bag.stuf._0120.STUFBAGSynchroonStub(contex, target);				        
            // do something
/*		stub.beantwoordVraag(vraagBericht3);
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
 */
	}
}
