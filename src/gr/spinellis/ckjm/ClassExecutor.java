package gr.spinellis.ckjm;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import org.apache.bcel.classfile.ClassParser;
import org.apache.bcel.classfile.JavaClass;

public class ClassExecutor {

	public void execute(String classpaths, String[] basePkgs, String outputDir) throws IOException {

		String[] paths = classpaths.split(";");

		for (String p : paths)
			ClassPathHacker.addFile(p);

		ClassMetricsContainer cm = new ClassMetricsContainer();

		System.out.println("Processando classes e gerando métricas...");

		for (String path : paths) {
			try {
				File fPath = new File(path);
				System.out.println(path + " " + fPath.exists());
				for (File file : fPath.listFiles()) {
					processFile(cm, file, basePkgs);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		System.out.println("Escrevendo arquivo de saida por classes...");
		PrintStream ps = new PrintStream(new File(outputDir, "ckjm-results.csv"));

		CkjmOutputHandler handler = new PrintPlainResults(ps);

		cm.printMetrics(handler);

		System.out.println("Escrevendo arquivo de saida por pacotes...");
		ps = new PrintStream(new File(outputDir, "ckjm-results-pkg.csv"));

		handler = new PrintPlainResults(ps);

		cm.printMetricsByPkg(handler);

		System.out.println("Escrevendo arquivo de saida classes not Found...");
		ps = new PrintStream(new File(outputDir, "ckjm-results-classes-not-found.csv"));

		handler = new PrintPlainResults(ps);

		cm.printClassNotFound(handler);

		System.out.println("Concluido.");
	}

	private static void processFile(ClassMetricsContainer cm, File file, String[] basePkgs) {
		if (file.isDirectory()) {
			for (File f : file.listFiles()) {
				processFile(cm, f, basePkgs);
			}
		} else {
			if (file.getName().endsWith(".class")) {
				System.out.println(file);
				processClass(cm, file.getAbsolutePath(), basePkgs);
			}
		}
	}

	static void processClass(ClassMetricsContainer cm, String clspec, String[] basePkgs) {
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
