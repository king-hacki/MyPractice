package item_18_composition_over_inehritence;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class ForwardingDog<Dog> implements Set<Dog> {

    private final Set<Dog> d;

    public ForwardingDog(Set<Dog> d) {
        this.d = d;
    }

    @Override
    public int size() { return d.size(); }

    @Override
    public boolean isEmpty() { return d.isEmpty(); }

    @Override
    public boolean contains(Object o) { return d.contains(o); }

    @Override
    public Iterator<Dog> iterator() { return d.iterator(); }

    @Override
    public Object[] toArray() { return d.toArray(new Object[0]); }

    @Override
    public <T> T[] toArray(T[] a) { return d.toArray(a); }

    @Override
    public boolean add(Dog dog) { return d.add(dog); }

    @Override
    public boolean remove(Object o) { return d.remove(o); }

    @Override
    public boolean containsAll(Collection<?> c) { return d.containsAll(c); }

    @Override
    public boolean addAll(Collection<? extends Dog> c) { return d.addAll(c); }

    @Override
    public boolean retainAll(Collection<?> c) { return d.retainAll(c); }

    @Override
    public boolean removeAll(Collection<?> c) { return d.removeAll(c); }

    @Override
    public void clear() { d.clear();}
}
