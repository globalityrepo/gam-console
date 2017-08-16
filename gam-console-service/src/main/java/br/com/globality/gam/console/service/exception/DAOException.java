/**
 * 
 */
package br.com.globality.gam.console.service.exception;


/**
 * @author  Leonardo Andrade
 * @project gam-engine-listener
 * @since   09/03/2017
 */
public class DAOException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9007147107157543928L;

	public DAOException(String message, Throwable throwable) {
		super(message, throwable);
	}

}
