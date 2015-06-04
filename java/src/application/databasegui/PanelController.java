package application.databasegui;

import application.dataabstractions.Customer;

/**
 * Created by Mugen on 6/4/15.
 * @author  David Obatake
 */
public class PanelController {
    private ActionPanel actionPanel;
    private ContentPanel contentPanel;

    public void setContentPanel(ContentPanel contentPanel) {
        this.contentPanel = contentPanel;
    }

    public void setActionPanel(ActionPanel actionPanel){
        this.actionPanel = actionPanel;
    }

    public void copyCustomer(Customer c){
        actionPanel.addToEmailList(c);
    }

    public void removeCustomer(Customer c){
        actionPanel.removeFromEmailList(c);
    }
}
