package framework.board;

import java.util.*;

public class Board {
	protected int width;
	protected int height;
	
	protected Cell[][] cells;
	public static final Cell OUT_OF_BOARD = new Cell(-1, -1);
	
	protected List<Terrain> terrains;
	
	public Board(int x, int y) {
		this.width = x;
		this.height = y;
		this.initCells();
		this.terrains = new ArrayList<Terrain>();
	}
	
	private void initCells() {
		this.cells = new Cell[this.width][this.height];
		for (int i = 0; i < this.width; i++) {
			for (int j = 0; j < this.width; j++) {
				cells[i][j] = new Cell(i, j);
			}
		}
	}
	
	public Cell getCell(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height)
			return null;
		return this.cells[x][y];
	}
	
}
