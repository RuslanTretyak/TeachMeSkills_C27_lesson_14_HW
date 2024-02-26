package exception;

public class EmptyFileException extends Exception{
    public EmptyFileException() {
        super("обрабатываемый файл пуст");
    }
}
