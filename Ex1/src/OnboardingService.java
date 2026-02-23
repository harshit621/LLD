
public class OnboardingService {
    private final FakeDb db;
    private final Parser parser;
    private final Validator vld;
    private final GenerateId gid;

    public OnboardingService(FakeDb db, Parser parser, Validator vld, GenerateId gid) { 
        this.db = db;
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
            db.save(rec);
        }
    }
}
