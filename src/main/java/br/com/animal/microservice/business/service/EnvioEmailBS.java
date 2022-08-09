package br.com.animal.microservice.business.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Slf4j
@Service
public class EnvioEmailBS {
    private JavaMailSender mailSender;
    private MimeMessage mimeMessage;
    private MimeMessageHelper helper;

//    @Autowired
//    public EnvioEmailBS(JavaMailSender mailSender) {
//        this.mailSender = mailSender;
//        this.mimeMessage = this.mailSender.createMimeMessage();
//        this.helper = new MimeMessageHelper(mimeMessage);
//    }

    public void enviar() {
        this.mailSender.send(this.mimeMessage);

    }

    public void montarMensagemDeEmail(String email, String assunto, String nomeAnimal) {
        try {
            helper.setTo(email);
            helper.setSubject(assunto);
            helper.setText(String.valueOf(montarCorpoDaMensagem(nomeAnimal)), Boolean.TRUE);
        } catch (Exception e) {
            log.error("Erro ao tentar encaminhar o e-mail para o destinatário: {}", email);
        }
    }

    private StringBuilder montarCorpoDaMensagem(String nomeAnimal) {
        StringBuilder mensagem = new StringBuilder();
        mensagem.append("<p> O animal do nome ");
        mensagem.append(nomeAnimal);
        mensagem.append(" foi adotado, por favor entre em contato com a gente para verificar disponibilidade de outros animais.</p>");
        return mensagem;
    }

}
