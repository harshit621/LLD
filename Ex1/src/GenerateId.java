public class GenerateId {
    Repository repo;

    public GenerateId(Repository repo) {
        this.repo = repo;
    }
    public String generate(Student std) {
        String id = IdUtil.nextStudentId(repo.count());
        return id;
    }
}
