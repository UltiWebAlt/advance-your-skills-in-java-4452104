package com.example.ch5;

public final class DatabaseConnection {
		private static String databaseURL;
		private static DatabaseConnection instance;

		private DatabaseConnection(String databaseURL) {
			DatabaseConnection.databaseURL = databaseURL;
		}

		public static synchronized DatabaseConnection getInstance() {
			if (instance == null) {
				instance = new DatabaseConnection("jdbc:mysql://localhost:3306/mydatabase");
			}
			return instance;
		}

		// dummy implementation of executing a query
		public static void executeQuery(String query) {
			System.out.println("Executing query on " + databaseURL + ": " + query);
		}

		// dummy implementation of closing the connection
		public static void close() {
			System.out.println("Closing connection with: " + databaseURL);
		}
}
