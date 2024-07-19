package main;

import java.util.ArrayList;
import java.util.List;

public class MaintenanceHistory {
    private List<Maintenance> maintenanceList;

    public MaintenanceHistory() {
        this.maintenanceList = new ArrayList<>();
    }

    public void addMaintenance(Maintenance maintenance) {
        maintenanceList.add(maintenance);
    }

    public List<Maintenance> getMaintenanceList() {
        return maintenanceList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Maintenance maintenance : maintenanceList) {
            sb.append(maintenance).append("\n");
        }
        return sb.toString();
    }
}
