public class GenerateId {
    FakeDb db;

    public GenerateId(FakeDb db) {
        this.db = db;
    }
    public String generate(Student std) {
        String id = IdUtil.nextStudentId(db.count());
        return id;
    }
}
