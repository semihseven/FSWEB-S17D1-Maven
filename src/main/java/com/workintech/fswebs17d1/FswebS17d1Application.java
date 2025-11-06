package com.workintech.fswebs17d1;


import com.workintech.fswebs17d1.controller.AnimalController;
import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FswebS17d1Application {

    @Value("${course.name}")
    private String courseName;

    @Value("${project.developer.fullname}")
    private String devName;

	public static void main(String[] args) {
		SpringApplication.run(FswebS17d1Application.class, args);


	}

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            /*
            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

             */

            System.out.println("====HELLO WORLD====");
            System.out.println("Course Name: " + courseName);
            System.out.println("Developer Name: " + devName);

            AnimalController controller = ctx.getBean(AnimalController.class);

            Animal animal1 = new Animal(1,"Maymun");
            Animal animal2 = new Animal(2,"Kuş");
            Animal animal3 = new Animal(3,"Aslan");
            Animal animal4 = new Animal(4,"Kaplan");

            controller.save(animal1);
            controller.save(animal2);
            controller.save(animal3);
            controller.save(animal4);

            List<Animal> animals = controller.findAll();

            System.out.println("All Animals:");
            for(Animal a:animals) {
                System.out.println("("+a.getId()+") " + a.getName());
            }

            System.out.println("Single Animal");
            Animal sample = controller.findById(2);
            System.out.println("("+sample.getId()+") "+sample.getName());

            System.out.println("Update Animal");


        };
    }

}
