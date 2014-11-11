package gr.spinellis.ckjm;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

import org.apache.bcel.classfile.ClassParser;
import org.apache.bcel.classfile.JavaClass;

public class Main {
	public static void main(String[] args) throws IOException {

		final File path = new File(args[0]);
		final String basePkg = args[1];

		ClassPathHacker.addFile(path);

		ClassMetricsContainer cm = new ClassMetricsContainer();

		for (File file : path.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File arg0, String arg1) {
				return arg1.equals(basePkg);
			}
		})) {
			processFile(cm, file);
		}

		CkjmOutputHandler handler = new PrintPlainResults(System.out);
		cm.printMetrics(handler);
	}

	private static void processFile(ClassMetricsContainer cm, File file) {
		if (file.isDirectory()) {
			for (File f : file.listFiles()) {
				processFile(cm, f);
			}
		} else {
			if (file.getName().endsWith(".class")) {
				processClass(cm, file.getAbsolutePath());
			}
		}
	}

	static void processClass(ClassMetricsContainer cm, String clspec) {
		int spc;
		JavaClass jc = null;

		if ((spc = clspec.indexOf(' ')) != -1) {
			String jar = clspec.substring(0, spc);
			clspec = clspec.substring(spc + 1);
			try {
				jc = new ClassParser(jar, clspec).parse();
			} catch (IOException e) {
				System.err.println("Error loading " + clspec + " from " + jar
						+ ": " + e);
			}
		} else {
			try {
				jc = new ClassParser(clspec).parse();
			} catch (IOException e) {
				System.err.println("Error loading " + clspec + ": " + e);
			}
		}
		if (jc != null) {
			ClassVisitor visitor = new ClassVisitor(jc, cm);
			visitor.start();
			visitor.end();
		}
	}
}
