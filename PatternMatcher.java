import java.io.File;
import java.util.Optional;

class PatternMatcher {

	public static Optional<FileType> getFileType(File file) {
		for (FileType fileType : FileType.values()) {
			if (fileType.getPattern().matcher(file.getName()).find()) {
				return Optional.of(fileType);
			}
		}
		return Optional.empty();
	}
}