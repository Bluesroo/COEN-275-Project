package application.databaseabstractions;

/**
 * @author Joseph Pariseau
 */
public class LaborTable extends AbstractTable {
    @Override
    public boolean addItem(Object customer) {
        return true;
    }

    @Override
    public boolean removeItem(int uniqueId) {
        return true;
    }

    @Override
    public boolean editItem(int uniqueId) {
        return true;
    }

    @Override
    public String[] getWholeTable() {
        return new String[0];
    }

    @Override
    public String[] getRows() {
        return new String[0];
    }

    @Override
    public String[] getColumns() {
        return new String[0];
    }
}
