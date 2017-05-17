package br.com.javatar.test;

import br.com.javatar.to.ExampleTO;
import br.com.javatar.test.fixture.ExampleTOFixture;
import br.com.javatar.test.util.BaseUnitTest;
import br.com.javatar.util.IreportUtil;
import br.com.six2six.fixturefactory.Fixture;
import net.sf.jasperreports.engine.JRAbstractScriptlet;
import net.sf.jasperreports.engine.JRException;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;

import static br.com.six2six.fixturefactory.loader.FixtureFactoryLoader.loadTemplates;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

public class ReportTest extends BaseUnitTest {
	
	static {
		loadTemplates(BASE_PACKAGE_TEMPLATE_FIXTURE_FACTORY);
	}

    @Test
    public void deveGerarORelatorio() throws JRException, IOException {

        byte[] report = IreportUtil.printReport("relatorio.jasper", fixtures(), "municipio");

        File tempFile = new File("C:/Users/JAVA/Documents/relatorio.pdf");
        
        if(!tempFile.exists()){
        	tempFile.createNewFile();
        }
        
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat(new SimpleDateFormat("dd/MM/yyyy"));
        System.out.println(mapper.writeValueAsString(fixtures()));

        FileUtils.writeByteArrayToFile(tempFile, report);
    }
    
    public static List<?> fixtures() {
    	loadTemplates(BASE_PACKAGE_TEMPLATE_FIXTURE_FACTORY);
    	return Fixture.from(ExampleTO.class).gimme(100, ExampleTOFixture.VALIDO);
	}

}