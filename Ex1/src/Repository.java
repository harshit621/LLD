import java.util.*;

public interface Repository {
    public void save(StudentRecord r);
    public int count();
    public List<StudentRecord> all();
}

   

