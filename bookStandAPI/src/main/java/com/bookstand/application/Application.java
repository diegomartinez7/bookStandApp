package com.bookstand.application;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bookstand.application.models.AutorModel.Autor;
import com.bookstand.application.models.EditorialModel.Editorial;
import com.bookstand.application.models.LibroModel.Libro;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@SpringBootApplication
@EnableEncryptableProperties
public class Application {
	
	@Value("${jasyptEncryptorPassword}")
    private String jasyptEncryptorPassword;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		Autor autor1 = new Autor(
			"Alexandre Dumas Davy de la Pailleterie", 
			"Alexandre Dumas", 
			"Francia", 
			"1802", 
			"Escritor de novelas, folletines y obras de teatro, Alejandro Dumas fue uno de los autores más famosos de la Francia del siglo XIX, y acabó convirtiéndose en un clásico de la literatura gracias a obras como Los tres mosqueteros (1844) o El conde de Montecristo (1845).",
			null
		);

		Editorial editorial1 = new Editorial(
			"Grupo Planeta",
			"España",
			"https://www.planetadelibros.com/",
			null
		);

		Libro libro1 = new Libro(
			"9788490744703", 
			"El Tulipán Negro", 
			editorial1, 
			autor1, 
			"Tapa dura", 
			"Novela histórica", 
			272, 
			"Francés", 
			"1850", 
			"Esta novela comienza con el linchamiento del primer ministro holandés, Johann de Witt, y su hermano, Cornelis, por un grupo que, en apariencia, no comulga con sus políticas de estado. La trama se centra en los once meses posteriores al asesinato, cuando en la ciudad de Haarlem se celebra un concurso que busca a quien pueda cultivar un tulipán negro.", 
			470,
			null,
			null
		);

		System.out.println(libro1);
	}

	@Bean(name = "jasyptStringEncryptor")
    public StringEncryptor stringEncryptor() {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(jasyptEncryptorPassword);
        config.setAlgorithm("PBEWITHHMACSHA512ANDAES_256");
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setIvGeneratorClassName("org.jasypt.iv.RandomIvGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);
        return encryptor;
    }
}
