package com.jaspersoft.jasperserver.jaxrs.client.apiadapters.diagnostic;

import com.jaspersoft.jasperserver.dto.logcapture.CollectorSettingsList;
import com.jaspersoft.jasperserver.jaxrs.client.apiadapters.AbstractAdapter;
import com.jaspersoft.jasperserver.jaxrs.client.core.JerseyRequest;
import com.jaspersoft.jasperserver.jaxrs.client.core.SessionStorage;
import com.jaspersoft.jasperserver.jaxrs.client.core.exceptions.handling.DefaultErrorHandler;
import com.jaspersoft.jasperserver.jaxrs.client.core.operationresult.OperationResult;
import java.io.InputStream;

/**
 * <p/>
 * <p/>
 *
 * @author tetiana.iefimenko
 * @version $Id$
 * @see
 */
public class BatchDiagnosticCollectorsAdapter extends AbstractAdapter {
    public BatchDiagnosticCollectorsAdapter(SessionStorage sessionStorage) {
        super(sessionStorage);
    }

    public OperationResult<CollectorSettingsList> collectorsMetadata() {
        return JerseyRequest.buildRequest(sessionStorage,
                CollectorSettingsList.class,
                new String[]{"/collectors"},
                new DefaultErrorHandler())
                .get();
    }

    public OperationResult<InputStream> collectorsContent() {
        JerseyRequest<InputStream> request = JerseyRequest.buildRequest(sessionStorage,
                InputStream.class,
                new String[]{"/collectors", "content"},
                new DefaultErrorHandler());
        request.setAccept("application/zip");
        return request.get();
    }
}
