package br.com.javatar.test.fixture;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.javatar.to.ExampleTO;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.TemplateHolder;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import org.apache.commons.lang.time.DateUtils;

public class ExampleTOFixture implements TemplateLoader {

    public static final String VALIDO = "valido";

    private TemplateHolder loader;

    @Override
    public void load() {
        loader = Fixture.of(ExampleTO.class);
        loadValido();
    }

    private void loadValido() {
        loader.addTemplate(VALIDO, new Rule() {{
            add("numeroOrdem", sequence(Long.class));
            add("numeroRegistro", random(Long.class));
            add("valor", random(BigDecimal.class));
            add("dataEmissao", randomDate("01/01/2015", "31/01/2015", new SimpleDateFormat("dd/MM/yyyy")));
            add("dataVencimento", randomDate("01/02/2015", "28/02/2015", new SimpleDateFormat("dd/MM/yyyy")));
            add("dataQuitacao", random(DateUtils.addDays(new Date(), 2), null));
            add("nomeFavorecido", name());
            add("bancoKey", random(Integer.class, range(1,999)));
            add("bancoDescricao", name());
            add("cancelada", random(Boolean.class));
            add("uf", regex("\\w{2}"));
            add("enderecoLogradouro", regex("\\w{20} \\w{20} \\w{10} \\w{20} \\w{30} \\w{20} \\w{20} \\w{20}"));
            add("enderecoNumero", regex("\\d{3}"));
            add("municipio", regex("\\w{8}"));
        }});
    }
}