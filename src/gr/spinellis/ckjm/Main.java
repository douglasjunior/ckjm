package gr.spinellis.ckjm;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		try {
			String type = getParam(args, "-type", "class");
			String classPath = getParam(args, "-classpath", null);
			String basePkg = getParam(args, "-basePkg", null);
			String outputDir = getParam(args, "-outputDir", ".");

			String[] basePkgs = basePkg.split(";");

			if (type.equalsIgnoreCase("jar")) {
				new JarExecutor().execute(classPath, basePkgs, outputDir);
			} else {
				new ClassExecutor().execute(classPath, basePkgs, outputDir);
			}
		} catch (Exception ex) {
			System.err.println("Error: " + ex);
			System.err.println("Usage:");
			System.err.println("C:\\Temp>java -jar ckjm.jar -classpath c:\\Temp\\hadoop-0.23.10 -basepkg org.apache.hadoop -outputdir c:\\Temp -type jar");
		}
	}

	private static String getParam(String[] args, String string, String defaultValue) {
		for (int i = 0; i < args.length; i++) {
			String s = args[i].trim();
			if (string.equalsIgnoreCase(s)) {
				return args[i + 1];
			}
		}
		return defaultValue;
	}
}
