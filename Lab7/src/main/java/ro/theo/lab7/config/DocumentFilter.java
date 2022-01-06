package ro.theo.lab7.config;

import org.primefaces.shaded.commons.io.IOUtils;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Provider
public class DocumentFilter implements ClientResponseFilter {
    static String documents = null;

    public void filter(ClientRequestContext request, ClientResponseContext response) throws IOException {
        if (request.getMethod().equalsIgnoreCase("GET")) {
            try (InputStream entityStream = response.getEntityStream()) {
                if (entityStream != null) {
                    byte[] bytes = IOUtils.toByteArray(entityStream);
                    response.setEntityStream(new ByteArrayInputStream(bytes));
                    documents = new String(bytes);
                }
            }
        }

        if (response.getStatus() == 200) {
            System.out.println("In filter: status 200.");
        }

        System.out.println("In filter: " + "after  " + request.getMethod() + "\n" + documents);

    }
}