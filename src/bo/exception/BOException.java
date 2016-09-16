package bo.exception;

import java.sql.SQLException;

public class BOException extends Exception {

	private static final long serialVersionUID = 1L;

	public BOException(SQLException e) {
		super(e);
		
		System.out.print("Ubacena linija koda u lokalnom repou, pa pushovana na server");
	}

	
}
