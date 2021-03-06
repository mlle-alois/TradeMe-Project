package general;

import general.kernel.CommandBus;
import general.user_cases.apply_for_certificate.application.ApplyForCertificate;
import general.user_cases.apply_for_certificate.domain.GeographicZone;
import general.user_cases.apply_for_certificate.domain.Tradesman;
import general.user_cases.apply_for_certificate.domain.valueObjects.DailyRate;
import general.user_cases.apply_for_certificate.domain.valueObjects.TradesmanId;
import general.user_cases.apply_for_certificate.domain.enums.AptitudeCertificates;
import general.user_cases.apply_for_certificate.domain.enums.Department;
import general.user_cases.apply_for_certificate.domain.enums.Skills;
import general.user_cases.apply_for_certificate.domain.enums.Speciality;
import general.user_cases.apply_for_certificate.domain.repository.TradesmanRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;

@SpringBootApplication
public class
SpringMain {
    public static void main(String[] args) {
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringMain.class, args);

        TradesmanRepository tradesmanRepository = applicationContext.getBean(TradesmanRepository.class);

        CommandBus commandBus = applicationContext.getBean(CommandBus.class);

        TradesmanId tradesmanId = tradesmanRepository.nextIdentity();
        Tradesman tradesman = Tradesman.of(
                tradesmanId,
                Speciality.ELECTRICIAN, new ArrayList<AptitudeCertificates>() {{add(AptitudeCertificates.BEP_ELECTRICIAN);}},
                new ArrayList<Skills>(){{add(Skills.MANAGE_A_TEAM);}}, GeographicZone.of(new ArrayList<Department>(){{add(Department.SEINE_SAINT_DENIS_93);}})
                , DailyRate.of(120));

        tradesmanRepository.add(tradesman);

        System.out.println(tradesman.toString());

        //ModifyTradesmanCertificate modifyTradesmanCertificate = new ModifyTradesmanCertificate(tradesman.getTradesmanId(), AptitudeCertificates.EDUCATIONAL);

        //commandBus.send(modifyTradesmanCertificate);

        ApplyForCertificate applyForCertificate = new ApplyForCertificate(tradesman,AptitudeCertificates.EDUCATIONAL);

        commandBus.send(applyForCertificate);

        Tradesman test = tradesmanRepository.findById(tradesmanId);

        System.out.println(test.toString());
    }
}
