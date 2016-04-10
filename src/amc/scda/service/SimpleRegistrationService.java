package amc.scda.service;

import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.velocity.VelocityEngineUtils;

import amc.scda.entity.User;
import amc.scda.util.Context;

public class SimpleRegistrationService {

	private JavaMailSender mailSender;
	private VelocityEngine velocityEngine;

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void SetVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}

	public void register(User user) {
		sendConfirmationEmail(user);
	}

	private void sendConfirmationEmail(final User user) {
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
				message.setTo(user.getEmail());
				message.setSubject("Confirmação de cadastro");
				message.setFrom("MyImage.com");
				Map<String, Object> model = new HashMap<String, Object>();
				model.put("profile", user);
				model.put("context", Context.getContextPath());
				String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "template/registration-confirmation.vm", "UTF-8", model);
				message.setText(text, true);
			}
		};

		this.mailSender.send(preparator);
	}
}
