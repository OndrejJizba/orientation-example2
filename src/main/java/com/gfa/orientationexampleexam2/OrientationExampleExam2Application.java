package com.gfa.orientationexampleexam2;

import com.gfa.orientationexampleexam2.models.ClassA;
import com.gfa.orientationexampleexam2.repositories.ClassARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrientationExampleExam2Application implements CommandLineRunner {

	private final ClassARepository classARepository;

	@Autowired
    public OrientationExampleExam2Application(ClassARepository classARepository) {
        this.classARepository = classARepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(OrientationExampleExam2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		classARepository.save(new ClassA("Radial"));
		classARepository.save(new ClassA("Report"));
		classARepository.save(new ClassA("Sleepy"));
		classARepository.save(new ClassA("Reader"));
		classARepository.save(new ClassA("Sector"));
	}
}
