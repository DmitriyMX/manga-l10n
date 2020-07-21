package mangal10n.textrecognition.easyscreen;

import mangal10n.textrecognition.OCRService;
import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class EasyScreenOCRTest {

	private OCRService ocr;

	@Before
	public void setUp() {
		ocr = new EasyScreenOCR();
	}

	@Test
	public void testSimpleText() throws IOException {
		final String expectedValue = IOUtils.resourceToString("/simple_text.txt", StandardCharsets.UTF_8)
				.replaceAll("\r\n", "\n");

		byte[] imageBytes = IOUtils.resourceToByteArray("/simple_text.jpg");
		assertNotNull(imageBytes);

		String recognition = ocr.doRecognition(imageBytes);
		assertNotNull(recognition);
		assertEquals(expectedValue, recognition.replaceAll("\r\n", "\n"));
	}
}