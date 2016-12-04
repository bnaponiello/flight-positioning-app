package br.com.bnaponiello.flight.positioning.util;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import org.junit.BeforeClass;

/**
 * The base test fixture.
 *
 * @author Bruno Naponiello
 * @since 02/12/2016
 */
public class BaseTestFixture {

    private static String TEMPLATES_PATH = "br.com.bnaponiello.flight.positioning.template";

    @BeforeClass
    public static void beforeTestClass() {
        FixtureFactoryLoader.loadTemplates(TEMPLATES_PATH);
    }

}
