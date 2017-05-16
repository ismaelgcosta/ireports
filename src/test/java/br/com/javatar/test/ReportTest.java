package br.com.javatar.test;

import br.com.javatar.test.util.BaseUnitTest;
import br.com.javatar.util.IreportUtil;
import net.sf.jasperreports.engine.JRException;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class ReportTest extends BaseUnitTest {

    @Test
    public void deveGerarORelatorio() throws JRException, IOException {

        byte[] report = IreportUtil.printReport("relatorio.jasper");

        File tempFile = File.createTempFile("relatorio", ".pdf");

        FileUtils.writeByteArrayToFile(tempFile, report);
    }

}