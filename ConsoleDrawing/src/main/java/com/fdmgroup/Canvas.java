package com.fdmgroup;

public class Canvas {

	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private int width;
	private int height;
	char[][] canvas;

//draw canvas
	public void drawCanvas(int width, int height) {
		this.width = width + 2;
		this.height = height + 2;
		inputCanvas();
	}

	private void inputCanvas() {
		canvas = new char[height][width];
		for (int i = 0; i < height; i++) {
			canvas[i][0] = '|';
			canvas[i][width - 1] = '|';
		}
		for (int i = 0; i < width; i++) {
			canvas[0][i] = '-';
			canvas[height - 1][i] = '-';
		} 
	}
	
	public void print() {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				System.out.print(canvas[i][j]);
			}
			System.out.println();
		}
	}

//draw straight line
	public void Line(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		drawLine();
	}

	private void drawLine() {
//		if(y1==y2 && x1<x2){
//		    for(int i = 0; i<= Math.abs(x2-x1); i++){ 
//		    canvas[x1+i][y1] = 'x';
//		    }
//		}
//
//		// checking for horizontal line, right to left
//		if(y1==y2 && x1>x2){
//		    for(int i = 0; i<=Math.abs(x2-x1); i++){
//		    canvas[x2+i][y1] = 'x';
//		    }
//		}
//
//		// checking for vertical line, top to bottom
//		if(x1==x2 && y1<y2){
//		    for(int i = 0; i<=Math.abs(y1-y2); i++){
//		    canvas[x1][y1+i] = 'x';
//		    }
//		}
//
//		// checking for vertical line, bottom to top
//		if(x1==x2 && y1>y2){
//		    for(int i = 0; i<=Math.abs(y1-y2); i++){
//		    canvas[x1][y2+i] = 'x';
//		    }
//		} 
//	}

	
		canvas[y1][x1]= 'x';
		canvas[y2][x2]= 'x';
		if (y1 == y2) {
			int i = x1;
			while (x2 > i) {
				canvas[y1][i] = 'x';
				i++;
			}
		}
		if (x1 == x2) {
			int j = y1;
			while (y2 > j) {
				canvas[j][x1] = 'x';
				j++;
			}
		}
	}
	
	public void drawRec(int x1, int y1, int x2, int y2) {
		Line(x1, y1, x1, y2);//left
		Line(x1, y1, x2, y1);//top
		Line(x2, y1, x2, y2);//right
		Line(x1, y2, x2, y2);//bottom
		
	}
	public void bucFill(int x, int y, char colour) {
		if ((canvas[y][x] =='-') || (canvas[y][x] =='|') || (canvas[y][x] =='-') || (canvas[y][x] =='x') || (canvas[y][x] == colour)) {
			return;
		}
		else {
			canvas[y][x] = colour;
		bucFill(x-1, y, colour);
		bucFill(x+1, y, colour);
		bucFill(x, y-1, colour);
		bucFill(x, y+1, colour);
		}	
	}
}
