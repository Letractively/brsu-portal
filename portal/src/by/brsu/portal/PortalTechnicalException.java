/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal;

import java.sql.SQLException;

/**
 * @author Roman Ulezlo
 * 
 */
public class PortalTechnicalException extends SQLException {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public PortalTechnicalException() {
		super();
	}

	/**
	 * @param exMessage
	 */
	public PortalTechnicalException(String exMessage) {
		super(exMessage);
	}

	/**
	 * @param cause
	 */
	public PortalTechnicalException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public PortalTechnicalException(String message, Throwable cause) {
		super(message, cause);
	}
}
