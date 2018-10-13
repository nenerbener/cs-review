package com.nenerbener;

import java.util.Queue;
import java.util.LinkedList;
import java.lang.Thread;

public class NotificationSystem {

	public static void main(String[] args) throws InterruptedException {

		Queue<Message> messageQueue = new LinkedList<>();
		messageQueue.add(new Message("bill","message to bill"));
		messageQueue.add(new Message("karen","message to karen"));
		messageQueue.add(new Message("harry","message to harry"));
		
		Runnable nr = new NotificationThread(messageQueue);
		Thread nt = new Thread(nr);
		nt.setDaemon(true);
		nt.start();
		Thread.sleep(3000);
	}

}

// basic message
class Message {
	String recipient;
	String message;
	
	Message(String recipient, String message) {
		this.recipient = recipient;
		this.message = message;
	}

	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String toString() {
		return "recipient: " + recipient + "message" + message;
	}
	
}

class NotificationThread implements Runnable {
	Queue<Message> messageQueue;
	NotificationThread(Queue<Message> messageQueue) {
		this.messageQueue = messageQueue;
	}
	public void run() {

		while(true) {
			Message msg = getMessageFromQueue();
			if (msg!=null) sendMessage (msg);
		}
	}
	
	Message getMessageFromQueue()	 {
		if ((messageQueue != null)&&(!messageQueue.isEmpty())) {
			return messageQueue.remove();
		}
		else return null;
	}

	void sendMessage(Message message)	 {
		System.out.println("Message sent: " + message);
	}
}
