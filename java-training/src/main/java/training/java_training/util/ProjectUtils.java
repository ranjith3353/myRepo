package training.java_training.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;

import org.apache.commons.io.IOUtils;

public class ProjectUtils {
	
	public final static String JMS_QUEUE = "COM.JAVA_TRAINING.JMS.QUEUE";
	
	public final static String SENDER_QUEUE = "COM.JAVA_TRAINING.JMS.SENDER_QUEUE";
	
	public final static String RECEIVER_QUEUE = "COM.JAVA_TRAINING.JMS.RECEIVER_QUEUE";

	public static String getFileAsString(String messageFilePath) throws IOException {
		return IOUtils.toString(ClassLoader.getSystemResourceAsStream(messageFilePath));
	}
	
	public static String getFileAsString(File file, boolean stripEOL) throws IOException {
		StringWriter stringWriter = new StringWriter();
		BufferedWriter writer = new BufferedWriter(stringWriter);
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();

			for (String eol = eol(stripEOL); line != null; line = reader.readLine()) {
				writer.write(line);
				writer.write(eol);
			}
		} finally {
			closeResources(writer, reader);
		}

		return stringWriter.toString();
	}
	
	private static void closeResources(BufferedWriter writer, BufferedReader reader) {
		try {
			writer.close();
		} catch (IOException var4) {
			;
		}

		if (reader != null) {
			try {
				reader.close();
			} catch (IOException var3) {
				;
			}
		}

	}
	
	private static String eol(boolean stripEOL) {
		return stripEOL ? "" : System.getProperty("line.separator", "\n");
	}
}
