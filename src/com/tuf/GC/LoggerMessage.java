package com.tuf.GC;

import java.util.HashMap;

public class LoggerMessage {

	/*
	 * Why Not Use 0 Instead of -100?
Using 0 as the default value might cause issues if the first log is near the beginning of time:

If timestamp = 8, then:

java
Copy
Edit
if (8 - 0 < 10) // if (8 < 10) -> true
This would incorrectly block the first message.

By using -100, we ensure that any first occurrence of a message will always be logged.
	 */
	class Logger {
	    HashMap<String, Integer> lastTime;
	    public Logger() {
	        lastTime = new HashMap<>();
	    }
	    public boolean shouldPrintMessage(int timestamp, String message) {
	        if (timestamp - lastTime.getOrDefault(message, -100) < 10)
	            return false;
	        lastTime.put(message, timestamp);
	        return true;
	    }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
