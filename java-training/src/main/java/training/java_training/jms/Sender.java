package training.java_training.jms;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.QueueConnectionFactory;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;

import training.java_training.util.ProjectUtils;

public class Sender {

	public static void main(String[] args) throws Exception {
		try {
			InitialContext ctx=new InitialContext();  
			QueueConnectionFactory qcf = (QueueConnectionFactory) ctx.lookup("QueueConnectionFactory");
			Connection connection = qcf.createConnection();
			System.out.println("Created connection"); 
			connection.start();
			
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination destination = session.createQueue(ProjectUtils.JMS_QUEUE);
			MessageProducer messageProducer = session.createProducer(destination);
			TextMessage message = (TextMessage) session.createMessage();
			message.setText("Hello");
			messageProducer.send(message);
			System.out.println("Message successfully sent.");
			connection.close();
		} catch (Exception e) {
			throw e;
		} 
	}
	
}
