package com.nenerbener;

import java.lang.Thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.Random;

public class NotificationSystem {

	public static void main(String[] args) throws InterruptedException {

		//BlockingQueue<Message> messageQueue = new LinkedBlockingQueue<>();
		BlockingQueue<Message> messageQueue = new ArrayBlockingQueue<>(1024);
		//when using put and take methods for BlockingQueue do not test for empty queue. The checking is done during the put and take method

		//create feed and notify threads and start
		Runnable feeder = new FeederThread(messageQueue);
		Runnable notify = new NotifyThread(messageQueue);
		Thread f = new Thread(feeder);
		Thread n = new Thread(notify);
//		f.setDaemon(true); //setting daemon=true means don't wait for thread to finish
//		n.setDaemon(true);
		f.start();
		n.start();
//		f.join(); //calling join means for this thread to wait for the threa that called join to finish before proceeding
//		n.join();
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
