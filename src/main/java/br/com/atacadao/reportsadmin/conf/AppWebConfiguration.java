package br.com.atacadao.reportsadmin.conf;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.atacadao.reportsadmin.model.PathDiretorioEnum;
import br.com.atacadao.reportsadmin.model.jsch.Transfer;

@Configuration
@ComponentScan(basePackages = "br.com.atacadao.reportsadmin")
@EnableWebMvc
public class AppWebConfiguration extends WebMvcConfigurerAdapter{
	
	

	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}


	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	@Bean
	public JavaMailSender getMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		
		/*
		 * mailSender.setHost("10.113.80.147"); mailSender.setPort(25);
		 * 
		 * Properties mailProperties = new Properties();
		 * mailProperties.put("mail.smtp.auth", false);
		 * mailProperties.put("mail.smtp.starttls.enable", false);
		 * mailProperties.put("mail.debug", "false");// Prints out everything on screen
		 * 
		 * mailSender.setJavaMailProperties(mailProperties);
		 */

		// Using gmail		
		  mailSender.setHost("smtp.gmail.com"); mailSender.setPort(587);
		  mailSender.setUsername("adrianomilitao@gmail.com");
		  mailSender.setPassword("militao150506");
		  
		  Properties javaMailProperties = new Properties();
		  javaMailProperties.put("mail.smtp.starttls.enable", "true");
		  javaMailProperties.put("mail.smtp.auth", "true");
		  javaMailProperties.put("mail.transport.protocol", "smtp");
		  javaMailProperties.put("mail.debug", "true");//Prints out everything on  screen
		  
		  mailSender.setJavaMailProperties(javaMailProperties);
		 

		return mailSender;
	}
	
	@Bean
	public Transfer getTransfer() {	
		
		Transfer transfer = new Transfer();
		transfer.setPathDestino(PathDiretorioEnum.DIR_RECEBIDOS.getPath());
		transfer.setLogin("amilitao");
		transfer.setPassword("123");
		
		return transfer;
		
	}
	
}
