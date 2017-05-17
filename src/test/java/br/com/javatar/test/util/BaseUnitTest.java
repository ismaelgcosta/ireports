package br.com.javatar.test.util;

import java.util.List;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.ObjectFactory;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import static br.com.six2six.fixturefactory.loader.FixtureFactoryLoader.loadTemplates;

public abstract class BaseUnitTest {

    public  final String LABEL_VALIDO = "valido";
    public  final static String BASE_PACKAGE_TEMPLATE_FIXTURE_FACTORY = "br.com.javatar";
    private boolean hasLoadTemplateFixtureFactory = false;

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    protected void exceptionTest(Class<? extends Throwable> exception, String message) {
        expectedEx.expect(exception);
        expectedEx.expectMessage(message);
    }

    public  <T> T getFixture(Class<T> clazz) {
        return getFixture(LABEL_VALIDO, clazz);
    }

    public  <T> T getFixture(Class<T> clazz, String label) {
        return getFixture(label, clazz);
    }

    public  <T> T getFixture(String label, Class<T> clazz) {
        return getFixture(0, label, clazz).get(0);
    }

    public  <T> T getFixture(Class<T> clazz, String label, br.com.six2six.fixturefactory.Rule rule) {
        return getFixture(0, label, clazz, rule).get(0);
    }

    public  <T> List<T>  getFixture(Class<T> clazz, int size, String label) {
        return getFixture(size, label, clazz);
    }

    public  <T> List<T> getFixture(int size, String label, Class<T> clazz) {
        return getFixture(size, label, clazz, null);
    }
    public  <T> List<T>  getFixture(int size, String label, Class<T> clazz, br.com.six2six.fixturefactory.Rule rule) {
        if (!hasLoadTemplateFixtureFactory){
            loadTemplates(BASE_PACKAGE_TEMPLATE_FIXTURE_FACTORY);
            hasLoadTemplateFixtureFactory = true;
        }

        final ObjectFactory factory = Fixture.from(clazz);

        if (size == 0){
            size = 1;
        }
        return (rule != null) ? factory.gimme(size, label, rule) : factory.gimme(size, label);
    }

}