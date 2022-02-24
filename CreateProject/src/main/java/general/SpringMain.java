package general;

import general.user_cases.create_project.application.ApplyForMembership;
import general.user_cases.create_project.application.ApplyForMembershipCommandHandler;
import general.user_cases.create_project.domain.*;
import general.user_cases.create_project.domain.enums.MemberShipType;
import general.user_cases.create_project.domain.enums.PaymentContextType;
import general.user_cases.create_project.domain.valueObjects.CompanyId;
import general.user_cases.create_project.domain.valueObjects.MemberId;
import general.user_cases.create_project.domain.valueObjects.MemberName;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class 
SpringMain {
    public static void main(String[] args) {
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringMain.class, args);

        //--1. Create Valid User
        ApplyForMembershipCommandHandler membershipCommandHandler = applicationContext.getBean(ApplyForMembershipCommandHandler.class);
        ApplyForMembership applyForMembership = new ApplyForMembership(MemberName.of("Ichai"), Company.of("MLR", CompanyId.of("527484760")),
                Subscription.of(MemberShipType.annual.getValue()), PaymentContextType.masterCard.getValue());
        final MemberId memberId = membershipCommandHandler.handle(applyForMembership);


    }
}
