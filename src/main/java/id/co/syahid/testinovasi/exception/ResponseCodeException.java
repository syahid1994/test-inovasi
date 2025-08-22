package id.co.syahid.testinovasi.exception;

public class ResponseCodeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String code;

	public ResponseCodeException(String message, String code) {
		super(message);
		this.code = code;
	}
	
	public String getCode() {
		return this.code;
	}
}
