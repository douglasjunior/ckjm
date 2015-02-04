package gr.spinellis.ckjm;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

import org.apache.bcel.classfile.ClassParser;
import org.apache.bcel.classfile.JavaClass;

public class JarExecutor {

	private ClassMetricsContainer cm = new ClassMetricsContainer();

	// private static String[] basePkgs = { "org.apache.hadoop" };

	private List<File> jars = new ArrayList<>();

	public void execute(String classpath, String[] basePkgs, String outputDir) throws IOException {
		// TODO Auto-generated method stub

		System.out.println("Buscando Jars...");
		searchJarDir(new File(classpath));

		System.out.println("Calculando métricas...");
		executeMetrics(basePkgs);

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

	private void executeMetrics(String[] basePkgs) throws ZipException, IOException {
		for (File jarFile : jars) {
			ZipFile zipFile = new ZipFile(jarFile);
			Enumeration<? extends ZipEntry> zipEntries = zipFile.entries();
			while (zipEntries.hasMoreElements()) {
				ZipEntry entry = zipEntries.nextElement();
				String name = entry.getName();
				// Process the name, here we just print it out
				System.out.println(name);
				if (name.endsWith(".class")) {
					String[] splitName = name.split("/");
					processClass(cm, zipFile.getInputStream(entry), splitName[splitName.length - 1], basePkgs);
				}
			}
		}
	}

	private FileFilter fileFilter = new FileFilter() {
		@Override
		public boolean accept(File f) {
			if (f.isDirectory())
				return true;
			String name = f.getName().toLowerCase();
			if (name.endsWith(".jar") || name.endsWith(".zip"))
				return true;
			return false;
		}
	};

	private void searchJarDir(File jarDir) throws IOException {
		File[] fileArray = jarDir.listFiles(fileFilter);
		if (fileArray != null && fileArray.length > 0) {
			for (File sub : fileArray) {
				if (sub.isDirectory()) {
					searchJarDir(sub);
				} else {
					searchJarFile(sub);
				}
			}
		}
		return;
	}

	private void searchJarFile(File jarFile) throws IOException {
		ClassPathHacker.addFile(jarFile);
		jars.add(jarFile);
	}

	private static void processClass(ClassMetricsContainer cm, InputStream is, String clspec, String[] basePkgs) {
		int spc;
		JavaClass jc = null;

		try {
			jc = new ClassParser(is, clspec).parse();
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
