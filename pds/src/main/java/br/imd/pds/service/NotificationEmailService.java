package br.imd.pds.service;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import br.imd.pds.model.Equipment;

public class NotificationEmailService{
	
	@Autowired
    private JavaMailSender emailSender;
	
	public static final String subject = "Lembrete de manutenção";
 
	public NotificationEmailService(JavaMailSender emailSender) {
		this.emailSender = emailSender;
	}
	
    public void sendNotification(String to, Equipment equipment) {
        SimpleMailMessage message = new SimpleMailMessage();
        String date = new SimpleDateFormat("EEE, dd MMM yyyy").format(equipment.getNextMaintenance());
        String text = "A máquina portadora do número de série "
        				+ equipment.getSerialNumber() 
        				+ " tem sua próxima manutenção agendada para a data "
        				+ date
        				+ ".";
        message.setTo(to); 
        message.setSubject(subject); 
        message.setText(text);
        emailSender.send(message);
    }
}
