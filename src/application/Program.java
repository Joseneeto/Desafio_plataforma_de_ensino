package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Lesson;
import entities.Task;
import entities.Video;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Lesson> list = new ArrayList<>();
		
		System.out.print("Quantas aulas tem o curso? ");
		int n = sc.nextInt();
		System.out.println();
		
		for(int i=0; i<n; i++) {
			System.out.println("Dados da " + (i+1) + "a aula:");
			System.out.print("Conteúdo ou tarefa (c/t)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Título: ");
			sc.nextLine();
			String title = sc.nextLine();
			if(ch == 'c') {
				System.out.print("URL do vídeo: ");
				String url = sc.next();
				System.out.print("Duração em segundos: ");
				int duration = sc.nextInt();
				
				Lesson lesson = new Video(title, url, duration);
				list.add(lesson);
				
			}else {
				System.out.print("Descrição: ");
				String description = sc.nextLine();
				System.out.print("Quantidade de questões: ");
				int questionCount = sc.nextInt();
				
				Lesson lesson = new Task(title, description, questionCount);
				list.add(lesson);
			}
			System.out.println();
		}
		
		int sec = 0;
		for(Lesson x : list) {
			sec += x.duration();
		}
		
		System.out.printf("DURAÇÃO TOTAL DO CURSO = %d SEGUNDOS", sec);
			
		sc.close();
	}

}
