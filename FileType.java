import java.util.regex.Pattern;

public enum FileType {
    AUDIO("(.*).(mp3|MP3|wav|WAV|wma|WMA|ogg|OGG|midi|MIDI)"),
    VIDEO("(.*).(mp4|MP4|mkv|MKV|avi|AVI|flv|FLV|wmv|WMV|mov|MOV|ts|TS)"),
    DOCUMENT("(.*).(pdf|PDF|doc|DOC|docx|DOCX|txt|TXT|csv|CSV)"),
    COMPRESSED_FILE("(.*).(zip|ZIP|7z|7Z|rar|RAR|tar)");

    private final Pattern fileTypePattern;

    private FileType(String fileTypePattern) {
        this.fileTypePattern = Pattern.compile(fileTypePattern);
    }

    public Pattern getPattern() {
        return fileTypePattern;
    }
}
