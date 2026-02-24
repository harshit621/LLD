

void main() {
    System.out.println("=== Student Onboarding ===");
    Repository repo = new FakeDb();
    Parser parser = new Parser();
    Validator vld = new Validator();
    GenerateId gid = new GenerateId(repo);
    OnboardingService svc = new OnboardingService(repo, parser, vld, gid);

    String raw = "name=Riya;email=riya@sst.edu;phone=9876543210;program=CSE";

    // program validation -> it throws error
    String raw1 = "name=Aarav;email=aarav@sst.edu;phone=9876439022;program=IAS"; 

    svc.registerFromRawInput(raw);
    svc.registerFromRawInput(raw1);

    System.out.println();
    System.out.println("-- DB DUMP --");
    System.out.print(TextTable.render3(repo));
}

