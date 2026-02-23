

void main() {
    System.out.println("=== Student Onboarding ===");
    FakeDb db = new FakeDb();
    Parser parser = new Parser();
    Validator vld = new Validator();
    GenerateId gid = new GenerateId(db);
    OnboardingService svc = new OnboardingService(db, parser, vld, gid);

    String raw = "name=Riya;email=riya@sst.edu;phone=9876543210;program=CSE";

    // program validation -> its throw error
    String raw1 = "name=Aarav;email=aarav@sst.edu;phone=9876439022;program=IAS"; 

    svc.registerFromRawInput(raw);
    svc.registerFromRawInput(raw1);

    System.out.println();
    System.out.println("-- DB DUMP --");
    System.out.print(TextTable.render3(db));
}
