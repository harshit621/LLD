
public class OnboardingService {
    private final Repository repo;
    private final Parser parser;
    private final Validator vld;
    private final GenerateId gid;

    public OnboardingService(Repository repo, Parser parser, Validator vld, GenerateId gid) { 
        this.repo = repo;
        this.parser = parser;
        this.vld = vld;
        this.gid = gid;
    }
    
    public void registerFromRawInput(String raw) {
        Student std = parser.parse(raw);
        boolean isValid = vld.valid(std);
        if(isValid) {
            String id = gid.generate(std);
            StudentRecord rec = new StudentRecord(id, std);
            repo.save(rec);
        }
    }
}
