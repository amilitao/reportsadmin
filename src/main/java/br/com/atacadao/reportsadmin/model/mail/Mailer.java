package br.com.atacadao.reportsadmin.model.mail;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class Mailer {

	@Autowired
	private JavaMailSender javaMailSender;

	public void sendEmail(Email msg) {

		MimeMessagePreparator preparator = getContentWtihAttachementMessagePreparator(msg);
				
		javaMailSender.send(preparator);

	}

	private MimeMessagePreparator getContentWtihAttachementMessagePreparator(Email msg) {

		MimeMessagePreparator preparator = new MimeMessagePreparator() {

			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

				helper.setSubject(msg.getSubject());
				helper.setFrom(msg.getFrom());
				helper.setTo(msg.getTo());
				helper.setText(msg.getContent());

				// Add a resource as an attachment
				helper.addAttachment(msg.getAttachment().getName(), msg.getAttachment());

			}
		};
		return preparator;
	}

	/*
	 * private MimeMessagePreparator
	 * getContentAsInlineResourceMessagePreparator(Email msg) {
	 * 
	 * MimeMessagePreparator preparator = new MimeMessagePreparator() {
	 * 
	 * public void prepare(MimeMessage mimeMessage) throws Exception {
	 * MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
	 * 
	 * helper.setSubject(msg.getSubject()); helper.setFrom(msg.getFrom());
	 * helper.setTo(msg.getTo().toString());
	 * 
	 * // Add an inline resource. // use the true flag to indicate you need a
	 * multipart message helper.setText("<html>" + "<body>" + "<p>" +
	 * msg.getContent() + "</p><img src='cid:identifier1234'>" + "</body>" +
	 * "</html>", true);
	 * 
	 * helper.addInline("identifier1234", new
	 * ClassPathResource("/images/iconfinger1.png")); } }; return preparator; }
	 */

}
