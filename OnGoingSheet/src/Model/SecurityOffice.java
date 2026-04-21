package Model;

import java.util.LinkedList;

public class SecurityOffice extends Division {
    private LinkedList<Security> securityOfficers;

    public SecurityOffice(String name, boolean openDoor) {
        super(name,openDoor);
        securityOfficers = new LinkedList<>();
    }

    public LinkedList<Security> getSecurityOfficers() {
        return securityOfficers;
    }

    public void addSecurity(Security security) {
        if(security == null || securityOfficers.contains(security)) {
            return;
        }
        securityOfficers.add(security);

        security.setSecurityOffice(this);
    }

    public void removeSecurity(Security security) {
        if(security == null || !securityOfficers.contains(security)) {
            return;
        }
        securityOfficers.remove(security);

        security.removeSecurityOffice();
    }
}
