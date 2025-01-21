package nl.axians.training.datasonnet.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * Route builder to convert a JSON array with persons information to a specific JSON format using DataSonnet.
 */
@Component
public class PersonConverterRouteBuilder extends RouteBuilder {

    private static final String COUNTRIES = """
        {
            "NL": "Netherlands",
            "JM": "Jamaica",
            "": "N/A"
        }""";

    @Override
    public void configure() throws Exception {
        configureConvertRoute();
    }

    /**
     * Configures the route to convert a JSON array with persons information to a specific JSON format using
     * DataSonnet.
     */
    private void configureConvertRoute() {
        // @formatter:off
        from("direct:convert")
                // Implement your logic here!
                // HINT Use transform() and  nl.axians.camel.language.datasonnet.DatasonnetBuilderSupport#dsonnet
                // ValueBuilder to convert the input JSON array to the desired format. To load DataSonnet file from
                // classpath you can use "resource:classpath:/person-converter.ds" as the first argument of dsonnet.
        .end();
        // @formatter:on
    }

}
