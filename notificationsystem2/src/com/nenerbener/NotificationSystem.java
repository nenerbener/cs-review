package com.nenerbener;

import java.lang.Thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.Random;

public class NotificationSystem {

	public static void main(String[] args) throws InterruptedException {

		BlockingQueue<Message> messageQueue = new LinkedBlockingQueue<>();
//		BlockingQueue<Message> messageQueue = new ArrayBlockingQueue<>(1024);

		Runnable feeder = new FeederThread(messageQueue);
		Runnable notify = new NotifyThread(messageQueue);
		Thread f = new Thread(feeder);
		f.start();
		Thread.sleep(1000); //this requires catching or throwing InterruptedExceptionmillis
		Thread n = new Thread(notify);
		n.start();
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
		return "recipient: " + recipient + " message: " + message;
	}
	
}

class FeederThread implements Runnable {
	BlockingQueue<Message> messageQueue;
	Message messageToAdd;
	Random r = new Random();

	FeederThread(BlockingQueue<Message> messageQueue) {
		this.messageQueue = messageQueue;
	}
	public void run() {
		while (true) {
			queueMessages();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	// get message into blocking queue from source
	void queueMessages() {
		for (int irec=0; irec<5; irec++) {
			messageToAdd = new Message(Integer.toString(irec),Integer.toString(r.nextInt()));
			try {
				messageQueue.put(messageToAdd);
				System.out.println("added: " + messageToAdd);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
			
	}
}

class NotifyThread implements Runnable {
	BlockingQueue<Message> messageQueue;
	NotifyThread(BlockingQueue<Message> messageQueue) {
		this.messageQueue = messageQueue;
	}
	public void run() {
		sendMessages();
	}
	
	void sendMessages()	 {
		while (true) {
			try {
				System.out.println("write: " + messageQueue.take());
//				System.out.println("write: " + messageQueue.poll());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
