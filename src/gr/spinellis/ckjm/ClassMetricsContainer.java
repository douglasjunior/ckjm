/*
 * $Id: \\dds\\src\\Research\\ckjm.RCS\\src\\gr\\spinellis\\ckjm\\ClassMetricsContainer.java,v 1.9 2005/08/10 16:53:36
 * dds Exp $
 * 
 * (C) Copyright 2005 Diomidis Spinellis
 * 
 * Permission to use, copy, and distribute this software and its documentation for any purpose and without fee is hereby
 * granted, provided that the above copyright notice appear in all copies and that both that copyright notice and this
 * permission notice appear in supporting documentation.
 * 
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND WITHOUT ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, WITHOUT LIMITATION, THE
 * IMPLIED WARRANTIES OF MERCHANTIBILITY AND FITNESS FOR A PARTICULAR PURPOSE.
 */

package gr.spinellis.ckjm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.bcel.classfile.JavaClass;

/**
 * A container of class metrics mapping class names to their metrics. This class contains the the metrics for all
 * class's during the filter's operation. Some metrics need to be updated as the program processes other classes, so the
 * class's metrics will be recovered from this container to be updated.
 *
 * @version $Revision: 1.9 $
 * @author <a href="http://www.spinellis.gr">Diomidis Spinellis</a>
 */
class ClassMetricsContainer {

	/** The map from class names to the corresponding metrics */
	private HashMap<String, ClassMetrics> m = new HashMap<String, ClassMetrics>();

	/** Return a class's metrics */
	public ClassMetrics getMetrics(JavaClass jc) {
		ClassMetrics cm = m.get(jc.getClassName());
		if (cm == null) {
			cm = new ClassMetrics();
			cm.setPkage(jc.getPackageName());
			m.put(jc.getClassName(), cm);
		}
		return cm;
	}

	/** Print the metrics of all the visited classes. */
	public void printMetrics(CkjmOutputHandler handler) {
		handler.handleLine("pkg;class;WMC;DIT;NOC;CBO;RFC;LCOM;Ca;NPM");
		Set<Map.Entry<String, ClassMetrics>> entries = m.entrySet();
		Iterator<Map.Entry<String, ClassMetrics>> i;

		for (i = entries.iterator(); i.hasNext();) {
			Map.Entry<String, ClassMetrics> e = i.next();
			ClassMetrics cm = e.getValue();
			if (cm.isVisited() && (MetricsFilter.includeAll() || cm.isPublic()))
				handler.handleClass(e.getKey(), cm);
		}
	}

	// WMC DIT NOC CBO RFC LCOM Ce NPM

	/** Print the metrics of all the visited classes. */
	public void printMetricsByPkg(CkjmOutputHandler handler) {
		handler.handleLine("pkg;WMC;DIT;NOC;CBO;RFC;LCOM;Ca;NPM");
		Map<String, List<Double>> pkgMetricsWMC = new HashMap<String, List<Double>>();
		Map<String, List<Double>> pkgMetricsDIT = new HashMap<String, List<Double>>();
		Map<String, List<Double>> pkgMetricsNOC = new HashMap<String, List<Double>>();
		Map<String, List<Double>> pkgMetricsCBO = new HashMap<String, List<Double>>();
		Map<String, List<Double>> pkgMetricsRFC = new HashMap<String, List<Double>>();
		Map<String, List<Double>> pkgMetricsLCOM = new HashMap<String, List<Double>>();
		Map<String, List<Double>> pkgMetricsCA = new HashMap<String, List<Double>>();
		Map<String, List<Double>> pkgMetricsNPM = new HashMap<String, List<Double>>();

		Set<Map.Entry<String, ClassMetrics>> entries = m.entrySet();

		for (Iterator<Map.Entry<String, ClassMetrics>> i = entries.iterator(); i.hasNext();) {
			ClassMetrics cm = i.next().getValue();

			addMetricToMap(pkgMetricsWMC, cm.getWmc(), cm.getPkage());
			addMetricToMap(pkgMetricsDIT, cm.getDit(), cm.getPkage());
			addMetricToMap(pkgMetricsNOC, cm.getNoc(), cm.getPkage());
			addMetricToMap(pkgMetricsCBO, cm.getCbo(), cm.getPkage());
			addMetricToMap(pkgMetricsRFC, cm.getRfc(), cm.getPkage());
			addMetricToMap(pkgMetricsLCOM, cm.getLcom(), cm.getPkage());
			addMetricToMap(pkgMetricsCA, cm.getCa(), cm.getPkage());
			addMetricToMap(pkgMetricsNPM, cm.getNpm(), cm.getPkage());
		}

		Double wmc, dit, noc, cbo, rfc, lcom, ca, npm;

		Set<String> pkgs = pkgMetricsWMC.keySet();
		for (String pkg : pkgs) {
			List<Double> values = pkgMetricsWMC.get(pkg);
			Collections.sort(values);
			wmc = median(values);
			values = pkgMetricsDIT.get(pkg);
			Collections.sort(values);
			dit = median(values);
			values = pkgMetricsNOC.get(pkg);
			noc = sum(values);
			values = pkgMetricsCBO.get(pkg);
			Collections.sort(values);
			cbo = median(values);
			values = pkgMetricsRFC.get(pkg);
			Collections.sort(values);
			rfc = median(values);
			values = pkgMetricsLCOM.get(pkg);
			Collections.sort(values);
			lcom = median(values);
			values = pkgMetricsCA.get(pkg);
			Collections.sort(values);
			ca = median(values);
			values = pkgMetricsNPM.get(pkg);
			Collections.sort(values);
			npm = median(values);
			handler.handleLine(pkg + ";" + wmc + ";" + dit + ";" + noc + ";" + cbo + ";" + rfc + ";" + lcom + ";" + ca + ";" + npm);
		}
	}

	private void addMetricToMap(Map<String, List<Double>> pkgMetrics, int value, String pkg) {
		List<Double> values = pkgMetrics.get(pkg);
		if (values == null) {
			values = new ArrayList<Double>();
			pkgMetrics.put(pkg, values);
		}
		values.add((double) value);
	}

	public static double median(List<Double> m) {
		if (m.size() == 1)
			return m.get(0);
		int middle = m.size() / 2;
		if (m.size() % 2 == 1) {
			return m.get(middle);
		} else {
			return (m.get(middle - 1) + m.get(middle)) / 2.0;
		}
	}

	public static double avarege(List<Double> m) {
		return sum(m) / (double) m.size();
	}

	public static double sum(List<Double> m) {
		double sum = 0;
		for (Double d : m) {
			sum += d;
		}
		return sum;
	}
}
