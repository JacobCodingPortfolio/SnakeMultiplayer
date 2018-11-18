package pl.game.server.singleton;

import pl.game.common.model.Table;

import java.util.ArrayList;
import java.util.List;

public class Tables {

    private static List<Table> tables = new ArrayList<Table>();

    private Tables(){}

    public static synchronized void addTable(Table table) {
    }

    public static synchronized Table getTableById(String id){
        return null;
    }

    public static synchronized List<Table> getTables() {
        return tables;
    }
}
