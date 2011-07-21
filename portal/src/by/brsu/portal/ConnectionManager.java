/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Roman Ulezlo
 * 
 */

public class ConnectionManager {
	private static final ConnectionManager INCTANCE = new ConnectionManager();
	final private int poolsize = 10;
	private Connection[] connections = new Connection[poolsize];
	private byte connected = 0;
	private ConnectionManager cm;

	private ConnectionManager() {
		for (int i = 0; i < poolsize; i++) {
			try {
				connections[i] = DriverManager.getConnection(
						"jdbc:mysql://localhost/portal", "brsujgadmin", "1");
			} catch (SQLException ex) {
			}
		}
	}

	/**
	 * 
	 * @return
	 */
	public static ConnectionManager getConnectorManager() {
		return INCTANCE;
	}

	/**
	 * 
	 * @return connetions pool
	 */
	public synchronized ConnectionManager getConnectionPool() {
		ConnectionManager conm;
		conm = (cm == null ? new ConnectionManager() : cm);
		cm = conm;
		return cm;
	}

	/**
	 * 
	 * @return one connection
	 */
	public synchronized Connection getConnection() {
		Connection conn = null;
		while (connected == poolsize) {
			try {
				wait();
			} catch (Exception e) {
			}
		}
		connected++;
		for (int i = 0; i < poolsize; i++) {
			if (connections[i] != null) {
				conn = connections[i];
				connections[i] = null;
				break;
			}
		}
		notify();
		return conn;
	}

	/**
	 * Delete one connection
	 * 
	 * @param conn
	 * @throws SQLException
	 */
	public synchronized void releaseConnaction(Connection conn)
			throws SQLException {
		connected--;
		conn.rollback();
		for (int i = 0; i < poolsize; i++) {
			if (connections[i] == null) {
				connections[i] = conn;
				break;
			}
		}
		notify();
	}

	/**
	 * Delete all connections
	 */
	public synchronized void closeAllConnections() {
		for (int i = 0; i < poolsize; i++) {
			try {
				connections[i].rollback();
				connections[i].close();
			} catch (SQLException e) {
			}
		}
	}
}
