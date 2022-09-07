import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class TOrganizer {

    public static void organizeDirectory(String source) throws IOException {
        File sourceDirectory = new File(source);
        for (File file : sourceDirectory.listFiles()) {
            PatternMatcher.getFileType(file)
                    .ifPresentOrElse(type -> {
                        try {
                            moveFileToDesignatedDirectory(type, file);
                        } catch (IOException e) {
                            e.printStackTrace();
                            System.out.println("Error during moving: " + file.getName());
                        }
                    }, () -> {
                        System.out.println("Unable to find out file type for : " + file.getName());
                    });
        }
    }

    private static void moveFileToDesignatedDirectory(FileType fileType, File file) throws IOException {
        File toMoveFileDirectory = new File(file.getParent() + File.separator + "TDOCUMENTS");
        toMoveFileDirectory.mkdir();
        Files.move(toMoveFileDirectory.toPath(),
                new File(toMoveFileDirectory.getParent() + File.separator + toMoveFileDirectory.getName()
                        + File.separator + file.getName()).toPath(),
                StandardCopyOption.REPLACE_EXISTING);
    }
}
