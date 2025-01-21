package nl.axians.training.datasonnet.controller;

import jakarta.annotation.Nonnull;
import org.apache.camel.ProducerTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/converter")
public class ConverterController {

    private final ProducerTemplate template;

    /**
     * Constructor to create a new instance of the {@link ConverterController}.
     *
     * @param theTemplate The Camel {@link ProducerTemplate} to use.
     */
    public ConverterController(@Nonnull final ProducerTemplate theTemplate) {
        template = theTemplate;
    }

    /**
     * This method is responsible for converting a JSON array with persons information to a specific JSON format using
     * DataSonnet.
     *
     * @param theInput The JSON array with persons information.
     * @return The converted JSON array.
     */
    @GetMapping(path = "/persons", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> convert(@RequestBody String theInput) {
        String result = template.requestBody("direct:convert", theInput, String.class);
        return ResponseEntity.ok(result);
    }

}
