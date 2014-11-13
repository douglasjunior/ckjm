package gr.spinellis.ckjm;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

import org.apache.bcel.classfile.ClassParser;
import org.apache.bcel.classfile.JavaClass;

public class Main {

	private static File path;
	private static String[] basePkgs;

	public static void main(String[] args) throws IOException {
		args = new String[] {
				"C:/workspace/osmand/OsmAnd/bin/classes;"
						+ "C:/workspace/osmand/OsmAnd-java/bin;"
						+ "C:/workspace/osmand/plugins/OsmAnd-AddressPlugin/bin/classes;"
						+ "C:/workspace/osmand/plugins/OsmAnd-ParkingPlugin/bin/classes;"
						+ "C:/workspace/osmand/plugins/OsmAnd-SRTMPlugin/bin/classes;"
						+ "C:/workspace/osmand/SherlockBar/bin/classes",
				"net.osmand" };
		String[] paths = args[0].split(";");

		path = new File(paths[0]);
		basePkgs = args[1].split(";");

		for (String p : paths)
			ClassPathHacker.addFile(p);

		ClassMetricsContainer cm = new ClassMetricsContainer();
		
		System.out.println("Processando classes e gerando métricas...");
		for (File file : path.listFiles()) {
			processFile(cm, file);
		}

		System.out.println("Escrevendo arquivo de saida por classes...");
		PrintStream ps = new PrintStream(new File("c:/temp/ckjm-results.csv"));

		CkjmOutputHandler handler = new PrintPlainResults(ps);

		cm.printMetrics(handler);

		System.out.println("Escrevendo arquivo de saida por pacotes...");
		ps = new PrintStream(new File("c:/temp/ckjm-results-pkg.csv"));

		handler = new PrintPlainResults(ps);

		cm.printMetricsByPkg(handler);
		
		System.out.println("Concluido.");
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

		try {
			jc = new ClassParser(clspec).parse();
		} catch (IOException e) {
			System.err.println("Error loading " + clspec + ": " + e);
		}

		if (jc != null) {
			boolean contains = false;
			for (String pkg : basePkgs) {
				if (jc.getPackageName().startsWith(pkg)) {
					contains = true;
					break;
				}
			}
			if (contains) {
				ClassVisitor visitor = new ClassVisitor(jc, cm);
				visitor.start();
				visitor.end();
			}
		}
	}
}
