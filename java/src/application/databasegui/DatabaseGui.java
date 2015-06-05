package application.databasegui;

/**
 * @author Joseph Pariseau
 */
public class DatabaseGui{
    final int WINDOW_HEIGHT;
    final int WINDOW_WIDTH;
    private WindowFrame window;

    public DatabaseGui(int width, int height) {
        WINDOW_WIDTH = width;
        WINDOW_HEIGHT = height;
        window = new WindowFrame();
        window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
    }

    public void run() {
        window.run();
        window.setVisible(true);
    }
}
