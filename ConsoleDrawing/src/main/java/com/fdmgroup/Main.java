package com.fdmgroup;

import java.util.Scanner;

public class Main {

	static String Input;
	static Canvas c = new Canvas();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Basic Console Drawing");
		System.out.println("Enter Command: ");
//		String firstInput = sc.nextLine().toUpperCase();
//		if (!firstInput.equals("Q")) {
//			processInput(firstInput);
//			c.print();
//			System.out.println("Enter Command: ");
			String subInput = sc.nextLine();
			while (!subInput.equals("Q")) {
				processInput(subInput);
				c.print();
				System.out.println("Enter Command: ");
				subInput = sc.nextLine();//.toUpperCase();
				}
			System.out.println("Quitting Program..");
			sc.close();
			}
	
//		} else {
//			System.out.println("Quitting Program...");
//			System.exit(0);
//		}
//		sc.close();
//	}

	public static void processInput(String Input) {
		Input = Input.replaceAll("\\s", " ");
		String[] split = Input.split(" ");
		String mainCommand = split[0].toUpperCase();
		if (mainCommand.equals("Q")) {
			System.out.println("Quitting Program..");
			System.exit(0);
		} else if (mainCommand.equals("C")) {
			int w = Integer.parseInt(split[1]);
			int h = Integer.parseInt(split[2]);
			c.drawCanvas(w, h);
		} else if (mainCommand.equals("L")) {
			int x1 = Integer.parseInt(split[1]);
			int y1 = Integer.parseInt(split[2]);
			int x2 = Integer.parseInt(split[3]);
			int y2 = Integer.parseInt(split[4]);
			c.Line(x1, y1, x2, y2);
		} else if (mainCommand.equals("R")) {
			int x1 = Integer.parseInt(split[1]);
			int y1 = Integer.parseInt(split[2]);
			int x2 = Integer.parseInt(split[3]);
			int y2 = Integer.parseInt(split[4]);
			c.drawRec(x1, y1, x2, y2);
		} else if (mainCommand.equals("B")) {
			int x = Integer.parseInt(split[1]);
			int y = Integer.parseInt(split[2]);
			char colour = split[3].charAt(0);
			c.bucFill(x, y, colour);
		} else {
			System.out.println("Invalid Command");
		}
	}

}
