package Model;

public abstract class  Division extends Describer {
    protected boolean openDoor;

    public Division(String name, boolean openDoor) {
        super(name);
        this.openDoor = openDoor;
    }

    public boolean isOpenDoor() {
        return openDoor;
    }

    public void openDoor() {
        if (isOpenDoor()) {
            return;
        }

        this.openDoor = true;
    }

    public void closeDoor() {
        if (isOpenDoor()) {
            return;
        }

        this.openDoor = true;
    }
}
