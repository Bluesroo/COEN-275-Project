package application.databaseabstractions;

/**
 * @author Joseph Pariseau
 */
public abstract class abstractTable {
    int rowCount;
    int columnCount;
    public abstract void addItem(Object item);
    public abstract void removeItem(int uniqueId);
    public abstract void editItem(int uniqueId);
    public abstract String[] getWholeTable();
    public abstract String[] getColumns();
    public abstract String[] getRows();
}
