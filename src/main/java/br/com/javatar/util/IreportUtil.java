package br.com.javatar.util;

import com.google.common.collect.Lists;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

import java.util.HashMap;
import java.util.Map;

public class IreportUtil {

    public static byte[] printReport(String fileName) throws JRException {

        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(IreportUtil.class.getResourceAsStream(fileName));

        Map<String, Object> parameters = new HashMap<>();

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(Lists.newArrayList());

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        return JasperExportManager.exportReportToPdf(jasperPrint);
    }
}
