package fr.opensagres.xdocreport.eclipse.extensions.reporting;

import java.io.IOException;
import java.io.InputStream;

public interface IReportLoader {

	String getReportId();

	InputStream getSourceStream();

	IReportProcessorType getProcessorType();

	boolean canSupportFormat(IReportFormat format) throws IOException,
			ReportException;

}