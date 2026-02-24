import java.util.*;

public class FakeDb implements Repository{
    private final List<StudentRecord> rows = new ArrayList<>();

    @Override
    public void save(StudentRecord r) {
        rows.add(r); 
        print(r);
    }
    @Override
    public int count() { 
        return rows.size(); 
    }
    @Override
    public List<StudentRecord> all() { 
        return Collections.unmodifiableList(rows);
    }
    public void print(StudentRecord rec) {
        System.out.println("OK: created student " + rec.id);
        System.out.println("Saved. Total students: " + rows.size());
        System.out.println("CONFIRMATION:");
        System.out.println(rec);
    }
}
