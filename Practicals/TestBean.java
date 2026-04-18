import java.beans.*;

public class SimpleBean {
    private int value;

    // Support objects
    PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    VetoableChangeSupport vcs = new VetoableChangeSupport(this);

    // Getter
    public int getValue() {
        return value;
    }

    // Setter (Bound + Constrained)
    public void setValue(int newValue) throws PropertyVetoException {
        int oldValue = this.value;

        // Constrained (before change)
        vcs.fireVetoableChange("value", oldValue, newValue);
        // Update value
        this.value = newValue;

        // Bound (after change)
        pcs.firePropertyChange("value", oldValue, newValue);
    }

    // Add listeners
    public void addPropertyChangeListener(PropertyChangeListener l) {
        pcs.addPropertyChangeListener(l);
    }

    public void addVetoableChangeListener(VetoableChangeListener l) {
        vcs.addVetoableChangeListener(l);
    }
}

 Test Class

import java.beans.*;

public class TestBean {
    public static void main(String[] args) {
        SimpleBean obj = new SimpleBean();

        // Bound listener
        obj.addPropertyChangeListener(evt -> {
            System.out.println("Changed: " + evt.getOldValue() + " -> " + evt.getNewValue());
        });

        // Constrained listener (rule: value must be >= 0)
        obj.addVetoableChangeListener(evt -> {
            int newVal = (int) evt.getNewValue();
            if (newVal < 0) {
                throw new PropertyVetoException("Negative not allowed", evt);
            }
        });

        try {
            obj.setValue(10);   // allowed
            obj.setValue(-5);   // rejected
        } catch (PropertyVetoException e) {
            System.out.println("Change Rejected: " + e.getMessage());
        }
    }
}
