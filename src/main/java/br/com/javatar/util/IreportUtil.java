package br.com.javatar.util;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.base.JRBasePropertyExpression;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;

public class IreportUtil {

    public static byte[] printReport(String fileName, List<?> beans, String name) throws JRException {

        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(IreportUtil.class.getResourceAsStream(fileName));
        
        JRField jrField = Lists.newArrayList(jasperReport.getFields()).stream().filter( f -> f.getName().equals(name)).findFirst().get();

        Map<String, Object> parameters = new HashMap<>();

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(beans);

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        return JasperExportManager.exportReportToPdf(jasperPrint);
    }
}
