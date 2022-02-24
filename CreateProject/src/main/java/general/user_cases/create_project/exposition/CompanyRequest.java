package general.user_cases.create_project.exposition;

public class CompanyRequest {
    public String name;
    public String id;

    @Override
    public String toString() {
        return "companyNameDTO{" +
                "Name='" + name + '\'' +
                "Id='" + id + '\'' +
                '}';
    }
}
