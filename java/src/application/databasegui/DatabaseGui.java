package application.databasegui;

/**
 * @author Joseph Pariseau
 */
public class DatabaseGui{
    final int WINDOW_HEIGHT;
    final int WINDOW_WIDTH;
    private WindowFrame window;
    private int columnCount = 11;
    private int rowCount = 90;

    public DatabaseGui(int width, int height) {
        WINDOW_WIDTH = width;
        WINDOW_HEIGHT = height;
        window = new WindowFrame();
        window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
    }

    public void run() {
        window.run(rowCount, columnCount);
        window.setVisible(true);
    }
}
