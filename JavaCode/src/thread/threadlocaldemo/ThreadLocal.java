package thread.threadlocaldemo;


import java.lang.ref.WeakReference;

public class ThreadLocal<T> {
    static class ThreadLocalMap<T> {

        private static final int INITIAL_CAPACITY = 16;
        Entry[] table;

        ThreadLocalMap(ThreadLocal<?> key, Object first) {
            table = new Entry[16];
            int i = key.hashCode() & INITIAL_CAPACITY;
            table[i] = new Entry(key, first);

        }

        private Entry get(ThreadLocal tThreadLocal) {
            Entry e = table[tThreadLocal.hashCode() & table.length - 1];
            return e;
        }

        static class Entry extends WeakReference<ThreadLocal<?>> {
            Object value;

            Entry(ThreadLocal<?> referent, Object v) {
                super(referent);
                value = v;
            }
        }

        void set(ThreadLocal key, T value) {
            Entry[] tab = table;
            int i = key.hashCode() & (tab.length - 1);
            for (Entry e = tab[i];
                 e != null;
                 e = tab[(i + 1) < tab.length ? ++i : 0]) {
                ThreadLocal k = e.get();
                if (k == key) {
                    tab[i].value = value;
                    return;
                }
                if (k == null) {
                    replaceStaleEntry(key, value, i);
                }
            }
            tab[i].value = value;
        }

        private void replaceStaleEntry(ThreadLocal<?> key, T value, int i) {

        }

    }

    public void set(T value) {
        Thread currentThread = Thread.currentThread();
        ThreadLocalMap<T> map = getMap(currentThread);

        if (map != null) {
            map.set(this, value);
        } else {
            createMap(currentThread, value);
        }

    }

    private void createMap(Thread thread, T value) {
        thread.threadLocals = new ThreadLocalMap(this, value);
    }


    public T get() {
        Thread t = Thread.currentThread();
        ThreadLocalMap map = getMap(t);
        if (map != null) {
            ThreadLocalMap.Entry entry = map.get(this);
            if (entry != null) {
                @SuppressWarnings("unchecked")
                T v = (T) entry.value;
                return v;
            }
        }

        return null;
    }

    private ThreadLocalMap getMap(Thread t) {
        return t.threadLocals;
    }
}
