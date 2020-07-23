package mangal10n.browser;

import java.io.Closeable;
import java.io.InputStream;

public interface Response extends Closeable {

	int code();

	Body body();

	interface Body {

		String string();

		byte[] bytes();

		InputStream byteStream();
	}
}
