package item_18_composition_over_inehritence;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class DogHashSet<Dog> extends ForwardingDog<Dog> {

    private int count = 0;

    public DogHashSet(Set<Dog> d) {
        super(d);
    }

    @Override
    public boolean add(Dog e) {
        count++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends Dog> c) {
        count += c.size();
        return super.addAll(c);
    }

    public int getCount() {
        return count;
    }
}
