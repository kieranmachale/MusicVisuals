package C16777089;

import processing.data.TableRow;

public class Menu {
    
    private String menuItem;

    public Menu(TableRow row)
    {
        menuItem = row.getString("VISUALISERS");
    }

    public Menu(String menuItem)
    {   
        this.menuItem = menuItem;
    }

    public String getMenuItem()
    {
        return menuItem;
    }
}